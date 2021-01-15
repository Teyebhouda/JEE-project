/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao.Impl;

import com.pfe.dao.GenericDao;
import com.pfe.model.Role;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Houda
 */
@Service
public class RoleDao implements GenericDao<Role,Integer>{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Role load(final Integer id) {
        return hibernateTemplate.load(Role.class,id);
    }

    @Override
    public Role get(final Integer id) {
        return hibernateTemplate.get(Role.class,id);
    }

    @Override
    public List<Role> getAll(Class Role) {
        return hibernateTemplate.loadAll(Role.class);
    }

    @Override
    public Serializable save(final Role object) {
        return hibernateTemplate.save(object);
    }

    @Override
    public void saveOrUpdate(final Role object) {
        hibernateTemplate.saveOrUpdate(object);
    }

    @Override
    public void delete(final Role object) {
        hibernateTemplate.delete(object);
    }

    @Override
    public Long count() {
        return new Long(hibernateTemplate.loadAll(Role.class).size());
    }

    @Override
    public void flush() {
        hibernateTemplate.flush();
    }

    @Override
    public Role findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxId() {
String hql= "SELECT max(r.roleId) FROM Role r"; 
List list = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql).list(); 
int maxID = ( (Integer)list.get(0) ).intValue(); 
    return maxID;
    }

    

    

    @Override
    public List<Role> getAllbydate(String d1, String d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getAllbyBscName(String d1, String d2, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Role object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}

