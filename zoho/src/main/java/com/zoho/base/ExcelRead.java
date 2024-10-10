package com.zoho.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	  public static ArrayList getTestData (String filepath) {
	    	ArrayList data = new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(filepath);
			
			Workbook workBook = new XSSFWorkbook(fis);
			
			Sheet sheet = workBook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
			    Row row = rowIterator.next();

			    // Iterate through the cells of the current row
			    Iterator<Cell> cellIterator = row.cellIterator();

			    while (cellIterator.hasNext()) {
			        Cell cell = cellIterator.next();
			        
			        // Retrieve the cell value based on its type
			        switch (cell.getCellType()) {
			            case STRING:
			                data.add(cell.getStringCellValue());
			                break;
			            case NUMERIC:
			                data.add(cell.getNumericCellValue());
			                break;
			            case BOOLEAN:
			                data.add(cell.getBooleanCellValue());
			                break;
			          
			        }
			    }
			   
			}
			
			workBook.close(); // Close the workbook
			fis.close(); // Close the file input stream
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return data;
	}
}

