package com.sofiqul54.been;

import com.sofiqul54.entity.Student;
import com.sofiqul54.service.StudentService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBeen {

    private Student student;
    private String[] courseCompleted;

    public void saveStu() {
    String cc="";
    for (String s : courseCompleted){
    cc+= s + ",";
    }
    student.setCompletedCourse(cc);
    student.setRegDate(new Date());
    
        StudentService service = new StudentService();
        service.saveStudent(student);
        System.out.println("Insert Success");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
    }
    
    

}
