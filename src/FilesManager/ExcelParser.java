/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FilesManager;

import JExcelClass.Country;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Prudhvi
 */

public class ExcelParser {

    /**
     * @param args the command line arguments
     */
    public static void writeCountryListToFile(String fileName, List<Country> countryList) throws Exception{
        Workbook workbook = null;
            
        if(fileName.endsWith("xlsx")){
            workbook = new XSSFWorkbook();
        }else if(fileName.endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            throw new Exception("invalid file name, should be xls or xlsx");
        }
         
        Sheet sheet = workbook.createSheet("Countries");
         
        Iterator<Country> iterator = countryList.iterator();
         
        int rowIndex = 0;
        while(iterator.hasNext()){
            Country country = iterator.next();
            Row row = sheet.createRow(rowIndex++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(country.getName());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(country.getShortCode());
        }
         
        //lets write the excel data to file now
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
        System.out.println(fileName + " written successfully");
    }
     
    public static void main(String args[]) throws Exception{

        List<HardCopy> list= ExcelParser.readExcelData("Files.xlsx");
        
    }
    
    public static List<HardCopy> readExcelData(String fileName) {
        List<HardCopy> fileList = new ArrayList<>();
         
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);
             
            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
             
            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();
             
            //loop through each of the sheets
            for(int i=0; i < numberOfSheets; i++){
                 
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);
                 
                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                int index=0;
                while (rowIterator.hasNext()) 
                {
                    index++;
                    if(index==1)
                    {

                        rowIterator.next();
                        continue;
                    }

                     
                    //Get the row object
                    Row row = rowIterator.next();
                     
                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();
                    
                    HardCopy f= null;
                    try{
                        
                        List<String> listStrings=new LinkedList<>();

                        for (int j = 0; j < 6; j++) {
                            Cell c=row.getCell(j);
                            if(c!=null)
                                listStrings.add(c.toString());
                            else
                                listStrings.add("");
                        }

                        int s=listStrings.size();

                        f=new HardCopy(listStrings.get(0),
                                listStrings.get(1), 
                                listStrings.get(2), 
                                listStrings.get(3), 
                                (s>4)?listStrings.get(4):"", 
                                (s>5)?listStrings.get(5):"");
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();   
                    }
                    
                    fileList.add(f);
                    
                } //end of rows iterator

                 
            } //end of sheets for loop
             
            //close file input stream
            fis.close();
             
        } catch (IOException e) {
            e.printStackTrace();
        }
        int k=1;
        for (HardCopy file : fileList) {
            file.key=k++;
        }
        return fileList;
    }
}
