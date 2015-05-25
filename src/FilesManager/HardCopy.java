

package FilesManager;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;



public class HardCopy {
    public int key;
    public int rowNum;
    public String sno;
    public Date inDate,outDate;
    public String fileNo,subject,dispatchedTo;

    public HardCopy() {
        inDate=outDate=null;
        fileNo=subject=dispatchedTo=null;
    }
    public  HardCopy(int rowno,String ssno,String ind,String fileno,String sub,String outd,String dispatch)
    {
        
        sno=ssno.replaceFirst("\\.0", "");
        rowNum=rowno;
        
        fileNo=fileno.toUpperCase();
        subject=sub.toUpperCase();
        dispatchedTo=dispatch.toUpperCase();
        SimpleDateFormat dateFormatter1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormatter2=new SimpleDateFormat("dd-MMM-yyyy");
        if(ind!=null){
            try {
                inDate=dateFormatter1.parse(ind);
            } catch (ParseException e) {
                try {
                    inDate=dateFormatter2.parse(ind);
                } catch (ParseException ex) {
                  
                }
            }
        }
        
        if(outd!=null){
            try {
                outDate=dateFormatter1.parse(outd);
            } catch (ParseException e) {
                try {
                    outDate=dateFormatter2.parse(outd);
                } catch (ParseException ex) {
                  
                }
            }
        }
//        System.out.println(this);
    }
    public HardCopy(Cell a,Cell b,Cell c,Cell d,Cell e,Cell f) throws Exception
    {
        
//        this.init((int)a.getNumericCellValue(), b.getStringCellValue(),c.getStringCellValue(), 
//               d.getStringCellValue(), e.getStringCellValue(),f.getStringCellValue());
        int snoI = 0;
        String b1 ="",c1 = "",d1 = "",e1 = "",f1 = "";
        if(a!=null)
            switch(a.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    snoI=(int)a.getNumericCellValue();
                    break;
                case Cell.CELL_TYPE_STRING:
                    snoI=Integer.parseInt(a.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK:
                case Cell.CELL_TYPE_BOOLEAN:
                case Cell.CELL_TYPE_ERROR:
                case Cell.CELL_TYPE_FORMULA:
                    throw new Exception("unexpected things in col 1");
            }
        if(b!=null)
            switch(b.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    b1=String.valueOf(b.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    b1=b.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    b1="";
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                case Cell.CELL_TYPE_ERROR:
                case Cell.CELL_TYPE_FORMULA:
                    throw new Exception("unexpected things in col 1");
            }
        
        if(c!=null)
            switch(c.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    c1=String.valueOf(c.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    c1=c.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    c1="";
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                case Cell.CELL_TYPE_ERROR:
                case Cell.CELL_TYPE_FORMULA:
                    throw new Exception("unexpected things in col 1");
            }
        if(d!=null)
            switch(d.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    d1=String.valueOf(d.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    d1=d.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    d1="";
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                case Cell.CELL_TYPE_ERROR:
                case Cell.CELL_TYPE_FORMULA:
                    throw new Exception("unexpected things in col 1");
            }
        if(e!=null)
            switch(e.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    e1=String.valueOf(e.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    e1=e.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    e1="";
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                case Cell.CELL_TYPE_ERROR:
                case Cell.CELL_TYPE_FORMULA:
                    throw new Exception("unexpected things in col 1");
            }
        if(f!=null)
            switch(f.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    f1=String.valueOf(f.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    f1=f.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    f1="";
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                case Cell.CELL_TYPE_ERROR:
                case Cell.CELL_TYPE_FORMULA:
                    throw new Exception("unexpected things in col 1");
            }
//        init(snoI, b1, c1, d1, e1, f1);
    }
    
    public Date getIndate()
    {
        return inDate;
    }
    public Date getOutdate()
    {
        return outDate;
    }
    @Override
    public String toString()
    {
        String res=new String();
        try{
            if(inDate==null)
                res="INDATE NULLL\t";
            else
                res="INDATE NON NULL\t";
            res+=sno+"\t"+inDate.toString()+"\t"+fileNo+"\t"+subject+"\t";
            if(outDate!=null)
                res+=outDate.toString()+"\t";
            if(dispatchedTo!=null)
                res+=dispatchedTo+"\n";  
            res+=rowNum+"\n";
        }
        
        catch(Exception e)
        {
            
        }
        
        return res;
    }
    
    public boolean isPending()
    {
        return inDate==null||dispatchedTo.equals("");
    }
}
