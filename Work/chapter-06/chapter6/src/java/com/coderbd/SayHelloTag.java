
package com.coderbd;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class SayHelloTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        
        
    getJspContext().getOut().write("Hello Programmers!!!<br>I'm Md. Sofiqul Islam<br>");
    getJspContext().getOut().write("I'm Md. Sofiqul Islam<br>");
    getJspContext().getOut().write("Java Programmer Trainee<br>");
    getJspContext().getOut().write("IDB-BISEW (Round-37)<br>");
    //super.doTag(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
}
