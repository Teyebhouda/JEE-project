/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "dropbssbsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DropBssBsc.findAll", query = "SELECT d FROM DropBssBsc d")})
public class DropBssBsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "BSC_NAME")
    private String bscName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_TRAFFIC")
    private float tchTraffic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAFFIC_HR")
    private float trafficHr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_AVAILABILITY")
    private float tchAvailability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_DROP")
    private float tchDrop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DROP_BSS")
    private float dropBss;

    public DropBssBsc() {
    }

    public DropBssBsc(Integer id) {
        this.id = id;
    }

    public DropBssBsc(Integer id, String bscName, Date date, float tchTraffic, float trafficHr, float tchAvailability, float tchDrop, float dropBss) {
        this.id = id;
        this.bscName = bscName;
        this.date = date;
        this.tchTraffic = tchTraffic;
        this.trafficHr = trafficHr;
        this.tchAvailability = tchAvailability;
        this.tchDrop = tchDrop;
        this.dropBss = dropBss;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTchTraffic() {
        return tchTraffic;
    }

    public void setTchTraffic(float tchTraffic) {
        this.tchTraffic = tchTraffic;
    }

    public float getTrafficHr() {
        return trafficHr;
    }

    public void setTrafficHr(float trafficHr) {
        this.trafficHr = trafficHr;
    }

    

    public float getTchDrop() {
        return tchDrop;
    }

    public void setTchDrop(float tchDrop) {
        this.tchDrop = tchDrop;
    }

    public float getDropBss() {
        return dropBss;
    }

    public void setDropBss(float dropBss) {
        this.dropBss = dropBss;
    }

    public float getTchAvailability() {
        return tchAvailability;
    }

    public void setTchAvailability(float tchAvailability) {
        this.tchAvailability = tchAvailability;
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
        if (!(object instanceof DropBssBsc)) {
            return false;
        }
        DropBssBsc other = (DropBssBsc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.springhibernate.model.DropBssBsc[ id=" + id + " ]";
    }
    
}
