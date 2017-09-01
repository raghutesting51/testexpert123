package orangeHRM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenHRMHomePage 
{

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe" );
		ChromeDriver Driver=new ChromeDriver();
		
//System.setProperty("webdriver.gecko.driver", "D:\\tet\\Selenium_Demp\\geckodriver.exe");
//FirefoxDriver Driver=new FirefoxDriver();
		
		Driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(Driver,40);
		Actions Act=new Actions(Driver);
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		
if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
{
	System.out.println("HomePage Is Diplayed");
}
else
{
	System.out.println("Homepage Failed To Display");
	return;
}
//create WebElements for LoginName,Password,login and Clear
WebElement objLoginName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
WebElement objPassword=Driver.findElement(By.name("txtPassword"));
WebElement objLogin=Driver.findElement(By.name("Submit"));
WebElement objclear=Driver.findElement(By.name("clear"));
if (objLoginName.isDisplayed())
{
	System.out.println("LoginName is Dipslayed");
}
if (objPassword.isDisplayed())
{
	System.out.print("Password is Dispalyed");
	
}
	if (objLogin.isDisplayed())
	{
		System.out.println("Login button is Displayed");
		
	}
	if (objclear.isDisplayed())
	{
		System.out.println("Clear button is Displayed");
	}
	
		String strLoginName="qaplanet1";
		String strPassword="user1";
//Enter Valid LoginName,Password and click on Login
		objLoginName.clear();
		objLoginName.sendKeys(strLoginName);
		objPassword.clear();
		objPassword.sendKeys(strPassword);	
		objLogin.click();
//Verify OrangeHRM page is displayed and Verify "Welcome Message","Change Password"& logout Link
		//Driver.getTitle().equals("OrangeHRM"));
	if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))	
	{
	System.out.println("OrangeHRM Page Displayed");	

	}
	else
	{
		System.out.println("Failed To Login");
		return;
	}
		//Get Welcome Text
		String strWelText=Driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
		//verify Welcome Text
		
		if(strWelText.equals("Welcome "+strLoginName))
		{
			System.out.println("Welcome "+strLoginName+"displayed");
		}
		
		

// Create WebElements for ChangePassowrd and Logout
	
	WebElement objChangePassword=Driver.findElement(By.linkText("Change Password"));
	WebElement objLogout=Driver.findElement(By.linkText("Logout"));
	
	if (objChangePassword.isDisplayed())
	{
		System.out.println("Change Password");
		
	}
	if (objLogout.isDisplayed())
	{
		System.out.println("Logout");
		}
	//create WebElement for PIM
	WebElement objPIM=Driver.findElement(By.id("pim"));
	//Mouse Over on PIM
	Act.moveToElement(objPIM).perform();
	//Click on Add Employee
	Driver.findElement(By.linkText("Add Employee")).click();
	//Wait for Frame and Switch to it
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
	//Verify PIM:Add Employee
	if (Driver.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText().equals("PIM:Add Employee"))
	{
		System.out.println("PIM:Add Employee Displayed");
	}
		
	//Get Employee Code
	String sEmpcode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
	//........................................................
	String sFN="Raghu";
	String sLN="Am";
	//...................
	//Create WebElement for save
	WebElement objSave=Driver.findElement(By.id("btnEdit"));
	//Click on save
	objSave.click();
	//Wait for Alert
	Alert A=wait.until(ExpectedConditions.alertIsPresent());
	//Verify Last Name Empty alert
	if(A.getText().equals("Last Name Empty!"))
	{
		System.out.println("Last Name Empty!displayed");
		A.accept();
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
	}
	//click on save
	objSave.click();
	//wait for alert
	Alert A1=wait.until(ExpectedConditions.alertIsPresent());
	//verify First Name empty alert
	if (A1.getText().equals("First Name Empty!"))
	{
		System.out.println("First Name Empty! displayed");
		A1.accept();
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
	}
		
	//click on save
	objSave.click();
	//wait for personal details
	if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='personal']/div[1]/div[2]/div[1]/h2"), "Personal Details")))
	{
		System.out.println("Personal Details Displayed");
		
	}
	//Switch to Parent Frame
	Driver.switchTo().parentFrame();
	//Employee List
	//Mouse over onPim
	Act.moveToElement(objPIM).perform();
	//Click on Employee List
	Driver.findElement(By.linkText("Employee List")).click();
	//Wait for Frame and Switch to it
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
	//Verify Employee Information
	if(Driver.findElement(By.xpath(".//*[@id='standardView']/div[1]/h2")).getText().equals("Employee Information"))
	{
		System.out.println("Employee Information Displayed");
	}	
	//Check Employee Details
	//Get Row Count
	int rc=Driver.findElements(By.xpath("//*[@id='standardView']/table/tbody/tr")).size();
	int i;
	for(i=1;i<rc;i++)
	{
		//Get Second Column Data
		String sEmpID=Driver.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[2]")).getText();
		//Get Third Column data
		String sEmpName=Driver.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[3]/a")).getText();
		if(sEmpName.equals(sFN+""+sLN) && sEmpID.equals(sEmpcode))
{
	System.out.println(sEmpcode+" "+sEmpName+" displayed at:"+i);
	break;
}
				}
	//Switch to top frame
	Driver.switchTo().defaultContent();
	//Click on Logout
	objLogout.click();
	//verify Home Page
	if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
	{
		System.out.println("Signoff sucessfull & Home Page displayed");
	}
	else
	{
		System.out.println("Failed to Signoff");
		return;
	}
	//--------------------------------------------------------------
	Driver.close();
	Driver.quit();
	
	
	
}
}
