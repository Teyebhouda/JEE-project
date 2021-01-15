/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.Dispo3gDao;
import com.pfe.dao.GenericDao;
import com.pfe.model.Dispo3g;
import com.pfe.model.Kpa;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Houda
 */
public class Dispo3GB implements Serializable {
    
     public static transient boolean editable;

     
    public LineChartModel dateModel;

    private GenericDao<Dispo3g, Integer> genericDao ;
    private List<Dispo3g> lista = new ArrayList<>();
    private List<Dispo3g> listDispo3g = new ArrayList<>();
    private List<Dispo3g> listDispo3gkpa = new ArrayList<>();
    private Date dataInicial; 
    private Date dataFinal ;
    private String BscName;
 
    public String novaData, novaData2;

   private GenericDao dispo3gIDao;
   private Dispo3gDao dispo3gIDaoS;
   
     
    public Dispo3GB(){
        createDateModel();
        
        

    }
     @PostConstruct
    public void init() {
        
        createDateModel();
    }

    public Dispo3GB(
             GenericDao<Dispo3g, Integer> genericDao ,Dispo3gDao dispo3g) {
        
        this.dispo3gIDao = (Dispo3gDao) genericDao;
       this.dispo3gIDaoS=dispo3g;
         editable = false;

        
    }

    public void onTabChange() {
        editable = false;
        DispoCellB.editableDcell=false;
        DropBscB.editableDrBsc=false;
        DropCellB.editableDrcell=false;
        DispoBscB.editableDBsc=false;
   
               }
    public GenericDao getDispo3gIDao() {
        return dispo3gIDao;
    }

    public void setDispo3gIDao(GenericDao dispo3gIDao) {
        this.dispo3gIDao = dispo3gIDao;
    }

    

   public void onRowEdit(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage(" KPA Edited  ");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    public void onCancel(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage("Edit Cancelled");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  


    public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " date selected", format.format(event.getObject())));
	 }
	
    
    
    
    
   
public void chartview() throws IOException{
	 SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy");
	 FacesContext faces = FacesContext.getCurrentInstance();

	  SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
	if(dataInicial.compareTo(dataFinal)<0){
		
          novaData = formatador.format(dataInicial);
	 novaData2 = formatador.format(dataFinal);
	
	 System.out.println(novaData+" nova data 2 " +novaData2);
         lista = dispo3gIDao.getAllbyBscName(novaData,novaData2, BscName) ;   
	System.out.println("ok dao Query");
    for (Dispo3g leite : lista) {
		System.out.println(leite.getDate());
	}
    if(lista.size()>=1){
          	System.out.println("ok createDateModel");

        
 	   createDateModel();
           setEditable(true);
         
    }
    else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 	     	 faces.addMessage(null, new FacesMessage("the list is empty between the date"+novaData+"and"+novaData2));
                 setEditable(false);
           
     	}
    
        }else{
     		
 	      	  faces.addMessage(null, new FacesMessage("please respect the dates  "));
                 setEditable(false);
                  System.out.println(" date NG");
        
           
     	}
    }

private void createDateModel() {
	
	FacesContext faces = FacesContext.getCurrentInstance();
	 if(lista !=null){


	    	
         dateModel = new LineChartModel();
         LineChartSeries series1 = new LineChartSeries();
         series1.setLabel("Series 1");

         for (Dispo3g leite : lista) {
         	
         Object valor =	leite.getDate().toString();
 			series1.set(valor, leite.getVal());
 			dateModel.addSeries(series1);
 			
 			System.out.println(leite.getVal());
 		}
  
        dateModel.getAxis(AxisType.Y).setLabel("TCH Availability %");
         DateAxis axis = new DateAxis("");
         axis.setTickAngle(0);
         axis.setMax(novaData2);
         axis.setTickCount(10);
         dateModel.setZoom(true);
         dateModel.getAxis(AxisType.Y).setTickCount(20);
         dateModel.getAxis(AxisType.Y).setMin(0);
         //dateModel.getAxis(AxisType.Y).setMax();

         axis.setTickFormat("%#d, %b %y");
         
         // dateModel.setLegendPosition("ne");
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

    public GenericDao<Dispo3g, Integer> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<Dispo3g, Integer> genericDao) {
        this.genericDao = genericDao;
    }

    

   
    
    public List<Dispo3g> getListDispo3g() {
         listDispo3g=dispo3gIDao.getAll(Dispo3g.class);
    return listDispo3g;
    }

    /*public void setListDispo3g(List<Dispo3g> listDispo3g) {
        this.listDispo3g = listDispo3g;
    }*/

     public List<Dispo3g> getListDispo3gkpa() {
       listDispo3gkpa=dispo3gIDaoS.alarm3g();
        return listDispo3gkpa;
    }

    public void setListDispo3gkpa(List<Dispo3g> listDispo3gkpa) {
        this.listDispo3gkpa = listDispo3gkpa;
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

    public List<Dispo3g> getLista() {
        return lista;
    }

    public void setLista(List<Dispo3g> lista) {
        this.lista = lista;
    }

    public boolean isEditable() {
        return editable;
    }

    public static void setEditable(boolean editablee) {
        editable = editablee;
         DispoCellB.editableDcell=false;
        DropBscB.editableDrBsc=false;
        DropCellB.editableDrcell=false;
        DispoBscB.editableDBsc=false;
   
        
    }

    public Dispo3gDao getDispo3gIDaoS() {
        return dispo3gIDaoS;
    }

    public void setDispo3gIDaoS(Dispo3gDao dispo3gIDaoS) {
        this.dispo3gIDaoS = dispo3gIDaoS;
    }

   

    
   
   
     
}
