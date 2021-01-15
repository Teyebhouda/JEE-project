/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Houda
 */
public interface GenericDao <E,K> {
    
     public List<E> getAll(Class clazz) ;
    public List<E> getAllbyBscName(String d1 ,String d2,String s) ;
    public List<E> getAllbydate(String d1 ,String d2) ;
    public E load(K id);

    public E get(K id);


    public Serializable save(E object);

    public void saveOrUpdate(E object);
    
     public void update(E object);
    
    public void delete(E object);

    public Long count();

    void flush();
    
   E findByUsername(String username);
    
   int getMaxId();
   
}