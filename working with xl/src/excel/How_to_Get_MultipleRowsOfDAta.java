package excel;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class How_to_Get_MultipleRowsOfDAta {
	public static void main(String[] args)throws Exception
	{
	File File=new File("C:\\Users\\Lab\\Desktop\\multiple rows.xls");
	
	Workbook objWB=Workbook.getWorkbook(File);
	Sheet S1=objWB.getSheet(1);
	//Get Row count
	int rows=S1.getRows();
	for (int i = 0; i < rows; i++) 
	{String UN=S1.getCell(0,1).getContents();
	String pwd=S1.getCell(1, 1).getContents();
	System.out.println(UN+""+pwd);
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

