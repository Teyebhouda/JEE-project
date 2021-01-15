/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao;

import com.pfe.model.Dispo3g;
import java.util.List;

/**
 *
 * @author Houda
 */
public interface Dispo3gDao  extends GenericDao<Dispo3g, Integer> {
    
 public List<Dispo3g> alarm3g(); 

}
