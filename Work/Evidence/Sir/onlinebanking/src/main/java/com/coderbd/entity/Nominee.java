package com.coderbd.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
    @Table(name = "nominee")
    public class Nominee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       @Column(name = "nominee_name", nullable = false)
       private String nomineeName;
       @Column(name = "mobile")
       private String mobile;
       @Column(name = "date_of_birth", nullable = false)
       @DateTimeFormat(pattern="yyyy-MM-dd")
       private Date dateOfBirth;
       @Column(name = "national_id")
       private String nationalId;

       @Column(name = "gender")
       private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}