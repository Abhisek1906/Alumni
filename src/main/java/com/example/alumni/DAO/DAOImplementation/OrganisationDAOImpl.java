package com.example.alumni.DAO.DAOImplementation;

import com.example.alumni.Bean.Organisation;
import com.example.alumni.DAO.OrganisationDAO;
import com.example.alumni.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OrganisationDAOImpl implements OrganisationDAO{
    @Override
    public List<Organisation> getAll() {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            List<Organisation> orgList = new ArrayList<>();
            for (final Object d : session.createQuery("from Organisation ").list()) {
                orgList.add((Organisation) d);
            }
            t.commit();
            return orgList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean addOrganisation(Organisation obj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(obj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Organisation getOrgByName(String name) {
        try(Session session=HibernateSessionUtil.getSession())
        {
            Transaction t=session.beginTransaction();
            Query fetch=session.createQuery("from Organisation where name=:str");
            fetch.setParameter("str",name);
            Organisation org= (Organisation) fetch.uniqueResult();
            t.commit();
            if(org!=null)
                return org;
            else return null;
        }
        catch(HibernateException exception)
        {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }
}
