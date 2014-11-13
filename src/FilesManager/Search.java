

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
            
        }
        return retList;
        
    }
    public static List<HardCopy> getByOutwardDate(Date inDate)
    {
        List<HardCopy> retList = new LinkedList<>();
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
                if(d1.compareTo(d2)<0){
                    retList.add(hardCopy);
                }
            } catch (Exception e) {
            }
            
            
        }
        return retList;
        
    }
    
}
