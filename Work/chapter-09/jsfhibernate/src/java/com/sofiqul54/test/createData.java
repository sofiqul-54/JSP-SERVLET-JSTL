package com.sofiqul54.test;

import com.sofiqul54.entity.Student;
import com.sofiqul54.service.StudentService;
import com.sofiqul54.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class createData {

    public static void main(String[] args) throws Exception {

//        SessionFactory sessFact=HibernateUtil.getSessionFactory();
//        Session session = sessFact.getCurrentSession();
//        Transaction tr = session.beginTransaction();
        StudentService service = new StudentService();
        Student st = new Student();
        st.setName("Adad");
        st.setRound("37");
        st.setGender("Male");
        st.setCompletedCourse("Java, HTML");
        st.setMsg("Hello");
        session.saveOrUpdate(Student);
        tr.commit();
        System.out.println("Successfully Inserted");
        sessFact.close();
    }
}
