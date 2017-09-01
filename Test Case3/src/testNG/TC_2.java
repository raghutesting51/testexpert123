package testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_2 {

 WebDriver Brow;
 WebDriverWait wait;
 Actions Act;
 @BeforeClass
 public void config()
 {
	System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
	Brow=new ChromeDriver();
	wait=new WebDriverWait(Brow,60);
	Brow.manage().window().maximize(); 
	Act=new Actions(Brow);
 }
@AfterClass	
public void shutdown()
{
	//Brow.close();
	//Brow.quit();
}
@Test
public void addemployeeandVERIFYINEMPLOYEELIST() throws Exception
{
	Brow.get("http://apps.qaplanet.in/qahrm/login.php");
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	//Verify home page
	assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
	Reporter.log("Home Page Displayed");
	//Create WebElement for UN,PWD
	WebElement UN=Brow.findElement(By.name("txtUserName"));
	WebElement PWD=Brow.findElement(By.name("txtPassword"));
	//verify UN,PWD
	assertTrue(UN.isDisplayed()&&PWD.isDisplayed());
	Reporter.log("UN and PWD is Displayed");
	String strusername="qaplanet1";
	//type UN,PWD
	UN.sendKeys(strusername);
	PWD.sendKeys("user1");
	//click on login
	Brow.findElement(By.name("Submit")).click();
	wait.until(ExpectedConditions.titleIs("OrangeHRM"));
	//verify orange HRM
	assertEquals(Brow.getTitle(),"OrangeHRM");
	Reporter.log("OrangeHRM is displayed");
	//get welcome text
	 String WelText=Brow.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
	//Verify Welcome text
	 assertEquals(WelText, "Welcome "+ strusername);
	 Reporter.log("Welcome+username is displayed");
	//create webElement for Change Password and Logout
	WebElement CP=Brow.findElement(By.linkText("Change Password"));
	WebElement LO=Brow.findElement(By.linkText("Logout"));
	//Verify Change password and Logout 
	assertTrue(CP.isDisplayed()&&LO.isDisplayed());
	Reporter.log("Change Password and Logout are Displayed");
	//Create WebElement for PIM and Add Employee
	WebElement PIM=Brow.findElement(By.id("pim"));
	
	//mouse over on pim
	Act.moveToElement(PIM).perform();
	
	WebElement AddEmployee=Brow.findElement(By.xpath("//html/body/div[4]/ul/li[2]/ul/li[2]/a/span"));
	//mouse over on Add Employee
	Act.moveToElement(AddEmployee).click().perform();
	//wait for frame and switch to it
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
	//Verify PIM : AddEmployee Page must be displayed
	Thread.sleep(2000);
	Brow.switchTo().frame("rightMenu");
	WebElement PIMAddEmployee=Brow.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2"));
										
	assertEquals(PIMAddEmployee.getText(),"PIM : Add Employee");
	//if(Brow.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText(("PIM:Add Employee"));
	Reporter.log("PIM:Add Employee is Displayed");
	//Get Employee code
	String sEmpcode=Brow.findElement(By.name("txtEmployeeId")).getAttribute("value");
	//........................................................................................
	String sFN="Raghu";
	String sLN="Am";
	//............................................................................................
    //Create WebElement for save
	WebElement Save=Brow.findElement(By.id("btnEdit"));
	//keep all fields as blank and click on save
	Save.click();
	//wait for Alert
	Alert A=wait.until(ExpectedConditions.alertIsPresent());
	//Verify Last Name Empty alert
		if(A.getText().equals("Last Name Empty!"))
		{
			System.out.println("Last Name Empty!displayed");
			A.accept();
			Brow.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		}
		//click on save
		Save.click();
		//wait for alert
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		//verify First Name empty alert
		if (A1.getText().equals("First Name Empty!"))
		{
			System.out.println("First Name Empty! displayed");
			A1.accept();
			Brow.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		}
			
//click on save
        Save.click();
//wait for personal details page
       WebElement personaldetails=Brow.findElement(By.xpath("//html/body/form/div[2]/div[1]/div[2]/div[1]/h2")); 
       assertEquals(personaldetails.getText(), "Personal Details");
       Reporter.log("Personal Details is displayed");
        
       //if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='personal']/div[1]/div[2]/div[1]/h2"), "Personal Details")))
       //{
    		//System.out.println("Personal Details Displayed");
    		
    	//}
    	//Switch to Parent Frame
    	Brow.switchTo().parentFrame();
    	
    	//Employee List
    	//Mouse over onPim
    	Act.moveToElement(PIM).perform();
    	//Click on Employee List
    	Brow.findElement(By.linkText("Employee List")).click();
    	//Wait for Frame and Switch to it
    	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
    	Brow.switchTo().frame("rightMenu");
    	
    	//Verify Employee Information
    	WebElement EI=Brow.findElement(By.xpath(".//*[@id='standardView']/div[1]/h2"));
    	assertEquals(EI.getText(), "Employee Information");
    	Reporter.log("Employee Information is Displayed");
    	/*//if(Brow.findElement(By.xpath(".//*[@id='standardView']/div[1]/h2")).getText().equals("Employee Information"))
    	//{
    		//System.out.println("Employee Information Displayed");
    	//}	

    	//Check Employee Details
    	//Get Row Count
    	//Thread.sleep(2000);
    	//int rc=Brow.findElements(By.xpath("//*[@id='standardView']/table/tbody/tr")).size();
    	//System.out.println(rc);
    	
    	//int i;
    	//for(i=1;i<rc;i++)
    	{
    		//Get Second Column Data
    		//String sEmpID=Brow.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[2]")).getText();
    		//Get Third Column data
    		//String sEmpName=Brow.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[3]/a")).getText();
    		if(sEmpName.equals(sFN+""+sLN) && sEmpID.equals(sEmpcode))
    {
    	System.out.println(sEmpcode+" "+sEmpName+" displayed at:"+i);
    	break;
    }*/
    		
    		Brow.switchTo().defaultContent();
    		//Click on Logout
    		Brow.findElement(By.linkText("Logout")).click();
    		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
    		//verify Home Page
    		assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
    		Reporter.log("SignOff Successfull and HomePage Displayed");
    								
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
		}
}






	


