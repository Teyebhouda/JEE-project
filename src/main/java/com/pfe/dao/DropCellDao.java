/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao;
import com.pfe.model.Dropbsscellules;
import java.util.List;
/**
 *
 * @author Houda
 */
public interface DropCellDao extends GenericDao<Dropbsscellules, Integer> {
  public List<Dropbsscellules> alarmDrcell(String s ); 
}
