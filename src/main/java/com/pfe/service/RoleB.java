/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.Impl.RoleDao;
import com.pfe.model.Role;
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
public class RoleB  {
    
    
    @Resource
    private RoleDao roleRepository;
 
    @Transactional
    public Serializable create(Role role) {
        Role createdRole = role;
        role.toString();
        return roleRepository.save(role);
       
    }
    
    
    @Transactional
    public int CreateNewRoleId() {
      int maxUserRoleId = roleRepository.getMaxId();
     // maxEmpId =(maxEmpId==null)?"0":maxEmpId;
        return maxUserRoleId+1;
    }
     
    @Transactional
    public Role findById(Integer userId) {
        return roleRepository.get(userId);
    }
 
    
    @Transactional
    public List<Role> findAll() {
        System.out.println("I am Inside UserRole Service");
        return roleRepository.getAll(Role.class);
    }
 
    
    
}
