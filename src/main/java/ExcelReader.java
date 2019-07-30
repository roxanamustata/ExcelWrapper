import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {

    Workbook workbook;

    // Creating a Workbook from an Excel file (.xls or .xlsx)
    public ExcelReader(String filePath) {

        try {
            workbook = WorkbookFactory.create(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    // Retrieving the number of sheets in the Workbook
    public void printNumberOfSheets() {
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
    }


    // Iterating over all the sheets in the workbook
    public void printAllSheets() {
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
//        Retrieving Sheets using Iterator
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println(sheet.getSheetName());
        }
    }

    public ArrayList<ArrayList<Object>> readRows() {
        // Use a for-each loop to iterate over the rows and columns
        Sheet sheet = workbook.getSheetAt(0);
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        ArrayList<ArrayList<Object>> rows = new ArrayList<>();
        for (Row row : sheet) {
            ArrayList<Object> entry = new ArrayList<>();
            for (Cell cell : row) {
                Object cellValue = dataFormatter.formatCellValue(cell);
                entry.add(cellValue);
            }
            rows.add(entry);
        }

        return rows;
    }

    public static void printRows(ArrayList<ArrayList<Object>> rows) {
        for (ArrayList<Object> row : rows) {
            System.out.println(row);
        }
        System.out.println();

    }

}
