package com.example.alumni.Bean;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "AlumniOrganisation")
public class AlumniOrganisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="alumni_org_id",nullable = true)
    private Organisation organisation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumni_id",nullable = true)
    private  Alumni alumni;

    @Column(nullable = false)
    private  String position;
    @Column(nullable = false)
    private int joining_year;
    private int leaving_year;

    public AlumniOrganisation() {
    }

    public AlumniOrganisation(int id, Organisation organisation, Alumni alumni, String position, int joining_year, int leaving_year) {
        this.id = id;
        this.organisation = organisation;
        this.alumni = alumni;
        this.position = position;
        this.joining_year = joining_year;
        this.leaving_year = leaving_year;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(Alumni alumni) {
        this.alumni = alumni;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(int joining_year) {
        this.joining_year = joining_year;
    }

    public int getLeaving_year() {
        return leaving_year;
    }

    public void setLeaving_year(int leaving_year) {
        this.leaving_year = leaving_year;
    }

    @Override
    public String toString() {
        return "AlumniOrganisation{" +
                "id=" + id +
                ", organisation=" + organisation.toString() +
                ", alumni=" + alumni.toString() +
                ", position='" + position + '\'' +
                ", joining_year='" + joining_year + '\'' +
                ", leaving_year='" + leaving_year + '\'' +
                '}';
    }
}
