package com.coderbd.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account_open")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String accountHolderName;
    @Column(nullable = false)
    private long accountNumber;
    private double primaryDepositAmount;
    private double totalWithrawn;
    private double balanceAmount;
    @Column(unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String mobile;
    private String address;
    @Column(nullable = false, unique = true)
    private String nationalId;
    private String profession;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bithDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "ac_type_id", nullable = false)
    private AccountType accountType;

    @ManyToMany
    @JoinTable(
            name = "account_nominee",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "nominee_id"))
    private Set<Nominee> nominees;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getPrimaryDepositAmount() {
        return primaryDepositAmount;
    }

    public void setPrimaryDepositAmount(double primaryDepositAmount) {
        this.primaryDepositAmount = primaryDepositAmount;
    }

    public double getTotalWithrawn() {
        return totalWithrawn;
    }

    public void setTotalWithrawn(double totalWithrawn) {
        this.totalWithrawn = totalWithrawn;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getBithDate() {
        return bithDate;
    }

    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Set<Nominee> getNominees() {
        return nominees;
    }

    public void setNominees(Set<Nominee> nominees) {
        this.nominees = nominees;
    }
}
