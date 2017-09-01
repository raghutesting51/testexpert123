package orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditQualification {

	public static void main(String[] args)throws Exception 
	{System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
WebDriverWait wait=new WebDriverWait(driver,60);
Actions Act=new Actions(driver);
driver.get("http://apps.qaplanet.in/qahrm/login.php");
if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
{
System.out.println("OrangeHRM - New Level of HR Management");
}
else
{
System.out.println("Home Page failed to display");
}
//create webelements for username,password,login and clear
WebElement objUserName=driver.findElement(By.name("txtUserName"));
WebElement objPassword=driver.findElement(By.name("txtPassword"));
WebElement objLogin=driver.findElement(By.name("Submit"));
WebElement objclear=driver.findElement(By.name("clear"));
//verify username,password,login andclear
if(objUserName.isDisplayed() && objPassword.isDisplayed())
{
System.out.println("username and password are displayed");
}

if(objLogin.isDisplayed() && objclear.isDisplayed())
{
    System.out.println("Login and Clear Button are displayed");
}
Thread.sleep(2000);
//login into orange Hrm
objUserName.sendKeys("qaplanet1");
objPassword.sendKeys("user1");
objLogin.click();
//Verify orange HRM
if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
{
System.out.println("OrangeHRM is displayed");
}
else
{
System.out.println("Failed to login");
}
Thread.sleep(2000);
//Get welcome text
String strweltext=driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
//Verify welcome text
if(strweltext.equals("Welcome qaplanet1"))
{
System.out.println("Welcome qaplanet1 is displayed");
}
//Create WebElements for change password and logout
WebElement objChangePassword=driver.findElement(By.linkText("Change Password"));
WebElement objLogout=driver.findElement(By.linkText("Logout"));
if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
{
System.out.println("Change Password and Logout Are Displayed");
}
Thread.sleep(2000);
//Focus on Admin
//Create WebElement Admin
WebElement objAdmin=driver.findElement(By.id("admin"));
//Mouse over on Admin
Act.moveToElement(objAdmin).build().perform();
Thread.sleep(2000);
//Focus on qualification
WebElement objqualification=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[3]/a/span"));
//mouse over on qualification
Act.moveToElement(objqualification).build().perform();
Thread.sleep(2000);
//Verify qualification Elements
List<WebElement>objlist=driver.findElements(By.xpath(".//*[@id='admin']/ul/li[3]/a/span"));
for (int i = 0; i < objlist.size(); i++)
{String strlist=objlist.get(i).getText();
System.out.println("strlist is displayed");
	if(objlist.get(i).isDisplayed())
	{
		System.out.println("Employment links are"+strlist+"displayed");
	}
Thread.sleep(2000);
//Create WebElement for Education
WebElement objEducation=driver.findElement(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[3]/ul/li[1]/a/span"));
//Mouse over on Education
Act.moveToElement(objEducation).build().perform();
//click on Education
objEducation.click();
//wait for frame and switch to it
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
if(driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Qualification : Education"))
		{
	System.out.println("Qualification : Education is dispalyed");
		}

	//Edit Qualification
//select education id
Thread.sleep(2000);
driver.findElement(By.xpath("//html/body/div/div[2]/form/table/tbody/tr[7]/td[2]/a")).click();
//wait for frame and switch to it
//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
//if(driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/div/h2")).getText().equals("Qualification : Education"))
//{
	//System.out.println("Qualification1 : Education is displayed"); 
	
//}
//Thread.sleep(2000);
	//create webelement for edit
WebElement objEdit=driver.findElement(By.id("editBtn"));
   //click on edit
objEdit.click();	
	//click on institute and clear
    //Create WebElement for institute
WebElement objinstitute=driver.findElement(By.id("txtUni"));
objinstitute.click();
objinstitute.clear();
objinstitute.sendKeys("qaplanet12");

//create webelement for save
WebElement objSave=driver.findElement(By.xpath(".//*[@value='Save']"));
	//click on save
objSave.click();
Thread.sleep(2000);

//verify if edit qualification updated
String strEdit=(driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText());
if(strEdit.equals("Successfully Updated"))
{
	System.out.println("Qualification successfully edited"); 
	
}
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("Logout")).click();
	driver.close();
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
