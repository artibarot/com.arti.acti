package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	XSSFWorkbook wb;
	// this constructor help us to load the excel file when this class is called 
	public  ExcelUtil (String excelpath) {
	try   //Try we use for any external file while we catch
	{
	File src = new File(excelpath);
	FileInputStream fis = new FileInputStream (src);
	wb = new XSSFWorkbook(fis);
	}
	 
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println("unable to load excel sheet please check the path "+e.getMessage());
	}
	}
	//This method is used to get the data from excel file
	public int getRows(int sheetnum)
	{
		int rows = wb.getSheetAt(sheetnum).getLastRowNum()+1;
		return rows;
	}
	//This method is used to get the date from excel cells
	public String getCellData(int sheetnum,int row,int col)
	{
		String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
	    return data;
	 }
	}
