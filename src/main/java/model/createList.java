package model;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class createList {

	public String creator(ArrayList[] tables, int[] rowNo, String file) {
		//Scanner scan = new Scanner(System.in);
		//String name = scan.next();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = null;
		System.out.println("Filling table with " + tables.length + " sheets...");
		for (int i = 0; i < tables.length; i++) {
			sheet = workbook.createSheet("Table " + i);
			int rowNum = 0;
			int colNum = 0;
			Row row = sheet.createRow(rowNum);
			for (int j = 0; j < tables[i].size(); j++) {
				if(rowNo[i] != 0) {
					if (j % rowNo[i] == 0) {
						row = sheet.createRow(++rowNum);
						colNum = 0;
					}
					Cell cell = row.createCell(colNum++);
					cell.setCellValue((String) tables[i].get(j));
				}
			}
			if(rowNo[i] != 0)
				for (int j = 0; j < tables[i].size() / rowNo[i]; j++) {
					sheet.autoSizeColumn(j);
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream(file + ".xlsx")) {
			workbook.write(outputStream);
			return file;
		} catch (Exception e) {
			return "";
		}
	}

}
