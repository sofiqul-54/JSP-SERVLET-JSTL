package bean;

import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import service.StudentService;

@ManagedBean
@ViewScoped
public class Studentbean {
    
    private StudentService service = new StudentService();
    private Student student;
    
    private List<Student> list;
    
    private String[] ccompleted;
    
    public void seve() {
        String cc = "";
        for (String s : ccompleted) {
            cc += s + ", ";
            
        }
        student.setCoruseCompleted(cc);
        service.saveorUpdate(student);
    }
    
    public void edit() {
        service.saveorUpdate(student);
    }
    
    public void del() {
        service.delete(student);
    }
    
    public Student searchById(int id) {
        Student s = new Student();
        s = service.getById(id);
        
        return s;
    }
    
    public StudentService getService() {
        return service;
    }
    
    public void setService(StudentService service) {
        this.service = service;
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
    
    public List<Student> getList() {
        list = new ArrayList<>();
        list = service.getList();
        return list;
    }
    
    public void setList(List<Student> list) {
        this.list = list;
    }
    
    public String[] getCcompleted() {
        return ccompleted;
    }
    
    public void setCcompleted(String[] ccompleted) {
        this.ccompleted = ccompleted;
    }
    
    
    
    public void reset(){
    student=new Student();
    }
}
