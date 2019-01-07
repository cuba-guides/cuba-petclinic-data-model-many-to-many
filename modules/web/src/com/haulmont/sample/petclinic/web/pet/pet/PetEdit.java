package com.haulmont.sample.petclinic.web.pet.pet;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.Route;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.insurance.InsuranceCompany;
import com.haulmont.sample.petclinic.entity.insurance.InsuranceMembership;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.List;

@UiController("petclinic_Pet.edit")
@UiDescriptor("pet-edit.xml")
@EditedEntityContainer("petDc")
@LoadDataBeforeShow
public class PetEdit extends StandardEditor<Pet> {

    @Inject
    protected ScreenBuilders screenBuilders;

    @Inject
    protected Metadata metadata;

    @Inject
    protected TimeSource timeSource;

    @Inject
    protected CollectionContainer<InsuranceMembership> insurancesMembershipsDc;

    @Inject
    protected InstanceContainer<Pet> petDc;

    @Subscribe("insurancesMembershipsTable.addInsuranceCompany")
    protected void onAddInsuranceCompany(Action.ActionPerformedEvent event) {

        screenBuilders.lookup(InsuranceCompany.class, this)
            .withLaunchMode(OpenMode.DIALOG)
            .withSelectHandler(insuranceCompanies -> {
                insuranceCompanies.stream()
                    .map(this::createMembershipFromCompany)
                    .forEach(this::addToMemberships);
            })
            .build()
            .show();
    }
    
    private InsuranceMembership createMembershipFromCompany(InsuranceCompany insuranceCompany) {
        InsuranceMembership insuranceMembership = metadata.create(InsuranceMembership.class);
        insuranceMembership.setPet(petDc.getItem());
        insuranceMembership.setInsuranceCompany(insuranceCompany);

        insuranceMembership.setValidFrom(timeSource.currentTimestamp());

        return insuranceMembership;
    }

    private void addToMemberships(InsuranceMembership insuranceMembership) {
        insurancesMembershipsDc.getMutableItems().add(insuranceMembership);
    }
}