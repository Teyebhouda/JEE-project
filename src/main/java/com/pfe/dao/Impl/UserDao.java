/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.GenericDao;
import com.pfe.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Houda
 */
@Service
public class UserDao implements GenericDao<User,String>  {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public User load(final String id) {
        return hibernateTemplate.load(User.class,id);
    }

    @Override
    public User get(final String id) {
        return hibernateTemplate.get(User.class,id);
    }
    
     public User getbyid( final Integer id) {
        return hibernateTemplate.get(User.class,id);
    }

    @Override
    public List<User> getAll(Class User) {
      //  return hibernateTemplate.loadAll(User.class);
    String hql= "SELECT u.userId,u.firstName,u.lastName,u.username,u.email,u.password,u.enabled,r.role from User u,Role r WHERE u.userId = r.user"; 
List list = hibernateTemplate.getSessionFactory().openSession().createQuery(hql).list(); 
return list;
    
    }

    @Override
    public Serializable save(final User object) {
        return hibernateTemplate.save(object);
    }

    @Override
    public void saveOrUpdate(final User object) {
        hibernateTemplate.saveOrUpdate(object);
    }
    
@Override
    public void update(final User object) {
        hibernateTemplate.update(object);
    }
    @Override
    public void delete(final User object) {
        hibernateTemplate.delete(object);
    }

    @Override
    public Long count() {
        return new Long(hibernateTemplate.loadAll(User.class).size());
    }

    @Override
    public void flush() {
        hibernateTemplate.flush();
    }

    @Override
    public User findByUsername( String username) {
        List<User> users = new ArrayList<User>();

		users = hibernateTemplate.getSessionFactory().getCurrentSession()
			.createQuery("from User where user_name=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

        
    }

    @Override
    public int getMaxId() {
String hql= "SELECT max(u.userId) FROM User u"; 
List list = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql).list(); 
int maxID = ( (Integer)list.get(0) ).intValue(); 
    return maxID;
        }

    

    

    

    @Override
    public List<User> getAllbyBscName(String d1, String d2, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllbydate(String d1, String d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   

    
    


    
}
