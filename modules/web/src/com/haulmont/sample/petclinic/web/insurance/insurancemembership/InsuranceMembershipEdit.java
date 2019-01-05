package com.haulmont.sample.petclinic.web.insurance.insurancemembership;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.insurance.InsuranceMembership;


@UiController("petclinic_InsuranceMembership.edit")
@UiDescriptor("insurance-membership-edit.xml")
@EditedEntityContainer("insuranceMembershipDc")
@LoadDataBeforeShow
public class InsuranceMembershipEdit extends StandardEditor<InsuranceMembership> {
}