/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.DispoBscDao;
import com.pfe.model.Disponibilitebsc;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Houda
 */
public class DispoBscDaoImpl extends GenericDaoImpl<Disponibilitebsc, Integer> implements DispoBscDao{
private SessionFactory sessionFactory;

    public DispoBscDaoImpl() {
        super(Disponibilitebsc.class);
    
    }
@Override
public List<Disponibilitebsc> alarmDbsc(String s1) {
        String hql= "SELECT d.site,d.date,d.tchTraffic,d.trafficHR,d.configTCHNumber,d.tchAvailibility,k.kPAdisobsc from Disponibilitebsc d,Kpa k WHERE DATEDIFF(CURDATE(), d.date) <7  and d.site = k.bscName and d.tchAvailibility < k.kPAdisobsc "; 

      Query q = getSessionFactory().createQuery(hql);
        List listkpaDbsc =  q.list();
             System.out.println("ok kap-------");
//getSessionFactory().close();

             return listkpaDbsc;

       }
 
 
}