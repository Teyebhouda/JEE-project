/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.dao.Dispo3gDao;
import com.pfe.dao.DispoBscDao;
import com.pfe.dao.GenericDao;
import com.pfe.model.Dispo3g;
import com.pfe.model.Disponibilitebsc;
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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Houda
 */
public class DispoBscB implements Serializable {
    
    public static transient boolean editableDBsc;
    public LineChartModel dateModel;
    private GenericDao<Disponibilitebsc, Integer> genericDao ;
    private List<Disponibilitebsc> lista = new ArrayList<>();
    private List<Disponibilitebsc> listDispobsc = new ArrayList<>();
     private List<Disponibilitebsc> listDispobsckpa = new ArrayList<>();
    private Date dataInicial; 
    private Date dataFinal ;
    public String novaData, novaData2;
    private String BscName;
    private GenericDao dispoBscIDao;
    private DispoBscDao dispoBscIDaoS;
      
     
    public DispoBscB(){
        createDateModel();
        

    }
     @PostConstruct
    public void init() {
        
        createDateModel();
    }

    public DispoBscB(
             GenericDao<Disponibilitebsc, Integer> genericDao,DispoBscDao d ) {
        this.dispoBscIDao = (DispoBscDao) genericDao;
         editableDBsc = false;
         this.dispoBscIDaoS=d;
        
    }

    public GenericDao getDispoBscIDao() {
        return dispoBscIDao;
    }

    public void setDispoBscIDao(GenericDao dispoBscIDao) {
        this.dispoBscIDao = dispoBscIDao;
    }

   
public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " date selected", format.format(event.getObject())));
	 }
    

  

   
    
    
    
    
   
public void chartview() throws IOException{
	 SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy");
	 FacesContext faces = FacesContext.getCurrentInstance();
if(dataInicial.compareTo(dataFinal)<0){
	
	 SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
	 novaData = formatador.format(dataInicial);
	 novaData2 = formatador.format(dataFinal);
	
	 System.out.println(novaData+" nova data 2 " +novaData2);
         lista = dispoBscIDao.getAllbyBscName(novaData,novaData2,BscName);   
  	System.out.println("no Preencher ELSE");
    for (Disponibilitebsc leite : lista) {
		System.out.println(leite.getDate());
	}
    if(lista.size()>=1){
          	System.out.println("ok createDateModel");

        
 	             createDateModel();
 	   setEditableDBsc(true);

 	  	}
    else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 	     	 faces.addMessage(null, new FacesMessage("the list is empty between the date"+novaData+"and"+novaData2));
     	 setEditableDBsc(false);
           
    }
    }else{
     		
 	      	 novaData = formatador2.format(dataInicial);
 	      	 novaData2 = formatador2.format(dataFinal);
 	     	 faces.addMessage(null, new FacesMessage("please respect the dates  "));
        setEditableDBsc(false);
           
     	}
    }

private void createDateModel() {
	
	FacesContext faces = FacesContext.getCurrentInstance();
	 if(lista !=null){


	    	
         dateModel = new LineChartModel();
         LineChartSeries series1 = new LineChartSeries();
         series1.setLabel("TchAvailibility");
         LineChartSeries series2 = new LineChartSeries();
         series2.setLabel("TchTraffic");

         for (Disponibilitebsc leite : lista) {
         	
         Object valor =	leite.getDate().toString();
 			series1.set(valor, leite.getTchAvailibility());
 			//series2.set(valor,leite.getTchTraffic() );
                        dateModel.addSeries(series1);
 			//dateModel.addSeries(series2);

 			System.out.println(leite.getTchAvailibility());
 		}
  
    dateModel.getAxis(AxisType.Y).setLabel("TCH Availability %");
         DateAxis axis = new DateAxis("");
         axis.setTickAngle(0);
         axis.setMax(novaData2);
         axis.setTickCount(10);
         dateModel.setZoom(true);
        //    dateModel.setShowPointLabels(true);
         dateModel.getAxis(AxisType.Y).setTickCount(10);
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

    public GenericDao<Disponibilitebsc, Integer> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<Disponibilitebsc, Integer> genericDao) {
        this.genericDao = genericDao;
    }

    public List<Disponibilitebsc> getListDispobsc() {
 listDispobsc=dispoBscIDao.getAll(Disponibilitebsc.class);
    return listDispobsc;
       }
    

    public void setListDispobsc(List<Disponibilitebsc> listDispobsc) {
        this.listDispobsc = listDispobsc;
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

    public List<Disponibilitebsc> getLista() {
        return lista;
    }

    public void setLista(List<Disponibilitebsc> lista) {
        this.lista = lista;
    }

    public  boolean isEditableDBsc() {
        return editableDBsc;
    }

    public static void setEditableDBsc(boolean editableDbscc) {
  editableDBsc = editableDbscc;
        Dispo3GB.editable=false;
        DispoCellB.editableDcell=false;
        DropBscB.editableDrBsc=false;
        DropCellB.editableDrcell=false;
       
    }

    public DispoBscDao getDispoBscIDaoS() {
        return dispoBscIDaoS;
    }

    public void setDispoBscIDaoS(DispoBscDao dispoBscIDaoS) {
        this.dispoBscIDaoS = dispoBscIDaoS;
    }

   

   


    public List<Disponibilitebsc> getListDispobsckpa() {
        return dispoBscIDaoS.alarmDbsc(BscName);
    }

    public void setListDispobsckpa(List<Disponibilitebsc> listDispobsckpa) {
        this.listDispobsckpa = listDispobsckpa;
    }
   
    
    
    }
    
      

    
    
