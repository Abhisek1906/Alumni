package com.example.alumni.Bean;

import jakarta.persistence.*;

import javax.json.bind.annotation.JsonbTransient;
import java.util.List;

@Entity
@Table(name = "Organisation")
public class Organisation {
    @Id
    @Column(name="org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int org_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "organisation")
    private List<AlumniOrganisation> organisationList;

    public Organisation(int org_id, String name, String address) {
        this.org_id = org_id;
        this.name = name;
        this.address = address;
    }

    public Organisation() {
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + org_id +
                ", name='" + name + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }
}
