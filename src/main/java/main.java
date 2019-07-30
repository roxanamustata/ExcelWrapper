import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;


public class main {


    public static final String SAMPLE_XLSX_FILE_PATH =
            "D:\\SDA Cursuri\\PROIECTE\\ExcelWrapper\\src\\main\\files\\Excel_File.xlsx";

    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader(SAMPLE_XLSX_FILE_PATH);
        excelReader.printAllSheets();
       ExcelReader.printRows(excelReader.readRows());
       DBApp dbApp=new DBApp();
       dbApp.insertEmployees(excelReader.readRows());


    }
}


