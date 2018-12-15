
package com.sofiqul54.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class StudentsController {
   private Student st;

    public Student getS() {
        if(st==null){
        st = new Student();
        }
        
        return st;
    }

    public void setS(Student s) {
        this.st = s;
    }
   
   
   
    
}
