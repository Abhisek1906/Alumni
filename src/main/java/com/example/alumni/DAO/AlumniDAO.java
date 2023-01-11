package com.example.alumni.DAO;

import com.example.alumni.Bean.Alumni;
import com.example.alumni.Bean.Student;

public interface AlumniDAO {
    boolean addAlumni(Alumni a);

    boolean hasRegistered(Alumni alumni);

    Alumni getAlumni(Student st);
}
