/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.DispoCellDao;
import com.pfe.dao.GenericDao;
import com.pfe.model.DisponibiliteCell;
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
public class DispoCellB implements Serializable {
     public static transient boolean editableDcell;

public LineChartModel dateModel;

    private GenericDao<DisponibiliteCell, Integer> genericDao ;
    private List<DisponibiliteCell> lista = new ArrayList<>();
    private List<DisponibiliteCell> listDispoCell = new ArrayList<>();
       private List<DisponibiliteCell> listDispoCellkpa = new ArrayList<>();

    private Date dataInicial; 
private Date dataFinal ;
   
public String novaData, novaData2;

   private GenericDao dispoCellIDao;
   private String BscName;
     private DispoCellDao dispocellIDaoS; 

    public DispoCellB(){
        createDateModel();
        

    }
     @PostConstruct
    public void init() {
        
        createDateModel();
    }

    public DispoCellB(
             GenericDao<DisponibiliteCell, Integer> genericDao) {
        //super(genericDao);
        
        this.dispoCellIDao= (DispoCellDao) genericDao;
          this.editableDcell = false;

        
    }

    public GenericDao getDispoCellIDao() {
        return dispoCellIDao;
    }

    public void setDispoCellIDao(GenericDao dispoCellIDao) {
        this.dispoCellIDao = dispoCellIDao;
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
	//  Date dataFinal=(Date) chartConfig.dataFinal;
	 SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
	 novaData = formatador.format(dataInicial);
	 novaData2 = formatador.format(dataFinal);
	
	 System.out.println(novaData+" nova data 2 " +novaData2);
         lista = dispoCellIDao.getAllbyBscName(novaData,novaData2, BscName);   
	//lista = dao.listaCondicao(Leite.class, "dataDoValor BETWEEN ' " + novaData + " ' AND ' " + novaData2 + " ' ");
  	System.out.println("no Preencher ELSE");
    for (DisponibiliteCell leite : lista) {
		System.out.println(leite.getDate());
	}
    if(lista.size()>=1){
          	System.out.println("ok createDateModel");

        
 	   createDateModel();
 	  this.setEditableDcell(true);
 	   
    }else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 faces.addMessage(null, new FacesMessage("the list is empty between the date"+novaData+"and"+novaData2));
                 this.setEditableDcell(false);
                	}
    }else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 	     	 faces.addMessage(null, new FacesMessage("please respect the dates "));
                 this.setEditableDcell(false);
           
     	}
    }

private void createDateModel() {
	
	FacesContext faces = FacesContext.getCurrentInstance();
	 if(lista !=null){


	    	
         dateModel = new LineChartModel();
         LineChartSeries series1 = new LineChartSeries();
         series1.setLabel("Series 1");

         for (DisponibiliteCell leite : lista) {
         	
         Object valor =	leite.getDate().toString();
 			series1.set(valor, leite.getId());
 			dateModel.addSeries(series1);
 			
 			System.out.println(leite.getTchAvailability());
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

    public GenericDao<DisponibiliteCell, Integer> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<DisponibiliteCell, Integer> genericDao) {
        this.genericDao = genericDao;
    }

    public List<DisponibiliteCell> getListDispoCell() {
     listDispoCell=dispoCellIDao.getAll(DisponibiliteCell.class);
    return listDispoCell;
        }

    public void setListDispoCell(List<DisponibiliteCell> listDispoCell) {
        this.listDispoCell = listDispoCell;
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

    public List<DisponibiliteCell> getLista() {
        return lista;
    }

    public void setLista(List<DisponibiliteCell> lista) {
        this.lista = lista;
    }

    public  boolean isEditableDcell() {
        return editableDcell;
    }

    public static void setEditableDcell(boolean editableDcell) {
        DispoCellB.editableDcell = editableDcell;
        DispoBscB.editableDBsc=false;
        Dispo3GB.editable=false;
        DropBscB.editableDrBsc=false;
        DropCellB.editableDrcell=false;
   
    }

    public DispoCellDao getDispocellIDaoS() {
        return dispocellIDaoS;
    }

    public void setDispocellIDaoS(DispoCellDao dispocellIDaoS) {
        this.dispocellIDaoS = dispocellIDaoS;
    }

    public List<DisponibiliteCell> getListDispoCellkpa() {
        return dispocellIDaoS.alarmDcell(BscName);
    }

    public void setListDispoCellkpa(List<DisponibiliteCell> listDispoCellkpa) {
        this.listDispoCellkpa = listDispoCellkpa;
    }

    
    

    

}
