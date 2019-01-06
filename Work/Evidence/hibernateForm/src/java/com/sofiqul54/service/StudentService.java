
package com.sofiqul54.service;

import com.sofiqul54.entity.Student;
import com.sofiqul54.hibernetUtill.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
    public void saveStudent(Student s){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.save(s);
        tr.commit();
        
    }
}
