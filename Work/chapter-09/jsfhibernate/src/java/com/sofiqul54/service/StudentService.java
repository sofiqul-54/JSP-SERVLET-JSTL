package com.sofiqul54.service;

import com.sofiqul54.entity.Student;
import com.sofiqul54.util.HibernateUtil;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    public static void saveOrUpdate(Student student) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(student);
        System.out.println("Success");
        tr.commit();
    }

    public static void delete(Student student) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        System.out.println("Delete Success");
        tr.commit();
    }

    @Transactional
    public static Student getById(int id) {
        Student student = new Student();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Student student = (Student) session.get(Student.class, id);
            Transaction tr = session.beginTransaction();
            tr.commit();
        } catch (Exception e) {
        }

        return null;

    }

    public static List<Student> getByList() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        List<Student> student = session.createCriteria(Student.class).list();
        Transaction tr = session.beginTransaction();
        tr.commit();
        return student;
    }

}
