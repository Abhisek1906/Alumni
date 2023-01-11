package com.example.alumni.DAO.DAOImplementation;

import com.example.alumni.Bean.Alumni;
import com.example.alumni.Bean.AlumniOrganisation;
import com.example.alumni.Bean.Organisation;
import com.example.alumni.DAO.AlumniOrganisationDAO;
import com.example.alumni.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniOrganisationDAOImpl implements AlumniOrganisationDAO{


    @Override
    public boolean addAlumniOrganisation(List<AlumniOrganisation> odetails) {
        try(Session session=HibernateSessionUtil.getSession())
        {
            Transaction t=session.beginTransaction();
            for(AlumniOrganisation odetail:odetails)
            {
                odetail.setAlumni(session.get(Alumni.class,odetail.getAlumni().getA_id()));
                Query fetch=session.createQuery("from Organisation where org_id=:org_name");
                fetch.setParameter("org_name",odetail.getOrganisation().getOrg_id());

                Organisation org=(Organisation) fetch.uniqueResult();
//                if(org==null)

                odetail.setOrganisation(org);
                session.save(odetail);
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
