package com.sofiqul54.bean;

import com.sofiqul54.entity.Student;
import com.sofiqul54.service.StudentService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Studentbean {
    private StudentService service = new StudentService();
    private String[] courseCompleted;
    private Student student;

    public void save() {
        String cc = "";
        for (String s : courseCompleted) {
            cc += s + ",";
        }
        student.setCompletedCourse(cc);
        service.saveorUpdate(student);
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

    
    
}
