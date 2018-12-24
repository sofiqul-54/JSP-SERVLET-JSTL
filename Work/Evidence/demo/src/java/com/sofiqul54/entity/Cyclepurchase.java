/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cyclepurchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cyclepurchase.findAll", query = "SELECT c FROM Cyclepurchase c")
    , @NamedQuery(name = "Cyclepurchase.findById", query = "SELECT c FROM Cyclepurchase c WHERE c.id = :id")
    , @NamedQuery(name = "Cyclepurchase.findByName", query = "SELECT c FROM Cyclepurchase c WHERE c.name = :name")
    , @NamedQuery(name = "Cyclepurchase.findByPCode", query = "SELECT c FROM Cyclepurchase c WHERE c.pCode = :pCode")
    , @NamedQuery(name = "Cyclepurchase.findByQuantity", query = "SELECT c FROM Cyclepurchase c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "Cyclepurchase.findByUnitPrice", query = "SELECT c FROM Cyclepurchase c WHERE c.unitPrice = :unitPrice")
    , @NamedQuery(name = "Cyclepurchase.findByTotalPrice", query = "SELECT c FROM Cyclepurchase c WHERE c.totalPrice = :totalPrice")
    , @NamedQuery(name = "Cyclepurchase.findByPurchaseDate", query = "SELECT c FROM Cyclepurchase c WHERE c.purchaseDate = :purchaseDate")})
public class Cyclepurchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 30)
    @Column(name = "pCode")
    private String pCode;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unitPrice")
    private Double unitPrice;
    @Column(name = "totalPrice")
    private Double totalPrice;
    @Column(name = "purchaseDate")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @OneToMany(mappedBy = "pId")
    private Collection<Purchasesalessummary> purchasesalessummaryCollection;
    @OneToMany(mappedBy = "pId")
    private Collection<Cyclesales> cyclesalesCollection;

    public Cyclepurchase() {
    }

    public Cyclepurchase(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPCode() {
        return pCode;
    }

    public void setPCode(String pCode) {
        this.pCode = pCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @XmlTransient
    public Collection<Purchasesalessummary> getPurchasesalessummaryCollection() {
        return purchasesalessummaryCollection;
    }

    public void setPurchasesalessummaryCollection(Collection<Purchasesalessummary> purchasesalessummaryCollection) {
        this.purchasesalessummaryCollection = purchasesalessummaryCollection;
    }

    @XmlTransient
    public Collection<Cyclesales> getCyclesalesCollection() {
        return cyclesalesCollection;
    }

    public void setCyclesalesCollection(Collection<Cyclesales> cyclesalesCollection) {
        this.cyclesalesCollection = cyclesalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cyclepurchase)) {
            return false;
        }
        Cyclepurchase other = (Cyclepurchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sofiqul54.entity.Cyclepurchase[ id=" + id + " ]";
    }
    
}
