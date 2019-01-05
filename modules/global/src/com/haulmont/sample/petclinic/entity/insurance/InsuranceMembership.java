package com.haulmont.sample.petclinic.entity.insurance;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.sample.petclinic.entity.pet.Pet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "PETCLINIC_INSURANCE_MEMBERSHIP")
@Entity(name = "petclinic_InsuranceMembership")
public class InsuranceMembership extends StandardEntity {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_ID")
    protected Pet pet;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INSURANCE_COMPANY_ID")
    protected InsuranceCompany insuranceCompany;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "VALID_FROM", nullable = false)
    protected Date validFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "VALID_UNTIL")
    protected Date validUntil;

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}