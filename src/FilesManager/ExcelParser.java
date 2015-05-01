/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FilesManager;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Prudhvi
 */

public class ExcelParser {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    static String filename;
    static int nrows;
     
    public static void main(String args[]) throws Exception{

        List<HardCopy> list= ExcelParser.readExcelData("Files.xlsx");
        
    }
    
    public static List<HardCopy> readExcelData(String fileName) {
        List<HardCopy> fileList = new ArrayList<>();
        ExcelParser.filename=fileName;
        System.out.println(filename);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);
             System.out.println(filename);
            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = WorkbookFactory.create(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
             
            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();
             
            //loop through each of the sheets
            for(int i=0; i < 1; i++){
                 
                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);
                nrows=sheet.getPhysicalNumberOfRows();
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
                    if(f.fileNo==null||f.inDate==null||f.subject==null)
                        continue;
                    fileList.add(f);
                    
                } //end of rows iterator

                 
            } //end of sheets for loop
             
            //close file input stream
            fis.close();
             
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e)
        {
            System.out.println("exception occured!!");
        }
        int k=1;
        for (HardCopy file : fileList) {
            
            file.key=k++;
        }
        return fileList;
    }
    
    
    static void samplewrite()
    {
           FileInputStream fis = null;
           try {
            fis = new FileInputStream(filename);
            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(filename.toLowerCase().endsWith("xlsx")){
                workbook = WorkbookFactory.create(fis);
            }else if(filename.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            } 
            
            Sheet sheet=workbook.getSheetAt(0);
            
            int n=sheet.getPhysicalNumberOfRows();
            Row r=sheet.createRow(n);
            
            Cell c=r.createCell(0);
            c.setCellType(Cell.CELL_TYPE_NUMERIC);
            c.setCellValue(470);
            
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("m/d/yy"));
            
            c = r.createCell(1);
            c.setCellValue(new Date());
            c.setCellStyle(cellStyle);
            
            c=r.createCell(2);
            c.setCellValue("Filename");
            
            c=r.createCell(3);
            c.setCellValue("new subject");
            
            c=r.createCell(4);
            c.setCellValue(new Date());
            c.setCellStyle(cellStyle);
            
            c=r.createCell(5);
            c.setCellValue("Disp to");
            
            
            
            System.out.println("Rows="+n);
            
               try (FileOutputStream output_file = new FileOutputStream(new File(filename)) //Open FileOutputStream to write updates
               ) {
                   workbook.write(output_file); //write changes
                   output_file.close();
               } //write changes
               fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    static boolean write_row(HardCopy h)
    {
        
        FileInputStream fis = null;
           try {
            fis = new FileInputStream(filename);
            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(filename.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(filename.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            } 
            
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("m/d/yy"));
            
            Sheet sheet=workbook.getSheetAt(0);
            
            int n=sheet.getPhysicalNumberOfRows();
            Row r=sheet.createRow(n);
            
            Cell c=r.createCell(0);
            c.setCellType(Cell.CELL_TYPE_STRING);
            c.setCellValue(h.sno);
            
            
            
            c = r.createCell(1);
            c.setCellValue(h.inDate);
            c.setCellStyle(cellStyle);
            
            c=r.createCell(2);
            c.setCellValue(h.fileNo);
            
            c=r.createCell(3);
            c.setCellValue(h.subject);
            
            if(h.outDate!=null)
            {
                c=r.createCell(4);
                c.setCellValue(h.outDate);
                c.setCellStyle(cellStyle);
                
            }
            
            if(h.dispatchedTo!=null)
            {
                c=r.createCell(5);
                c.setCellValue(h.dispatchedTo);
            }
            
            
            
            fis.close();
            System.out.println("closed fis!!");
             
            try{
                FileOutputStream output_file = new FileOutputStream(new File(filename));//Open FileOutputStream to write updates
                workbook.write(output_file);
                
                output_file.flush();//write changes
                output_file.close();
                JOptionPane.showMessageDialog(null, "succesfully added!");
                return true;
            } //write changes
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please close the existing file from excel to write changes");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelParser.class.getName()).log(Level.SEVERE, null, ex);
        } 
           finally {
        }
        return false;
    }
    
}
