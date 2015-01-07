

package FilesManager;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;



public class Search {
    public static List<HardCopy> fileList;
    public static void main(String[] args) {
        
    }
    public Search()
    {
        
    }
    public static List<HardCopy> getByFileNo(String fno)
    {
        fno=fno.toUpperCase();
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy file : fileList) {
            if(file.fileNo.contains(fno))
                retList.add(file);
        }
        return retList;
    }
    public static List<HardCopy> getBySubject(String sub)
    {
        sub=sub.toUpperCase();
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy file : fileList) {
            if(file.subject.contains(sub))
                retList.add(file);
        }
        return retList;
        
    }
    public static List<HardCopy> getByInwardDate(Date inDate)
    {
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy file : fileList) {
            if(file.inDate==null)
//            {
//                System.out.println("null in "+file.subject+"\t "+file.toString());
//                System.out.println(file.inDate);
                continue;
//            }
            if(inDate.getDate()==file.inDate.getDate()&&inDate.getMonth()==file.inDate.getMonth()&&
                    inDate.getYear()==file.inDate.getYear()){
                retList.add(file);
            }
        }
        return retList;
        
    }
    public static List<HardCopy> getByOutwardDate(Date outDate)
    {
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy file : fileList) {
            if(file.outDate!=null&&file.outDate.getDate()==outDate.getDate()&&file.outDate.getMonth()==outDate.getMonth()
                    &&file.outDate.getYear()==outDate.getYear()){
                retList.add(file);
            }
        }
        return retList;
        
    }
    public static List<HardCopy> getByDispatch(String dispString)
    {
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy file : fileList) {
            if(file.dispatchedTo.contains(dispString))
                retList.add(file);
        }
        return retList;
        
    }
    public static List<HardCopy> getByDates(Date inDate,Date outDate)
    {
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy hardCopy : fileList) {
            try {
                Date d1=hardCopy.getIndate(),d2=hardCopy.getOutdate();
                if(inDate.compareTo(d1)<0&&outDate.compareTo(d2)>0){
                    retList.add(hardCopy);
                    System.out.println("d1="+d1+"\td2="+d2);
                }
            } catch (Exception e) {
            }
            
            
        }
        return retList;
        
    }
    public static List<HardCopy> getAllPending()
    {
        List<HardCopy> retList = new LinkedList<>();
        for (HardCopy hardCopy : fileList) {
            try {
                if(hardCopy.outDate==null||hardCopy.inDate==null||hardCopy.dispatchedTo==null)
                    retList.add(hardCopy);
            } catch (Exception e) {
            }
            
            
        }
        return retList;
    }
    
}
