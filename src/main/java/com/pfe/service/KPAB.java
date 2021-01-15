/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.GenericDao;
import com.pfe.model.Kpa;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Houda
 */
public class KPAB implements GenericB {
     private GenericDao<Kpa, Integer> genericDao ;
      private GenericDao kpaIDao;
      private List<Kpa> listkpa ;
       Kpa Kpa = new Kpa();
private String testValue = "default";
//boolean editable;

public String getTestValue() {
  return testValue;
} 

public void setTestValue(String testValue) {
   this.testValue = testValue;
 }

    public KPAB() {
    }
    
   
    
    public KPAB(
             GenericDao<Kpa, Integer> genericDao ) {
        this.kpaIDao=genericDao;
        
        
    }   

    public GenericDao<Kpa, Integer> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<Kpa, Integer> genericDao) {
        this.genericDao = genericDao;
    }

    public GenericDao getKpaIDao() {
        return kpaIDao;
    }

    public void setKpaIDao(GenericDao kpaIDao) {
        this.kpaIDao = kpaIDao;
    }

    public List<Kpa> getListkpa() {
        return kpaIDao.getAll(Kpa.class);
    }

    public void setListkpa(List<Kpa> listkpa) {
        this.listkpa = listkpa;
    }

     
     
     
      public void onRowEdit(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage(" KPA Edited  ");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
         Kpa editedkpa = ( Kpa) event.getObject();  
        kpaIDao.update(editedkpa); 
    }  
    public void onCancel(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage("Edit Cancelled");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        //listkpa.remove((Kpa) event.getObject());  
    }  

    public Kpa getKpa() {
        return Kpa;
    }

    public void setKpa(Kpa Kpa) {
        this.Kpa = Kpa;
    }

   
           
                public String saveAction(Kpa kpa1) {
	    
		//get all existing value but set "editable" to false 
		for (Kpa kpa : listkpa){
			kpa.setEditable(false);
                         FacesMessage msg = new FacesMessage(" KPA Edited  ");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        kpaIDao.update(kpa1); 
        kpa1= new Kpa();
    
                        
		}
		
		//return to current page
		return null;
		
	}
	
	public String editAction(Kpa kpa) {
	    
		kpa.setEditable(true);
		return null;
	}
  public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " date sélectionnée", format.format(event.getObject())));
	 }
}
