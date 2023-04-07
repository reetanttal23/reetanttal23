package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {

    @DataProvider(name="formDetailsExcel")
    public static Object[][] provideFormData() throws IOException {

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\testData\\DemoqaTestdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        List<List<Object>> finalList = new ArrayList<List<Object>>();

        Iterator<Row> rowitr = sheet.iterator();
        while (rowitr.hasNext()) {
            List<Object> list = new ArrayList<Object>();
            Row row = rowitr.next();
            Iterator<Cell> columnItr = row.iterator();
            while (columnItr.hasNext()) {
                Cell cell = columnItr.next();
                 if(cell.getCellType()==0){
                     list.add((String.valueOf(cell.getNumericCellValue())));
                 }else
                list.add(cell.getStringCellValue());
            }
            finalList.add(list);
        }

        Object[][] myData = new Object[finalList.size()-1][finalList.get(0).size()];
        for (int i = 0; i < finalList.size()-1; i++) {
            for (int j = 0; j < finalList.get(0).size(); j++) {
                myData[i][j] = finalList.get(i+1).get(j);
            }

        }
        System.out.println((myData));
        return myData;}
}

