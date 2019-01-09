
package test;

import entity.Student;
import service.StudentService;


public class Test {
    
    public static void main(String[] args) {
        StudentService studentService=new StudentService();
        Student student=new Student();
//        student.setId(1);
        student.setName("Mahbub");
        student.setRound("Round-37");
        student.setCoruseCompleted("Hsc");
        student.setGender("Male");
        studentService.saveorUpdate(student);
        
        System.out.println("Success");
    }
    
}
