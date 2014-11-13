

package JExcelClass;
import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;


public class JExcelClass {
    public static void main(String[] args) throws IOException, BiffException {
        Workbook wb=Workbook.getWorkbook(new File("Files.xlsx"));
        
        Sheet sheet = wb.getSheet(0);
        int nrows=sheet.getRows();
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < 6; j++) {
                Cell c=sheet.getCell(i,j);
                System.out.println(c.getContents());
            }
            
        }
    }
}
