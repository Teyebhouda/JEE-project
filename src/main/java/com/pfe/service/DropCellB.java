/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.Dispo3gDao;
import com.pfe.dao.DropCellDao;
import com.pfe.dao.GenericDao;
import com.pfe.model.Dispo3g;
import com.pfe.model.Dropbsscellules;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Houda
 */
public class DropCellB implements Serializable {
   public static transient boolean editableDrcell;

public LineChartModel dateModel;

    private GenericDao<Dropbsscellules, Integer> genericDao ;
    private List<Dropbsscellules> lista = new ArrayList<>();
    private List<Dropbsscellules> listDropcell = new ArrayList<>();
       private List<Dropbsscellules> listDropcellkpa = new ArrayList<>();

    private Date dataInicial; 
private Date dataFinal ;
 private String BscName;  
public String novaData, novaData2;

   private GenericDao dropcellIDao;
    private DropCellDao dropcellIDaoS; 

   
     
    public DropCellB(){
        createDateModel();
        

    }
     @PostConstruct
    public void init() {
        
        createDateModel();
    }

    public DropCellB(
             GenericDao<Dropbsscellules, Integer> genericDao) {
        
        this.dropcellIDao = (DropCellDao) genericDao;
          editableDrcell = false;

        
    }

    public GenericDao getDropcellIDao() {
        return dropcellIDao;
    }

    public void setDropcellIDao(GenericDao dropcellIDao) {
        this.dropcellIDao = dropcellIDao;
    }

    

    
public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " date sélectionnée", format.format(event.getObject())));
	 }
    

  

   
    
    
    
    
   
public void chartview() throws IOException{
	 SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy");
	 FacesContext faces = FacesContext.getCurrentInstance();

	 if(dataInicial.compareTo(dataFinal)<0){
	 SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
	 novaData = formatador.format(dataInicial);
	 novaData2 = formatador.format(dataFinal);
	
	 System.out.println(novaData+" nova data 2 " +novaData2);
         lista = dropcellIDao.getAllbyBscName(novaData,novaData2,BscName);   
	//lista = dao.listaCondicao(Leite.class, "dataDoValor BETWEEN ' " + novaData + " ' AND ' " + novaData2 + " ' ");
  	System.out.println("no Preencher ELSE");
    for (Dropbsscellules leite : lista) {
		System.out.println(leite.getDate());
	}
    if(lista.size()>=1){
          	System.out.println("ok createDateModel");

        
 	   createDateModel();
 	    setEditableDrcell(true);
                	}
    
    else{
     		  	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
               faces.addMessage(null, new FacesMessage("the list is empty between the date"+novaData+"and"+novaData2));
                 setEditableDrcell(false);
      	}
    }else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 	     	 faces.addMessage(null, new FacesMessage("please respect the dates "));
                 setEditableDrcell(false);
           
     	}
    }

private void createDateModel() {
	
	FacesContext faces = FacesContext.getCurrentInstance();
	 if(lista !=null){


	    	
         dateModel = new LineChartModel();
         LineChartSeries series1 = new LineChartSeries();
         series1.setLabel("Series 1");

         for (Dropbsscellules leite : lista) {
         	
         Object valor =	leite.getDate().toString();
 			series1.set(valor, leite.getTchAvailibility());
 			dateModel.addSeries(series1);
 			
 			System.out.println(leite.getTchAvailibility());
 		}
  
 dateModel.getAxis(AxisType.Y).setLabel("TCH Availability %");
         DateAxis axis = new DateAxis("");
         axis.setTickAngle(0);
         axis.setMax(novaData2);
         axis.setTickCount(10);
         dateModel.setZoom(true);
         dateModel.getAxis(AxisType.Y).setTickCount(20);
         dateModel.getAxis(AxisType.Y).setMin(0);
         dateModel.getAxis(AxisType.Y).setMax(150);
         
         axis.setTickFormat("%#d, %b %y");
                   //dateModel.setLegendPosition("e");

          
         dateModel.getAxes().put(AxisType.X, axis);
     	System.out.println("OK GRAFICO");
 	
    		
    }else{
         	System.out.println(" lista null");
	
   
    }
}

    public LineChartModel getDateModel() {
        return dateModel;
    }

    public void setDateModel(LineChartModel dateModel) {
        this.dateModel = dateModel;
    }

    public GenericDao<Dropbsscellules, Integer> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<Dropbsscellules, Integer> genericDao) {
        this.genericDao = genericDao;
    }
    
    

    public List<Dropbsscellules> getListDropcell() {
    listDropcell=dropcellIDao.getAll(Dropbsscellules.class);
    return listDropcell;
     }

    public void setListDropcell(List<Dropbsscellules> listDropcell) {
        this.listDropcell = listDropcell;
    }

    

    

   
    
   

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getBscName() {
        return BscName;
    }

    public void setBscName(String BscName) {
        this.BscName = BscName;
    }

    public List<Dropbsscellules> getLista() {
        return lista;
    }

    public void setLista(List<Dropbsscellules> lista) {
        this.lista = lista;
    }

    public  boolean isEditableDrcell() {
        return editableDrcell;
    }

    public static void setEditableDrcell(boolean editableDrcelll) {
        editableDrcell = editableDrcelll;
        Dispo3GB.editable=false;
        DispoCellB.editableDcell=false;
        DispoBscB.editableDBsc=false;
        DropBscB.editableDrBsc=false;
        
        
    }

    public List<Dropbsscellules> getListDropcellkpa() {
        return dropcellIDaoS.alarmDrcell(BscName);
    }

    public DropCellDao getDropcellIDaoS() {
        return dropcellIDaoS;
    }

    public void setDropcellIDaoS(DropCellDao dropcellIDaoS) {
        this.dropcellIDaoS = dropcellIDaoS;
    }
    

   

   

}
