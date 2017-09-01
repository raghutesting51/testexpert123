package orangeHRM;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToParentFrame;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditDeleteJobTitle {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(Driver,60);
		Actions Act=new Actions(Driver);
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("OrangeHRM - New Level of HR Management is Displayed");
		}
		else
		{
			System.out.println("Home Page failed to display");
			return;
		}
		//Create WebElements for UserName,password,Login and Clear
		WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPassword=Driver.findElement(By.name("txtPassword"));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		//Verify UserName,Password,Login and Clear
		if(objUserName.isDisplayed())
		{
			System.out.println("LoginName Displayed");
			
		}
		if(objPassword.isDisplayed())
		{
			System.out.println("Password Displayed");
		}
		if(objLogin.isDisplayed() && objClear.isDisplayed())
				{
			System.out.println("Login and Clear Button are Displayed");
				}
		String strUserName="Qaplanet1";
		String strPassword="user1";
		//Enter Login Name,password and click on login
		objUserName.sendKeys(strUserName);
		objPassword.sendKeys(strPassword);
		objLogin.click();
			if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
			{
				System.out.println("OrangeHRM is Displayed");
			}
			else
			{
				System.out.println("Failed to login");
				return;
			}
		//Get Welcome text
			String strWelText=Driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
		//Verify Welcome text
			if(strWelText.equals("Welcome" +strUserName))
			{
				System.out.println("Welcome" +strUserName +"Displayed");
			}
			//Create WebElements for ChangePassword and Logout
			WebElement objChangePassword=Driver.findElement(By.linkText("Change Password"));
			WebElement objLogout=Driver.findElement(By.linkText("Logout"));
			//Verify ChangePassowrd and logout
			if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
			{
				System.out.println("Change Password and Logout Are Displayed");
			}
		Thread.sleep(2000);
		//Focus on Admin
			//Create WebElement for Admin
			WebElement objAdmin=Driver.findElement(By.id("admin"));
			//Mouse over on Admin
			Act.moveToElement(objAdmin).build().perform();
			
			Thread.sleep(2000);
		//Focus On JOb
			WebElement objJobs=Driver.findElement(By.xpath("//span[text()='Job']"));
			//Mouse over on Job
		Act.moveToElement(objJobs).build().perform();
			//Verify Job Title,Job specification, Pay Grade ..etc
			//String strJobTitle="Job Titles";
			//String strJobspecification="Job Specifications";
			//String strPayGrade="Pay Grades";
			//.add(strJobTitle);
			//JL.add(strJobspecification);
			//JL.add(strPayGrade);
			//Iterator<String>ITRT1=JL.iterator();
			//while(ITRT1.hasNext())
			//{
				//String IT= ITRT1.next();
				//System.out.println(IT);
						
			//}
		//Thread.sleep(2000);
		//Create WebElement for JobTitles
		WebElement objJobTitle=Driver.findElement(By.linkText("Job Titles"));
		//Mouse over on JobTittle
		Act.moveToElement(objJobTitle).build().perform();
		//click on JobTittle
		objJobTitle.click();
		//wait for Frame and Switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		if(Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Job : Job Title"))
				{
			System.out.println("Job : Job Title is Displayed");
				}
		Thread.sleep(2000);
//Edit Job title
		//Select job Title
		Driver.findElement(By.xpath("//html/body/div/div[2]/form/table/tbody/tr[1]/td[2]/a")).click();
//Create WebElement for Edit
		WebElement objEdit=Driver.findElement(By.id("editBtn"));
		objEdit.click();
			Thread.sleep(3000);
			WebElement objJobSpecification=Driver.findElement(By.id("cmbJobSpecId"));
			Select jobSpec=new Select(objJobSpecification);
			jobSpec.selectByIndex(4);
			Thread.sleep(4000);
			Driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/form/div[4]/input[1]")).click();
			
Thread.sleep(3000);
String strEdit=Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
if(strEdit.equals("Successfully Updated"))
{
	System.out.println("JobTitle Successfully Updated");
}
Thread.sleep(4000);
	
	//Delete Job Title
		Driver.findElement(By.xpath("html/body/div/div[2]/form/table/tbody/tr[1]/td[1]/input")).click();
	//Create WebElement for Delete
		WebElement objDelete=Driver.findElement(By.xpath("//input[@value='Delete']"));
	objDelete.click();
		
		
		Driver.switchTo().alert().accept();
	String strDelete=Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")).getText();
	if(strDelete.equals("Successfully Deleted"))
	{
		System.out.println("Job Tilte Deleted Successfully");
	}
		
	Thread.sleep(4000);	
		Driver.switchTo().parentFrame();
		Thread.sleep(2000);
		Driver.findElement(By.linkText("Logout")).click();
		Driver.close();
		Driver.quit();
	
	
	}

}
