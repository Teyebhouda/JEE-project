/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;
import static com.sun.faces.facelets.tag.ui.ComponentRefHandler.Name;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.context.annotation.Scope;
/**
 *
 * @author Houda
 */

@ManagedBean
public class ViewConfig {
    
   private String BscName;
   private Map<String,String> BscList = new HashMap<String, String>();
   private Map<String,String> BscList3g = new HashMap<String, String>();

   @PostConstruct
    public void init() {
          //BscNames
          
      BscList = new HashMap<String, String>();
        BscList.put("BBOUZEV", "BBOUZEV");
        BscList.put("BKAIE1","BKAIE1");
        BscList.put("BKASE1","BKASE1");
        BscList.put("BMAHD1","BMAHD1");
        BscList.put("BMEDE1","BMEDE1");
        BscList.put("BMOK1","BMOK1");
         BscList.put("BNABE1", "BNABE1");
        BscList.put("BSFXE1","BSFXE1");
        BscList.put("BSFXE2","BSFXE2");
        BscList.put("BSOUEVO","BSOUEVO");
         BscList.put("BGABES1","BGABES1");
        BscList.put("BGABES2","BGABES2");
         BscList.put("BGABES3", "BGABES3");
         BscList.put("BGAFSA1", "BGAFSA1");
        BscList.put("BGAFSA2","BGAFSA2");
        BscList.put("BKEBL","BKEBL");
        BscList.put("BTATA","BTATA");
        BscList.put("BTOZER1","BTOZER1");
        BscList.put("BTOZER2","BTOZER2");
      
        BscList3g = new HashMap<String, String>();
                BscList3g.put("NABERC1","NABERC1");
                BscList3g.put("SOUEVO1","SOUEVO1");
                BscList3g.put("SOURNC1","SOURNC1");
                BscList3g.put("SFXRNC1","SFXRNC1");
                BscList3g.put("MDNRNC1","MDNRNC1");
                BscList3g.put("KRNRNC1","KRNRNC1");
                BscList3g.put("GFSRNC1","GFSRNC1");

     
    
        
    }

      
    
    
    
    public String getBscName() {
        return BscName;
    }

    public void setBscName(String BscName) {
        this.BscName = BscName;
    }

    public Map<String, String> getBscList() {
        return BscList;
    }

    public void setBscList(Map<String, String> BscList) {
        this.BscList = BscList;
    }

    public Map<String, String> getBscList3g() {
        return BscList3g;
    }

    public void setBscList3g(Map<String, String> BscList3g) {
        this.BscList3g = BscList3g;
    }
    
    

   public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
 
        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }
 
}