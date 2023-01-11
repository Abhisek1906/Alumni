package com.example.alumni.DAO.DAOImplementation;

import com.example.alumni.Bean.Alumni;
import com.example.alumni.Bean.Student;
import com.example.alumni.DAO.AlumniDAO;
import com.example.alumni.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AlumniDAOImpl implements AlumniDAO {

    @Override
    public boolean addAlumni(Alumni a) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            a.setStudent(session.get(Student.class,a.getStudent().getStudent_id()));
            session.save(a);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean hasRegistered(Alumni alumni) {
        try(Session session =HibernateSessionUtil.getSession())
        {
            Transaction t= session.beginTransaction();
            alumni.setStudent(session.get(Student.class,alumni.getStudent().getStudent_id()));
            Query fetch=session.createQuery("from Alumni where student.student_id=:id");
            fetch.setParameter("id",alumni.getStudent().getStudent_id());
            Alumni temp=(Alumni) fetch.uniqueResult();
            t.commit();
            if(temp==null)
                return true;
            else
            {
                System.out.print("User has already registered!");
                return false;
            }
        }
    }

    @Override
    public Alumni getAlumni(Student st) {
        try(Session session=HibernateSessionUtil.getSession())
        {
            Transaction t= session.beginTransaction();
            Query fetch=session.createQuery("from Alumni where student.student_id=:id");
            fetch.setParameter("id",st.getStudent_id());
            Alumni temp=(Alumni) fetch.uniqueResult();
            t.commit();
            if(temp!=null)
                return temp;
            else return null;
        }
        catch (HibernateException exception)
        {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }
}
