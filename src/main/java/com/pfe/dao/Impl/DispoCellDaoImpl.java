/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.DispoCellDao;
import com.pfe.model.DisponibiliteCell;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Houda
 */
public class DispoCellDaoImpl extends GenericDaoImpl<DisponibiliteCell, Integer> implements DispoCellDao{
private SessionFactory sessionFactory;

    public DispoCellDaoImpl() {
        super(DisponibiliteCell.class);
}

    @Override
    public List<DisponibiliteCell> alarmDcell(String s) {
String hql= "SELECT d.bscName,d.sitename,d.cellName,d.tchTrafficBh,d.tchCongestionBh,d.avgAvailibilityTch,d.configTchNum,d.tchAvailability,d.date FROM DisponibiliteCell d , Kpa k  WHERE DATEDIFF(CURDATE(), d.date) <7  and d.bscName = k.bscName and d.tchAvailability  < k.kPAdispocell";
      Query q = getSessionFactory().createQuery(hql);
        List listkpaDcell =  q.list();
             System.out.println("ok kap-------");
  // getSessionFactory().close();

             return listkpaDcell;
    }
    
}
