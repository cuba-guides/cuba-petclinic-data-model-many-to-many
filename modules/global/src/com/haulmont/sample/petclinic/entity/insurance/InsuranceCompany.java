package com.haulmont.sample.petclinic.entity.insurance;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.sample.petclinic.entity.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "PETCLINIC_INSURANCE_COMPANY")
@Entity(name = "petclinic_InsuranceCompany")
public class InsuranceCompany extends NamedEntity {
    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "insuranceCompany")
    protected List<InsuranceMembership> memberships;

    public List<InsuranceMembership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<InsuranceMembership> memberships) {
        this.memberships = memberships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}