package com.dburlacu.file.services;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dburlacu.model.Prestator;
import com.dburlacu.model.Specificari;
import com.dburlacu.model.Tichete;

public class ReadTicheteFromExcel
{
    public static List<Tichete> readFile(File filePath, Prestator prestator, Specificari specific, Double cost)
    {
    	List<Tichete> tichetList = new ArrayList<Tichete>();
    	Tichete tichet;
        try
        {
            FileInputStream file = new FileInputStream((filePath));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                if(row.getRowNum()>0)
                {
                Iterator<Cell> cellIterator = row.cellIterator();
                 tichet = new Tichete();
                while (cellIterator.hasNext())
                {
                 
                	Cell cell = cellIterator.next();
                	System.out.println(cell.getColumnIndex());
                	switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                        	if(cell.getColumnIndex()==0)
                        	{
                        		tichet.setFromTichet(Integer.valueOf((int) cell.getNumericCellValue()));
                        	}
                        	if(cell.getColumnIndex()==1)
                        	{
                        		tichet.setToTichet(Integer.valueOf((int) cell.getNumericCellValue()));
                        	}
                        	if(cell.getColumnIndex()==3)
                        	{
                        		tichet.setDurataTichet(Integer.valueOf((int) cell.getNumericCellValue()));
                        	}
                        	
                        	if(cell.getColumnIndex()==4)
                        	{
                        		
                        		if (DateUtil.isCellDateFormatted(cell))
                        		{
                        		    tichet.setFromDate(cell.getDateCellValue());

                        		}
                        		if (DateUtil.isCellDateFormatted(cell)) {
                        			
                        		}
                        		else {
                                	System.out.println(cell.getCellType()+" "+cell.getNumericCellValue());
//                                	tichet.setToDate(cell.getNumericCellValue());
                                }
                        	}
                        	
                        	if(cell.getColumnIndex()==5)
                        	{
                        		if (DateUtil.isCellDateFormatted(cell)) {
                        			tichet.setToDate(cell.getDateCellValue());
                                } else {
                                	System.out.println(cell.getCellType()+" "+cell.getNumericCellValue());
//                                	tichet.setToDate(cell.getNumericCellValue());
                                }
                        	}
                        	
                        break;
                        case Cell.CELL_TYPE_STRING:
                        	if(cell.getColumnIndex()==2)
                        	{
                        	tichet.setSeriaTichet(cell.getStringCellValue());
                        	}
                        	
                        	if(cell.getColumnIndex()==4)
                        	{
                        		
                        		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                        		String dateInString = cell.getStringCellValue();
                        	 
                        		try {
                        	 
                        			Date date = formatter.parse(dateInString);
                        			System.out.println(date);
                        			tichet.setFromDate(date);
                        	 
                        		} catch (ParseException e) {
                        			e.printStackTrace();
                        		}
                        	}	
                        	if(cell.getColumnIndex()==5)
                        	{
                        		
                        		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                        		String dateInString = cell.getStringCellValue();
                        	 
                        		try {
                        	 
                        			Date date = formatter.parse(dateInString);
                        			System.out.println(date);
                        			tichet.setToDate(date);
                        	 
                        		} catch (ParseException e) {
                        			e.printStackTrace();
                        		}
                        	}	
                        break;
                    }                 
                    
                }
                
                tichet.setPrestator(prestator);
                tichet.setSpecific(specific);
                tichet.setCostTichet(cost);
                
                tichetList.add(tichet);
                
            }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return tichetList;
    }
}