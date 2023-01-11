package com.example.alumni.Bean;

import jakarta.persistence.*;

import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Alumni")
public class Alumni implements Serializable {
    @Id
    @Column(name="a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a_id;


    @Column(name="email",unique = true,nullable = false)
    private String email;

    @Column(name = "contact_number",nullable = false,unique = true)
    private long contact_number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "alumni")
    private List<AlumniOrganisation> organisationList;

    @OneToMany(mappedBy = "alumni")
    private List<AlumniEducation> educationList;

    public Alumni(int a_id, String email, long contact_number, Student student) {
        this.a_id = a_id;
        this.email = email;
        this.contact_number = contact_number;
        this.student = student;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact_number() {
        return contact_number;
    }

    public void setContact_number(long contact_number) {
        this.contact_number = contact_number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Alumni() {
    }

    @Override
    public String toString() {
        return "AlumniDetails{" +
                "id=" + a_id +
                ", email='" + email + '\'' +
                ", contact='" + contact_number + '\'' +
                ", student=" + student.toString() +
                '}';
    }
}
