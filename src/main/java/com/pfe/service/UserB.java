/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.Impl.UserDao;
import com.pfe.model.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Houda
 */

@Service
public class UserB {
@Resource
    private UserDao userRepository;
 
    @Transactional
    public Serializable create(User user) {
        User createdUser = user;
        return userRepository.save(createdUser);
    }
    
    @Transactional
    public int CreateNewUserId() {
      int maxUserId = userRepository.getMaxId();
      System.out.println("Maximum id  is :-" +  maxUserId);
     // maxEmpId =(maxEmpId==null)?"0":maxEmpId;
        return maxUserId+1;
    }
     
    @Transactional
    public User findById(Integer Userid) {
        return userRepository.getbyid(Userid);
    }
 
   
 
    @Transactional
    public List<User> findAll() {
        System.out.println("I am Inside User Service");
        return userRepository.getAll(User.class);
    }
 
    @Transactional
    public void update(User user) {
        User createdUser = user;
         userRepository.saveOrUpdate(createdUser);
    }
    
   @Transactional
    public void delete(User user) {
        User createdUser = user;
         userRepository.delete(user);
    } 
}



/////

   
