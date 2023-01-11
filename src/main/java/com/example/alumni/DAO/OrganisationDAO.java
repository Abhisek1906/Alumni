package com.example.alumni.DAO;

import com.example.alumni.Bean.Organisation;
import com.example.alumni.Bean.Student;

import java.util.List;

public interface OrganisationDAO {
    List<Organisation> getAll();
    boolean addOrganisation(Organisation obj);

    Organisation getOrgByName(String name);
}
