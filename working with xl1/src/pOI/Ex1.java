package pOI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex1 {

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver Brow=new ChromeDriver();
		Brow.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(Brow,20);
		
		//open application
		Brow.get("http://apps.qaplanet.in/qahrm/login.php");
		
		//Read data objects
		
		InputStream inp = new FileInputStream("D:\new.xlsx");
		//HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
		XSSFWorkbook wb = new XSSFWorkbook();
		//ExcelExtractor extractor = new ExcelExtractor(wb);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		//write data objects
		
		Workbook wb1 = new XSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("D:\new3.xlsx");
	    wb1.write(fileOut);
	    fileOut.close();
	    
		
		
		
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		

	}

}
