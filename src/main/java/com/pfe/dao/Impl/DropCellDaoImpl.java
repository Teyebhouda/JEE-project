/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.DropCellDao;
import com.pfe.model.Dropbsscellules;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Houda
 */
public class DropCellDaoImpl extends GenericDaoImpl<Dropbsscellules, Integer> implements DropCellDao{
private SessionFactory sessionFactory;

    public DropCellDaoImpl() {
        super(Dropbsscellules.class);
}

    @Override
    public List<Dropbsscellules> alarmDrcell(String s) {
  String hql= "SELECT d.BSC_NAME,d.site,d.cell,d.tchTraffic,d.tchAvailibility,d.tchDrop,d.dropBss,d.nbrDropBss,d.date FROM Dropbsscellules d , Kpa k  WHERE DATEDIFF(CURDATE(), d.date) <7  and d.BSC_NAME = k.bscName and d.tchAvailibility < k.kPAdropcell";
        Query q = getSessionFactory().createQuery(hql);
        List listkpaDrbsc =  q.list();
             System.out.println("ok kap-------");
          //getSessionFactory().close();
             return listkpaDrbsc;
       }
    
   
}
 