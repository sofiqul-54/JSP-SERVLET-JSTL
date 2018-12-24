/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cyclesales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cyclesales.findAll", query = "SELECT c FROM Cyclesales c")
    , @NamedQuery(name = "Cyclesales.findById", query = "SELECT c FROM Cyclesales c WHERE c.id = :id")
    , @NamedQuery(name = "Cyclesales.findByCname", query = "SELECT c FROM Cyclesales c WHERE c.cname = :cname")
    , @NamedQuery(name = "Cyclesales.findByPname", query = "SELECT c FROM Cyclesales c WHERE c.pname = :pname")
    , @NamedQuery(name = "Cyclesales.findByPCode", query = "SELECT c FROM Cyclesales c WHERE c.pCode = :pCode")
    , @NamedQuery(name = "Cyclesales.findByQuantity", query = "SELECT c FROM Cyclesales c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "Cyclesales.findByUnitPrice", query = "SELECT c FROM Cyclesales c WHERE c.unitPrice = :unitPrice")
    , @NamedQuery(name = "Cyclesales.findByTotalPrice", query = "SELECT c FROM Cyclesales c WHERE c.totalPrice = :totalPrice")
    , @NamedQuery(name = "Cyclesales.findBySalesDate", query = "SELECT c FROM Cyclesales c WHERE c.salesDate = :salesDate")})
public class Cyclesales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "cname")
    private String cname;
    @Size(max = 30)
    @Column(name = "pname")
    private String pname;
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
    @Column(name = "salesDate")
    @Temporal(TemporalType.DATE)
    private Date salesDate;
    @JoinColumn(name = "pId", referencedColumnName = "id")
    @ManyToOne
    private Cyclepurchase pId;

    public Cyclesales() {
    }

    public Cyclesales(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Cyclepurchase getPId() {
        return pId;
    }

    public void setPId(Cyclepurchase pId) {
        this.pId = pId;
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
        if (!(object instanceof Cyclesales)) {
            return false;
        }
        Cyclesales other = (Cyclesales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sofiqul54.entity.Cyclesales[ id=" + id + " ]";
    }
    
}
