/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.dao;
import com.pfe.model.DisponibiliteCell;
import java.util.List;
/**
 *
 * @author Houda
 */
public interface DispoCellDao extends GenericDao<DisponibiliteCell, Integer> {
  public List<DisponibiliteCell> alarmDcell(String s ); 
    
}
