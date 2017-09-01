package excel;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JXL_JAR 
{ 
	
	public static void main(String[] args) throws Exception
	{
		//to take file as input,use file
		File F1=new File("C:\\Users\\Lab\\Desktop\\OrangeHRm.xls");
		//load workbook
		
Workbook WB=Workbook.getWorkbook(F1);
//Get Specific Sheet
Sheet S1=WB.getSheet("qap");
int i=1;
//Sheet.getCell(cloumn,index,rowindex)
String gBrow=S1.getCell(0, i).getContents();
String gURL=S1.getCell(1, i).getContents();
String gUN=S1.getCell(2, i).getContents();
String gPWD=S1.getCell(3, i).getContents();
String gEmail=S1.getCell(4, i).getContents();
System.out.println(gBrow);
System.out.println(gURL);
System.out.println(gUN);
System.out.println(gPWD);
System.out.println(gEmail);






	}
}

