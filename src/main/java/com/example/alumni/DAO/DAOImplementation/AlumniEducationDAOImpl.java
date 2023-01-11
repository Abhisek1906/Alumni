package com.example.alumni.DAO.DAOImplementation;

import com.example.alumni.Bean.Alumni;
import com.example.alumni.Bean.AlumniEducation;
import com.example.alumni.Bean.AlumniOrganisation;
import com.example.alumni.Bean.Organisation;
import com.example.alumni.DAO.AlumniEducationDAO;
import com.example.alumni.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniEducationDAOImpl implements AlumniEducationDAO {
    @Override
    public boolean addAlumniEducation(List<AlumniEducation> obj) {
        try(Session session= HibernateSessionUtil.getSession())
        {
            Transaction t=session.beginTransaction();
            for(AlumniEducation edetail:obj){
                edetail.setAlumni(session.get(Alumni.class,edetail.getAlumni().getA_id()));
                session.save(edetail);
            }
            t.commit();
            return true;
        }
        catch(HibernateException exception){
            System.out.printf(exception.getLocalizedMessage());
            return false;
        }
    }
}
