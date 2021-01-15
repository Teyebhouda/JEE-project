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
@Table(name = "dropbsscellules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dropbsscellules.findAll", query = "SELECT d FROM Dropbsscellules d")})
public class Dropbsscellules implements Serializable {

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
    private String BSC_NAME;
    @Size(max = 22)
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "cell")
    private String cell;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_TRAFFIC")
    private float tchTraffic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_AVAILIBILITY")
    private float tchAvailibility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_DROP")
    private float tchDrop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DROP_BSS")
    private float dropBss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBR_DROP_BSS")
    private float nbrDropBss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Dropbsscellules() {
    }

    public Dropbsscellules(Integer id) {
        this.id = id;
    }

    public Dropbsscellules(Integer id, String BSC_NAME, String cell, float tchTraffic, float tchAvailibility, float tchDrop, float dropBss, float nbrDropBss, Date date) {
        this.id = id;
        this.BSC_NAME = BSC_NAME;
        this.cell = cell;
        this.tchTraffic = tchTraffic;
        this.tchAvailibility = tchAvailibility;
        this.tchDrop = tchDrop;
        this.dropBss = dropBss;
        this.nbrDropBss = nbrDropBss;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public float getTchTraffic() {
        return tchTraffic;
    }

    public void setTchTraffic(float tchTraffic) {
        this.tchTraffic = tchTraffic;
    }

    public float getTchAvailibility() {
        return tchAvailibility;
    }

    public void setTchAvailibility(float tchAvailibility) {
        this.tchAvailibility = tchAvailibility;
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

    public float getNbrDropBss() {
        return nbrDropBss;
    }

    public void setNbrDropBss(float nbrDropBss) {
        this.nbrDropBss = nbrDropBss;
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
        if (!(object instanceof Dropbsscellules)) {
            return false;
        }
        Dropbsscellules other = (Dropbsscellules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.springhibernate.model.Dropbsscellules[ id=" + id + " ]";
    }
    
}
