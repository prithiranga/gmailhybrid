package com.gmail.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GmailExcelData {

	private XSSFWorkbook wb;

	public GmailExcelData() throws IOException {
		FileInputStream fis = null;
		File src = new File("./GmailApplicationData/gmailAppData.xlsx");
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (fis != null)
				fis.close();
		}
	}

	public String getNExceldata(int sIndex, int row, int col) {
		return "" + (int) wb.getSheetAt(sIndex).getRow(row).getCell(col).getNumericCellValue();
	}

	public String getSExceldata(int sIndex, int row, int col) {
		return wb.getSheetAt(sIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public int getRowCount(int sIndex) {
		return wb.getSheetAt(sIndex).getLastRowNum() + 1;
	}

	public static GmailExcelData getExcelConfig() throws IOException {
		return new GmailExcelData();
	}
}
