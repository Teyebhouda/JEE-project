/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.DropBscDao;
import com.pfe.model.DropBssBsc;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Houda
 */
public class DropBscDaoImpl extends GenericDaoImpl<DropBssBsc, Integer> implements DropBscDao{
private SessionFactory sessionFactory;

    public DropBscDaoImpl() {
        super(DropBssBsc.class);
}

    @Override
    public List<DropBssBsc> alarmDrbsc(String s) {
        String hql= "SELECT d.bscName,d.date,d.tchTraffic,d.trafficHr,d.tchAvailability,d.tchDrop,d.dropBss FROM DropBssBsc d , Kpa k  WHERE DATEDIFF(CURDATE(), d.date) <7  and d.bscName = k.bscName and d.tchAvailability < k.kPAdropbsc";
       Query q = getSessionFactory().createQuery(hql);
        List listkpaDcell =  q.list();
             System.out.println("ok kap-------");
   //getSessionFactory().close();

             return listkpaDcell;
    }
   
}
