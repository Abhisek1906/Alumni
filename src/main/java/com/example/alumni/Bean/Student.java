package com.example.alumni.Bean;


import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column(name = "roll_number",nullable = false,unique = true)
    private String roll_number;

    @Column(name="first_name",nullable = false)
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "graduation_year")
    private int graduation_year;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }


    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(int graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Student() {
    }

    public Student(int student_id, String roll_number, String first_name, String last_name, String email, int graduation_year) {
        this.student_id = student_id;
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.graduation_year = graduation_year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll='" + roll_number + '\'' +
                ", fname='" + first_name + '\'' +
                ", lname='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", year=" + graduation_year +
                '}';
    }
}
