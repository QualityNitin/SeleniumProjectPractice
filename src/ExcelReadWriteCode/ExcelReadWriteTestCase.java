package ExcelReadWriteCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWriteTestCase {

	public static void main(String[] args) throws IOException {

		String FilePath = System.getProperty("user.dir") + "/TestDataExternalFiles/TestData.xlsx";
		System.out.println(FilePath);
		FileInputStream fis = new FileInputStream(FilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int row_num = sheet.getPhysicalNumberOfRows();

		DataFormatter formatter = new DataFormatter();

		for (int r = 0; r < row_num; r++) {

			XSSFRow row = sheet.getRow(r);

			if (row != null) {
				int column = row.getLastCellNum();

				for (int c = 0; c < column; c++) {
					XSSFCell cell = row.getCell(c);

					String cellValue = formatter.formatCellValue(cell);
					System.out.print(cellValue + "\t | \t");
				}
				System.out.println();
			}
		}
		
		
		fis.close();
		
		
		int nextRow = sheet.getLastRowNum() + 1;
		
		XSSFRow newRow = sheet.createRow(nextRow);
		
		
		String[] newPlayerData = 
			{"MS Dhoni", "India", "CSK"	};
		
		
		
		
		for(int i=0; i< newPlayerData.length ; i++)
		{
			XSSFCell cell = newRow.createCell(i);
			cell.setCellValue(newPlayerData[i]);
		}
		
		FileOutputStream fos = new FileOutputStream(FilePath);
		workbook.write(fos);
		fos.close();
		
		workbook.close();
	}

}
