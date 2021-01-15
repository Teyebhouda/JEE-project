/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao;

import com.pfe.model.Role;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Houda
 */
public interface RoleDaoI extends GenericDao<Role, Integer> {
@Query("SELECT max(r.roleId) FROM Role r")//Retrieving Maximun Id of UserRole Record
   int getMaxId();
}