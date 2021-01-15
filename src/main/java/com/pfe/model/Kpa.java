/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Houda
 */
@Entity
@Table(name = "kpa")

@ManagedBean(name="kpa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kpa.findAll", query = "SELECT k FROM Kpa k")
    , @NamedQuery(name = "Kpa.findById", query = "SELECT k FROM Kpa k WHERE k.id = :id")
    , @NamedQuery(name = "Kpa.findByBscName", query = "SELECT k FROM Kpa k WHERE k.bscName = :bscName")
    , @NamedQuery(name = "Kpa.findByBscName3g", query = "SELECT k FROM Kpa k WHERE k.bscName3g = :bscName3g")
    , @NamedQuery(name = "Kpa.findByKPA3g", query = "SELECT k FROM Kpa k WHERE k.kPA3g = :kPA3g")
    , @NamedQuery(name = "Kpa.findByKPAdisobsc", query = "SELECT k FROM Kpa k WHERE k.kPAdisobsc = :kPAdisobsc")
    , @NamedQuery(name = "Kpa.findByKPAdispocell", query = "SELECT k FROM Kpa k WHERE k.kPAdispocell = :kPAdispocell")
    , @NamedQuery(name = "Kpa.findByKPAdropbsc", query = "SELECT k FROM Kpa k WHERE k.kPAdropbsc = :kPAdropbsc")
    , @NamedQuery(name = "Kpa.findByKPAdropcell", query = "SELECT k FROM Kpa k WHERE k.kPAdropcell = :kPAdropcell")})
public class   Kpa  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "BSC_NAME")
    private String bscName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "BSC_NAME3G")
    private String bscName3g;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPA3g")
    private float kPA3g;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPAdisobsc")
    private float kPAdisobsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPAdispocell")
    private float kPAdispocell;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPAdropbsc")
    private float kPAdropbsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPAdropcell")
    private float kPAdropcell;
    public static boolean editable;
    public Kpa() {
    }

    public Kpa(Integer id) {
        this.id = id;
    }

    public Kpa(Integer id, String bscName, String bscName3g, float kPA3g, float kPAdisobsc, float kPAdispocell, float kPAdropbsc, float kPAdropcell) {
        this.id = id;
        this.bscName = bscName;
        this.bscName3g = bscName3g;
        this.kPA3g = kPA3g;
        this.kPAdisobsc = kPAdisobsc;
        this.kPAdispocell = kPAdispocell;
        this.kPAdropbsc = kPAdropbsc;
        this.kPAdropcell = kPAdropcell;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBscName() {
        return bscName;
    }

    public void setBscName(String bscName) {
        this.bscName = bscName;
    }

    public String getBscName3g() {
        return bscName3g;
    }

    public void setBscName3g(String bscName3g) {
        this.bscName3g = bscName3g;
    }

    public float getKPA3g() {
        return kPA3g;
    }

    public void setKPA3g(float kPA3g) {
        this.kPA3g = kPA3g;
    }

    public float getKPAdisobsc() {
        return kPAdisobsc;
    }

    public void setKPAdisobsc(float kPAdisobsc) {
        this.kPAdisobsc = kPAdisobsc;
    }

    public float getKPAdispocell() {
        return kPAdispocell;
    }

    public void setKPAdispocell(float kPAdispocell) {
        this.kPAdispocell = kPAdispocell;
    }

    public float getKPAdropbsc() {
        return kPAdropbsc;
    }

    public void setKPAdropbsc(float kPAdropbsc) {
        this.kPAdropbsc = kPAdropbsc;
    }

    public float getKPAdropcell() {
        return kPAdropcell;
    }

    public void setKPAdropcell(float kPAdropcell) {
        this.kPAdropcell = kPAdropcell;
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
        if (!(object instanceof Kpa)) {
            return false;
        }
        Kpa other = (Kpa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
public boolean isEditable() {
			return editable;
		}
		public static void setEditable(boolean editablee) {
			editablee = editable;
		}
         
    @Override
    public String toString() {
        return "com.pfe.model.Kpa[ id=" + id + " ]";
    }
    
}
