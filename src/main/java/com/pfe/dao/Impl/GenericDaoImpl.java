/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.GenericDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.RequestScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Houda
 */

@RequestScoped
public  class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> ,Serializable {
             
    private SessionFactory sessionFactory;
    private Session hibernatesession ;
      private Class<E> type;
      private List<E> listbydate = null;
            private List<E> listbysite = null;

    
 
    /**
     * By defining this class as abstract, we prevent Spring from creating instance of this class
     * If not defined abstract getClass().getGenericSuperClass() would return Object.
     * There would be exception because Object class does not hava constructor with parameters.
     * @param type
     */
      

    public GenericDaoImpl(Class<E> type) {
        this.type = type;
        }
    
    
    
    protected Session getSessionFactory() {
        
        return sessionFactory.openSession();
    }
    protected Session getSessionFactory1() {
        return sessionFactory.getCurrentSession();
        
    }
    

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
   
 
     @Override
    public List<E> getAll(Class E) {
        try {
        return getSessionFactory().createCriteria(type).list();
    }catch(Exception e) {
System.out.println(e);
return null;
}}
 @Override
 public List<E> getAllbyBscName(String d1, String d2,String s) {
   			getSessionFactory();
                        
        Query q = getSessionFactory().createQuery("FROM "
					+ type.getName() + " WHERE date between '" + d1+ "' and '" + d2 + "'" +" and BSC_NAME = '"+s+ "'" );
			 listbysite = (List<E>) q.list();
         return listbysite;
    }
 
 @Override
 public List<E> getAllbydate(String d1, String d2) {
   			
        Query q = getSessionFactory().createQuery("FROM "
					+ type.getName() + " WHERE date between '" + d1+ "' and '" + d2 + "'"  );
			 listbydate = (List<E>) q.list();
         return listbydate;
    }
    
       
    @Override
    public E load(K id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(K id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Serializable save(E object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrUpdate(E object) {
       getSessionFactory().saveOrUpdate(object);
       }

    @Override
    public void delete(E object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(E object) {
   getSessionFactory().update(object);
       }

   

    
    
    
    }
		
    
    

