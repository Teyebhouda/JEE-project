/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Houda
 */
@Entity
@Table(name = "dispo3g")
@ManagedBean(name="dispo3g")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dispo3g.findAll", query = "SELECT d FROM Dispo3g d")})
public class Dispo3g  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "BSC_NAME")
    private String BSC_NAME;
    @Size(max = 300)
    @Column(name = "site_3g")
    private String site3g;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val")
    private float val;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
     private Date date;

    public Dispo3g() {
    }

    public Dispo3g(Integer id) {
        this.id = id;
    }

    public Dispo3g(Integer id, String BSC_NAME, String code, float val, Date date) {
        this.id = id;
        this.BSC_NAME = BSC_NAME;
        this.code = code;
        this.val = val;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return BSC_NAME;
    }

    public void setCity(String BSC_NAME) {
        this.BSC_NAME = BSC_NAME;
    }

    public String getSite3g() {
        return site3g;
    }

    public void setSite3g(String site3g) {
        this.site3g = site3g;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof Dispo3g)) {
            return false;
        }
        Dispo3g other = (Dispo3g) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.springhibernate.model.Dispo3g[ id=" + id + " ]";
    }
    
}
