package com.example.alumni.DAO;

import com.example.alumni.Bean.Student;

import java.util.Date;
import java.util.List;

public interface StudentDAO {
    Student getStudent(Student student);

    boolean addStudent(Student obj);
}
