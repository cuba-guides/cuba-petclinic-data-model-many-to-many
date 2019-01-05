package com.haulmont.sample.petclinic.web.insurance.insurancecompany;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.insurance.InsuranceCompany;


@UiController("petclinic_InsuranceCompany.browse")
@UiDescriptor("insurance-company-browse.xml")
@LookupComponent("insuranceCompaniesTable")
@LoadDataBeforeShow
public class InsuranceCompanyBrowse extends StandardLookup<InsuranceCompany> {
}