package testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_1 {
WebDriver Brow;
WebDriverWait wait;
@BeforeClass
public void Config()
{
	System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
	Brow=new ChromeDriver();
	wait=new WebDriverWait(Brow,30);
	Brow.manage().window().maximize();
}
@AfterClass
public void Shutdown()
{
	Brow.close();
	Brow.quit();
	
}

@Test
public void VerifyOrangeHRM()
{
	Brow.get("http://apps.qaplanet.in/qahrm/login.php");
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	//verify Home page
	assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
	Reporter.log("Home Page Displayed");
	//Create object for UN,PWD
	WebElement UN=Brow.findElement(By.name("txtUserName"));
	WebElement PWD=Brow.findElement(By.name("txtPassword"));
	//Verify UN,PWD
	assertTrue(UN.isDisplayed()&&PWD.isDisplayed());
	Reporter.log("UN and PWD is Displayed");
	String strusername="qaplanet1";
	//type UN,PWD
	UN.sendKeys(strusername);
	PWD.sendKeys("user1");
	//click on login
	Brow.findElement(By.name("Submit")).click();
	wait.until(ExpectedConditions.titleIs("OrangeHRM"));
	//Verify Orange HRM
	assertEquals(Brow.getTitle(),"OrangeHRM");
	Reporter.log("Orange HRM page is Displayed");
	//Get Welcome Text
	String WelText=Brow.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
	//verify Welcome Text
	assertEquals(WelText, "Welcome "+strusername);
	Reporter.log("Welcome+username is displayed");
	//Click on Logout
	Brow.findElement(By.linkText("Logout")).click();
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	//verify Home Page
	assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
	Reporter.log("SignOff Successfull and HomePage Displayed");
							
	
	
	
}


	
	
	}


