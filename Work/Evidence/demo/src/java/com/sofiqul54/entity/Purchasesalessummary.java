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
@Table(name = "purchasesalessummary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchasesalessummary.findAll", query = "SELECT p FROM Purchasesalessummary p")
    , @NamedQuery(name = "Purchasesalessummary.findById", query = "SELECT p FROM Purchasesalessummary p WHERE p.id = :id")
    , @NamedQuery(name = "Purchasesalessummary.findByName", query = "SELECT p FROM Purchasesalessummary p WHERE p.name = :name")
    , @NamedQuery(name = "Purchasesalessummary.findByPCode", query = "SELECT p FROM Purchasesalessummary p WHERE p.pCode = :pCode")
    , @NamedQuery(name = "Purchasesalessummary.findByTotalQuantity", query = "SELECT p FROM Purchasesalessummary p WHERE p.totalQuantity = :totalQuantity")
    , @NamedQuery(name = "Purchasesalessummary.findBySoldQuantity", query = "SELECT p FROM Purchasesalessummary p WHERE p.soldQuantity = :soldQuantity")
    , @NamedQuery(name = "Purchasesalessummary.findByAvailableQuantity", query = "SELECT p FROM Purchasesalessummary p WHERE p.availableQuantity = :availableQuantity")
    , @NamedQuery(name = "Purchasesalessummary.findByLastUpdate", query = "SELECT p FROM Purchasesalessummary p WHERE p.lastUpdate = :lastUpdate")})
public class Purchasesalessummary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 30)
    @Column(name = "pCode")
    private String pCode;
    @Column(name = "totalQuantity")
    private Integer totalQuantity;
    @Column(name = "soldQuantity")
    private Integer soldQuantity;
    @Column(name = "availableQuantity")
    private Integer availableQuantity;
    @Column(name = "lastUpdate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;
    @JoinColumn(name = "pId", referencedColumnName = "id")
    @ManyToOne
    private Cyclepurchase pId;

    public Purchasesalessummary() {
    }

    public Purchasesalessummary(Integer id) {
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

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
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
        if (!(object instanceof Purchasesalessummary)) {
            return false;
        }
        Purchasesalessummary other = (Purchasesalessummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sofiqul54.entity.Purchasesalessummary[ id=" + id + " ]";
    }
    
}
