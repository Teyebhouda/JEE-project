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
@Table(name = "disponibilite_cell")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibiliteCell.findAll", query = "SELECT d FROM DisponibiliteCell d")})
public class DisponibiliteCell implements Serializable {

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
    @Size(max = 22)
    @Column(name = "Site_name")
    private String sitename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "CELL_NAME")
    private String cellName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_TRAFFIC_BH")
    private float tchTrafficBh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TCH_CONGESTION_BH")
    private Float tchCongestionBh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVG_AVAILIBILITY_TCH")
    private float avgAvailibilityTch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFIG_TCH_NUM")
    private float configTchNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCH_AVAILABILITY")
    private float tchAvailability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public DisponibiliteCell() {
    }

    public DisponibiliteCell(Integer id) {
        this.id = id;
    }

    public DisponibiliteCell(Integer id, String bscName, String cellName, float tchTrafficBh, float avgAvailibilityTch, float configTchNum, float tchAvailability, Date date) {
        this.id = id;
        this.bscName = bscName;
        this.cellName = cellName;
        this.tchTrafficBh = tchTrafficBh;
        this.avgAvailibilityTch = avgAvailibilityTch;
        this.configTchNum = configTchNum;
        this.tchAvailability = tchAvailability;
        this.date = date;
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

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public float getTchTrafficBh() {
        return tchTrafficBh;
    }

    public void setTchTrafficBh(float tchTrafficBh) {
        this.tchTrafficBh = tchTrafficBh;
    }

    public Float getTchCongestionBh() {
        return tchCongestionBh;
    }

    public void setTchCongestionBh(Float tchCongestionBh) {
        this.tchCongestionBh = tchCongestionBh;
    }

    public float getAvgAvailibilityTch() {
        return avgAvailibilityTch;
    }

    public void setAvgAvailibilityTch(float avgAvailibilityTch) {
        this.avgAvailibilityTch = avgAvailibilityTch;
    }

    public float getConfigTchNum() {
        return configTchNum;
    }

    public void setConfigTchNum(float configTchNum) {
        this.configTchNum = configTchNum;
    }

    public float getTchAvailability() {
        return tchAvailability;
    }

    public void setTchAvailability(float tchAvailability) {
        this.tchAvailability = tchAvailability;
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
        if (!(object instanceof DisponibiliteCell)) {
            return false;
        }
        DisponibiliteCell other = (DisponibiliteCell) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.journaldev.springhibernate.model.DisponibiliteCell[ id=" + id + " ]";
    }
    
}
