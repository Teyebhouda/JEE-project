/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.Dispo3gDao;
import com.pfe.dao.GenericDao;
import com.pfe.dao.KPADao;
import com.pfe.model.Dispo3g;
import com.pfe.model.Kpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author Houda
 */
public class KPADaoImpl extends GenericDaoImpl<Kpa, Integer> implements KPADao {

    public KPADaoImpl() {
        super(Kpa.class);
    }
 
    
}
