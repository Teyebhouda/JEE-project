/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.DropBscDao;
import com.pfe.dao.GenericDao;
import com.pfe.model.Dispo3g;
import com.pfe.model.DropBssBsc;
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
public class DropBscB  implements Serializable{
     public static transient boolean editableDrBsc;

public LineChartModel dateModel;
public LineChartModel dateModel2;

    private GenericDao<Dispo3g, Integer> genericDao ;
    private List<DropBssBsc> lista = new ArrayList<>();
    private List<DropBssBsc> listDropBsc = new ArrayList<>();
       private List<DropBssBsc> listDropBsckpa = new ArrayList<>();

    private Date dataInicial; 
private Date dataFinal ;
 private String BscName;  
public String novaData, novaData2;

   private GenericDao dropBscIDao; 
   
      private DropBscDao dropbscIDaoS; 

    public DropBscB(){
        createDateModel();
        

    }
     @PostConstruct
    public void init() {
        
        createDateModel();
    }

    public DropBscB(
             GenericDao<DropBssBsc, Integer> genericDao) {
        //super(genericDao);
        
        this.dropBscIDao = (DropBscDao) genericDao;
   
               this.editableDrBsc = false;

    }

    public GenericDao getDropBscIDao() {
        return dropBscIDao;
    }

    public void setDropBscIDao(GenericDao dropBscIDao) {
        this.dropBscIDao = dropBscIDao;
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
         
         lista = dropBscIDao.getAllbyBscName(novaData,novaData2,BscName);   
	//lista = dao.listaCondicao(Leite.class, "dataDoValor BETWEEN ' " + novaData + " ' AND ' " + novaData2 + " ' ");
  	System.out.println("no Preencher ELSE");
    for (DropBssBsc leite : lista) {
		System.out.println(leite.getDate());
	}
    if(lista.size()>=1){
          	System.out.println("please respect the dates");

        
 	   createDateModel();
 	  
 	                setEditableDrBsc(true);
                	}
    else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
faces.addMessage(null, new FacesMessage("the list is empty between the date"+novaData+"and"+novaData2));
                 setEditableDrBsc(false);
      	}
    }else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 	     	 faces.addMessage(null, new FacesMessage("respecter les dates svp "));
                 setEditableDrBsc(false);
           
     	}
    }

private void createDateModel() {
	
	FacesContext faces = FacesContext.getCurrentInstance();
	 if(lista !=null){


	  dateModel2 = new LineChartModel();
           	
         dateModel = new LineChartModel();
         LineChartSeries series1 = new LineChartSeries();
         LineChartSeries series2 = new LineChartSeries();
        
         series1.setLabel("Series 1");

         for (DropBssBsc leite : lista) {
         	
         Object valor =	leite.getDate().toString();
 			series1.set(valor, leite.getTchAvailability());
 			series2.set(valor, leite.getTchTraffic());
 			
                        dateModel.addSeries(series1);
 			dateModel2.addSeries(series2);
 			
 			System.out.println(leite.getTchAvailability());
 		}
  
 dateModel.getAxis(AxisType.Y).setLabel("TCH Availability %");
  dateModel2.getAxis(AxisType.Y).setLabel("TCH TRAFFIC %");
 
 DateAxis axis = new DateAxis("");
         axis.setTickAngle(0);
         axis.setMax(novaData2);
         axis.setTickCount(10);
        dateModel.setZoom(true);
         dateModel.getAxis(AxisType.Y).setTickCount(20);
         dateModel.getAxis(AxisType.Y).setMin(0);
         dateModel.getAxis(AxisType.Y).setMax(150);
         
         
         dateModel2.setZoom(true);
         dateModel2.getAxis(AxisType.Y).setTickCount(20);
         dateModel2.getAxis(AxisType.Y).setMin(0);
         dateModel2.getAxis(AxisType.Y).setMax(10000);
         
         axis.setTickFormat("%#d, %b %y");
                   //dateModel.setLegendPosition("e");

          
         dateModel.getAxes().put(AxisType.X, axis);
     dateModel2.getAxes().put(AxisType.X, axis);
     
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

    public LineChartModel getDateModel2() {
        return dateModel2;
    }

    public void setDateModel2(LineChartModel dateModel2) {
        this.dateModel2 = dateModel2;
    }
    

    public GenericDao<Dispo3g, Integer> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<Dispo3g, Integer> genericDao) {
        this.genericDao = genericDao;
    }

    public List<DropBssBsc> getListDropBsc() {
listDropBsc=dropBscIDao.getAll(DropBssBsc.class);
    return listDropBsc;
     }

    public void setListDropBsc(List<DropBssBsc> listDropBsc) {
        this.listDropBsc = listDropBsc;
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

    public List<DropBssBsc> getLista() {
        return lista;
    }

    public void setLista(List<DropBssBsc> lista) {
        this.lista = lista;
    }

    public  boolean isEditableDrBsc() {
        return editableDrBsc;
    }

    public static void setEditableDrBsc(boolean editableDrBscc) {
        editableDrBsc = editableDrBscc;
        DispoBscB.editableDBsc=false;
        Dispo3GB.editable=false;
        DropCellB.editableDrcell=false;
        DispoCellB.editableDcell=false;

    }

    public List<DropBssBsc> getListDropBsckpa() {
        return dropbscIDaoS.alarmDrbsc(BscName);
    }

    public DropBscDao getDropbscIDaoS() {
        return dropbscIDaoS;
    }

    public void setListDropBsckpa(List<DropBssBsc> listDropBsckpa) {
        this.listDropBsckpa = listDropBsckpa;
    }

    public void setDropbscIDaoS(DropBscDao dropbscIDaoS) {
        this.dropbscIDaoS = dropbscIDaoS;
    }

    

    

}
