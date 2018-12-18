
package beSkilled.controlar;

import beSkilled.model.StudentMod;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StudentCon {
    StudentMod student;

    public StudentMod getStudent() {
        if (student==null) {
            student=new StudentMod();
            
        }
        return student;
    }

    public void setStudent(StudentMod student) {
        this.student = student;
    }
    public void reset(){
    student=new StudentMod();
    }
}
