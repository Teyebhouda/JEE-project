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
@Table(name = "disponibilitebsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilitebsc.findAll", query = "SELECT d FROM Disponibilitebsc d")})
public class Disponibilitebsc implements Serializable {

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
    private String site;
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
    @Column(name = "Traffic_HR")
    private float trafficHR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Config_TCH_Number")
    private float configTCHNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_AVAILIBILITY")
    private float tchAvailibility;

    public Disponibilitebsc() {
    }

    public Disponibilitebsc(Integer id) {
        this.id = id;
    }

    public Disponibilitebsc(Integer id, String bscName, Date date, float tchTraffic, float trafficHR, float configTCHNumber, float tchAvailibility) {
        this.id = id;
        this.site = bscName;
        this.date = date;
        this.tchTraffic = tchTraffic;
        this.trafficHR = trafficHR;
        this.configTCHNumber = configTCHNumber;
        this.tchAvailibility = tchAvailibility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBSC_NAME() {
        return site;
    }

    public void setBSC_NAME(String site) {
        this.site = site;
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

    public float getTrafficHR() {
        return trafficHR;
    }

    public void setTrafficHR(float trafficHR) {
        this.trafficHR = trafficHR;
    }

    public float getConfigTCHNumber() {
        return configTCHNumber;
    }

    public void setConfigTCHNumber(float configTCHNumber) {
        this.configTCHNumber = configTCHNumber;
    }

    public float getTchAvailibility() {
        return tchAvailibility;
    }

    public void setTchAvailibility(float tchAvailibility) {
        this.tchAvailibility = tchAvailibility;
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
        if (!(object instanceof Disponibilitebsc)) {
            return false;
        }
        Disponibilitebsc other = (Disponibilitebsc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.springhibernate.model.Disponibilitebsc[ id=" + id + " ]";
    }
    
}
