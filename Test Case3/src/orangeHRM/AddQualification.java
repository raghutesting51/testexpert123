package orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddQualification {

	public static void main(String[] args) throws Exception 
	{
System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
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
List<WebElement>objList=driver.findElements(By.xpath(".//*[@id='admin']/ul/li[3]/a/span"));
for (int i = 0; i < objList.size(); i++) {

String strtext=objList.get(i).getText();
System.out.println(strtext);
if(objList.get(i).isDisplayed())
{
    System.out.println("qualification are"+strtext+"displayed");
}
Thread.sleep(2000);
//Create WebElement for Education
WebElement objEducation=driver.findElement(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[3]/ul/li[1]/a/span"));
//Mouse over on Education
Act.moveToElement(objEducation).build().perform();
//click on Education
objEducation.click();
//Wait for frame and  switch to it
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
if(driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Qualification : Education"))
{
	System.out.println("Qualification : Education is displayed");
}

//Verify add,delete and searchby button
WebElement objAdd=driver.findElement(By.className("plainbtn"));
WebElement objDelete=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
WebElement objsearchby=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/select"));
if(objAdd.isDisplayed() && objDelete.isDisplayed() && objsearchby.isDisplayed())
{
	System.out.println("Add,Delete and Search Buttons are displayed");
}
Thread.sleep(2000);
//click on add
objAdd.click();
//wait for frame and switch to it
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
if(driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/div/h2")).getText().equals("Qualification : Education"))
{
	System.out.println("Qualification :Add Education is displayed" );
}
//Create WebElement for institute and course and save
WebElement objinstitute=driver.findElement(By.name("txtUni"));
WebElement objcourse=driver.findElement(By.name("txtDeg"));
WebElement objSave=driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/form/div/input[1]"));
Thread.sleep(2000);
objinstitute.click();
objinstitute.sendKeys("qaplanet");
objcourse.click();
objcourse.sendKeys("selenium12");
objSave.click();
Thread.sleep(2000);
//verify if successfully added
String strAdded=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
if(strAdded.equals("Successfully Added"))
{
	System.out.println("Education successfully added");
}
Thread.sleep(2000);

//Verify newly added qualification in Qualification
//Get row count
int rc=driver.findElements(By.xpath("//html/body/div/div[2]/form/table/tbody/tr")).size();
for (int j = 0; j < rc; j++) 

{String strA=driver.findElement(By.xpath("//html/body/div/div[2]/form/table/tbody/tr[8]/td[3]/a")).getText();
if(strA.equals("selenium12"))
{
	System.out.println("newly added qualification displayed");
	break;
}

Thread.sleep(2000);
driver.switchTo().defaultContent();
driver.findElement(By.linkText("Logout")).click();
driver.close();

	
}










	}

	}
}
