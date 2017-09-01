package excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class HowtoWriteData_intoExcel {

	public static void main(String[] args)throws Exception {
	WritableWorkbook Wb=Workbook.createWorkbook(new File("C:\\Users\\Lab\\Desktop\\DataintoExcelsheet1.xls"));
	WritableSheet ws=Wb.createSheet("HRM",0);
	WritableSheet ws1=Wb.createSheet("Res",1);
	Label l=new Label(0,0,"username");
	Label l1=new Label(1,0,"password");
	Label r1=new Label(0,1,"qaplanet");
	Label r2=new Label(1,1,"admin");
	ws.addCell(l);
	ws.addCell(l1);
	ws.addCell(r1);
	ws.addCell(r2);
	
	Wb.write();
	Wb.close();

	}

	}


