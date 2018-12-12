/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author User
 */
public class CalendarBean {
    private Calendar calendar;

    public CalendarBean() {
        calendar = Calendar.getInstance();
    }
    
    public Date getTime(){
        return calendar.getTime();
    
    }
    
     public int getHour() {
      return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
      return calendar.get(Calendar.MINUTE);
    }
}
