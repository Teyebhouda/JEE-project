/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.Dispo3gDao;
import com.pfe.model.Dispo3g;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Houda
 */
public class Dispo3GDaoImpl extends GenericDaoImpl<Dispo3g, Integer> implements Dispo3gDao{
private SessionFactory sessionFactory;
  private List listkpa3g = null;

    public Dispo3GDaoImpl() {
        super(Dispo3g.class);
    
    }
    
 

@Override
public List<Dispo3g> alarm3g() {
        System.out.println("ok kap-------");
         String hql= "SELECT d.BSC_NAME,d.site3g,d.code,d.val,d.date,k.kPA3g from Dispo3g d,Kpa k WHERE DATEDIFF(CURDATE(), d.date) <7  and d.BSC_NAME = k.bscName3g and d.val < k.kPA3g"; 
       
      Query q = getSessionFactory().createQuery(hql);
        listkpa3g =(List<Dispo3g>) q.list();
    // getSessionFactory().close();
return listkpa3g;


       }
      

    
}
