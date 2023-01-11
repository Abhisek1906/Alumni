package com.example.alumni.DAO.DAOImplementation;

import com.example.alumni.Bean.Student;
import com.example.alumni.DAO.StudentDAO;
import com.example.alumni.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student getStudent(Student student) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            Query query = session.createQuery("from Student where graduation_year=:g_year and first_name=:fname and last_name=:lname and roll_number=:roll");
            //System.out.println("Before");
            query.setParameter("g_year", student.getGraduation_year());
            //System.out.println("After");
            query.setParameter("fname", student.getFirst_name());
            query.setParameter("lname", student.getLast_name());
            query.setParameter("roll",student.getRoll_number());
            Student alumini=(Student) query.uniqueResult();
            t.commit();
            return alumini;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean addStudent(Student obj) {
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
}
