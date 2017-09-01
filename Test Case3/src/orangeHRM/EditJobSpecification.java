package orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditJobSpecification {

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 WebDriverWait wait=new WebDriverWait(driver,60);
		 Actions Act=new Actions(driver);
		 driver.get("http://apps.qaplanet.in/qahrm/login.php");
		 if (wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		 {
		  System.out.println("OrangeHRM - New Level of HR Management is displayed");
		 }
		 else
		 {
		  System.out.println("Home Page failed to display");
		 }
		 Thread.sleep(2000);
		 //Create Webelements for username,password,login and clear
		 WebElement objUsername=driver.findElement(By.name("txtUserName"));
		 WebElement objPassword=driver.findElement(By.name("txtPassword"));
		 WebElement objlogin=driver.findElement(By.name("Submit"));
		 WebElement objclear=driver.findElement(By.name("clear"));
		 //Verify username,password,login and clear
		if(objUsername.isDisplayed() && objPassword.isDisplayed())
		{
		 System.out.println("username and password are displayed");
		}
		 
		 if(objlogin.isDisplayed() && objclear.isDisplayed())
		 {
		  System.out.println("Login and Clear Button are displayed");
		 }
		 Thread.sleep(2000);
		 //Login to Orange HRM
		 objUsername.sendKeys("qaplanet1");
		 objPassword.sendKeys("user1");
		 objlogin.click();
		 if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		 {
		  System.out.println("OrangeHRM is Displayed");
		 }
		 else
		 {
		  System.out.println("failed to login");
		 }
		 Thread.sleep(2000);
		 //Get welcome text
		 String strWelText=driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
		 //Verify weltext
		 if(strWelText.equals("Welcome qaplanet1"))
		 {
		  System.out.println("Welcome qaplanet1 is displayed");
		 }
		 //Create Change Password and Logout
		 WebElement objChangePassword=driver.findElement(By.linkText("Change Password"));
		    WebElement objLogout=driver.findElement(By.linkText("Logout"));
		 //Verify changepassword and logout
		    if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
		    {
		        System.out.println("Change Password and Logout Are Displayed");
		    }
		Thread.sleep(2000);
		//Creatre WebElement for Admin
		WebElement objAdmin=driver.findElement(By.id("admin"));
		 //Mouse overon Admin
		Act.moveToElement(objAdmin).build().perform();
		Thread.sleep(2000);
		//Create WebElements for Job
		WebElement objJob=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[2]/a/span"));
		Act.moveToElement(objJob).build().perform();
		Thread.sleep(2000);
		 //Verify JobTitle,Specification,PayGrade etc
		 List<WebElement>objList=driver.findElements(By.xpath(".//*[@id='admin']/ul/li[2]/a/span"));
		for (int i = 0; i < objList.size(); i++)
		{
		String strtext=objList.get(i).getText();
		System.out.println(strtext);
		if(objList.get(i).isDisplayed())
		{
		 System.out.println("JobLinks are"+ strtext+"displayed");
		}
		Thread.sleep(2000);
		//Create WebElement for JobSpecification
		WebElement objJobSpecification=driver.findElement(By.linkText("Job Specifications"));
		//Mouse over on JobSpecification
		Act.moveToElement(objJobSpecification).build().perform();
		//click on JobSpecification
		driver.findElement(By.linkText("Job Specifications")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		if(driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Job : Job Specifications"))
		  {
		 System.out.println("Job : Job Specifications is displayed");
		  }
		Thread.sleep(2000);
		//Select JobSpecification by id
		driver.findElement(By.xpath("html/body/div/div[2]/form/table/tbody/tr[7]/td[3]/a")).click();
		//wait for frame and switch to it
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//html/body/div/div[2]/form/div[1]/h2")));
		//create webelement for Edit button and duties field
		WebElement objEdit=driver.findElement(By.id("editBtn"));
		WebElement objduties=driver.findElement(By.name("txtDuties"));
		objEdit.click();
		objduties.sendKeys("manual and automation testing");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(2000);
		
		String strEdit=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
		if(strEdit.equals("Successfully Updated"))
		{
		 System.out.println("Job Specification successfully updated");
		}
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Logout")).click();
		//driver.quit();
		driver.close();
		
		 
		}
		 }
		
		 
		 
		 
		 

	}


