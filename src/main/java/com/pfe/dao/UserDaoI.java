/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao;

import com.pfe.model.User;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Houda
 */
public interface UserDaoI extends GenericDao<User, Integer> {
 User findByUsername(String username);
    
@Query("SELECT max(u.userId) FROM User u")//Retrieving Maximun Id of User Record
   int getMaxId();
    
}

