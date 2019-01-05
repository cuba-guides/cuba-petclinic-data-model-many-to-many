package com.haulmont.sample.petclinic.entity.vet;

import com.haulmont.sample.petclinic.entity.NamedEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "PETCLINIC_SPECIALTY")
@Entity(name = "petclinic_Specialty")
public class Specialty extends NamedEntity {
    private static final long serialVersionUID = -1397207634482158673L;

    @JoinTable(name = "PETCLINIC_VET_SPECIALTY_LINK",
            joinColumns = @JoinColumn(name = "SPECIALTY_ID"),
            inverseJoinColumns = @JoinColumn(name = "VET_ID"))
    @ManyToMany
    protected List<Vet> vets;

    public List<Vet> getVets() {
        return vets;
    }

    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
}