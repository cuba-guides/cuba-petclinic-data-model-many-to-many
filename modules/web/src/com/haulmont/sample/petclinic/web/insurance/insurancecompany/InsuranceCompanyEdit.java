package com.haulmont.sample.petclinic.web.insurance.insurancecompany;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.insurance.InsuranceCompany;


@UiController("petclinic_InsuranceCompany.edit")
@UiDescriptor("insurance-company-edit.xml")
@EditedEntityContainer("insuranceCompanyDc")
@LoadDataBeforeShow
public class InsuranceCompanyEdit extends StandardEditor<InsuranceCompany> {
}