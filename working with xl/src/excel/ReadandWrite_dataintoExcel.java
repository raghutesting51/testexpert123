package excel;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReadandWrite_dataintoExcel 
{

	public static void main(String[] args)throws Exception {
		
	
	
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
	//create object for WebDriver
	 //FirefoxDriver Brow=new FirefoxDriver();
		ChromeDriver Brow=new ChromeDriver();
	Brow.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(Brow,20);
	//open application
	Brow.get("http://apps.qaplanet.in/qahrm/login.php");
	
	//Read data objects
	File file=new File("D:\\new1.xls");
	Workbook objjob=Workbook.getWorkbook(file);
	Sheet InputSheet=objjob.getSheet(0);
	
	//write data objects
	WritableWorkbook wb=Workbook.createWorkbook(new File("D:\\new2.xls"));
	WritableSheet OutputSheet=wb.createSheet("HRM", 0);
	Label l=new Label(0,0,"username");
	Label l1=new Label(1,0,"Password");
	Label l2=new Label(2,0,"Result");
	OutputSheet.addCell(l);
	OutputSheet.addCell(l1);
	OutputSheet.addCell(l2);
	Label r1;
	Label r2;
	Label r3;
	
	//get row count
	int Rcount=InputSheet.getRows();
	System.out.println(Rcount);
	for (int i = 1; i < Rcount; i++) 
	{System.out.println("iteration no;"+1);
	
	//create objfor username
	WebElement objUn=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
	objUn.clear();
	objUn.sendKeys(InputSheet.getCell(0, i).getContents());
	
	//create objfor password
	WebElement objPassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
	objPassword.clear();
	objPassword.sendKeys(InputSheet.getCell(1, i).getContents());
	
	//click on login
	WebElement objlogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
	objlogin.click();
	Thread.sleep(2000);
	
String res="Passed";
String res1="Failed";

	//Verify OrangeHRM Home page
if(Brow.getTitle().equals("OrangeHRM"))
{
	System.out.println("Login Successfull");

	r1=new Label(0,i, InputSheet.getCell(0,i).getContents());
	r2=new Label(1,i, InputSheet.getCell(1, i).getContents());		
	r3=new Label(2,i,res);
	OutputSheet.addCell(r1);
	OutputSheet.addCell(r2);
	OutputSheet.addCell(r3);
	//click on logout
	Brow.findElement(By.linkText("Logout")).click();
	Thread.sleep(4000);
}
else
{
	System.out.println("login failed"); 


	r1=new Label(0,i, InputSheet.getCell(0,i).getContents());
	r2=new Label(1,i, InputSheet.getCell(1, i).getContents());
	r3=new Label(2,i,res1);
	OutputSheet.addCell(r1);
	OutputSheet.addCell(r2);
	OutputSheet.addCell(r3);
	Thread.sleep(4000);
	Brow.findElement(By.name("clear")).click();
	
	
}
	
	}
	
	wb.write();
	wb.close();
	Brow.close();
	Brow.quit();
	
	}
	
}
	
	
	
	
	
		
		
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	


