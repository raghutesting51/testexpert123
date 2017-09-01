package orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteJobSpecification {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,60);
		Actions Act=new Actions(driver);
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("OrangeHRM - New Level of HR Management is displayed");
		}
		else
		{
			System.out.println("Home Page failed to display");
		}
		//Create WebElements for username,password,login and clear
		WebElement objUserName=driver.findElement(By.name("txtUserName"));
		WebElement objPassword=driver.findElement(By.name("txtPassword"));
		WebElement objLogin=driver.findElement(By.name("Submit"));
		WebElement objclear=driver.findElement(By.name("clear"));
		if(objUserName.isDisplayed() && objPassword.isDisplayed())
		{
			System.out.println("username and password are displayed");
		}
		if(objLogin.isDisplayed() && objclear.isDisplayed())
		{
			System.out.println("Login and Clear Button are displayed");
		}
Thread.sleep(2000);
objUserName.sendKeys("qaplanet1");
objPassword.sendKeys("user1");
objLogin.click();
if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
{
	System.out.println("OrangeHRM page is dispalyed");
}
else
{
	System.out.println("Failed to login");
}
Thread.sleep(2000);
//Get WelText
String strwelText=driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
//Verify Welcome Text
if(strwelText.equals("Welcome qaplanet1"))
{
	System.out.println("Welcome qaplanet1 is displayed");
}
//Create WebElements for change passowrd and logout
WebElement objChangePassword=driver.findElement(By.linkText("Change Password"));
WebElement objLogout=driver.findElement(By.linkText("Logout"));
if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
{
	System.out.println("Change Password and Logout Are Displayed");
}
Thread.sleep(2000);
//Create WebElement for Admin
WebElement objAdmin=driver.findElement(By.id("admin"));
//Mouse over on admin
Act.moveToElement(objAdmin).build().perform();
Thread.sleep(2000);
//Create WebElement for job
WebElement objJob=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[2]/a/span"));
//Mouse over on Job
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
		System.out.println("JobLinks are"+strtext+"displayed");
		}
	Thread.sleep(2000);
	//Create WebElement for JobSpecification
	WebElement objJobSpecification=driver.findElement(By.linkText("Job Specifications"));
	Act.moveToElement(objJobSpecification).build().perform();
	objJobSpecification.click();
	//wait for frame and switch to it
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
	if(driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Job : Job Specifications"))
	{
		System.out.println("Job : Job Specifications is displayed");
	}
	
	Thread.sleep(2000);
	//Create WebElement for Delete button
	WebElement objDelete=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[2]"));
	//select job specification by id
	driver.findElement(By.xpath("//html/body/div/div[2]/form/table/tbody/tr[1]/td[1]/input")).click();
	objDelete.click();
	driver.switchTo().alert().accept();
	//Verify if selected jobSpecification is deleted
	String strdel=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
	if(strdel.equals("Successfully Deleted"))
	{
		System.out.println("Job Specification successfully deleted");
	}
	
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("Logout")).click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}














	}

}
