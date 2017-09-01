package orangeHRM;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddJobSpecification{

	public static void main(String[] args)throws Exception {
		
		 
			 System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
			 ChromeDriver driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 WebDriverWait wait=new WebDriverWait(driver,60);
			 Actions Act=new Actions(driver);
			 driver.get("http://apps.qaplanet.in/qahrm/login.php");
			 if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
			   {
			  System.out.println("OrangeHRM - New Level of HR Management is Dispalyed");
			   }
			 else
			 {
			  System.out.println("Home Page Failed to Display");
			 }
			 Thread.sleep(2000);
			 //Create WebElements for UserName,Password,Login and Clear
			  WebElement objUserName=driver.findElement(By.name("txtUserName"));
			  WebElement objPassword=driver.findElement(By.name("txtPassword"));
			  WebElement objLogin=driver.findElement(By.name("Submit"));
			  WebElement objClear=driver.findElement(By.name("clear"));
			 if(objUserName.isDisplayed() && objPassword.isDisplayed())
			 {
			  System.out.println("User Name and Password are displayed");
			 }
			 if(objLogin.isDisplayed() && objClear.isDisplayed())
			 {
			  System.out.println("Login and Clear Button are Displayed");
			 }
			 Thread.sleep(2000);
			 objUserName.sendKeys("qaplanet1");
			 objPassword.sendKeys("user1");
			 
			 objLogin.click();
			 if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
			 {
			  System.out.println("OrangeHRM");
			 }
			 else
			 {
			  System.out.println("Failed to Login");
			  return;
			 }
			  //Verify Welcome Text
			 String StrWelText=driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
			 if(StrWelText.equals("Welcome qaplanet1"))
			 {
			  System.out.println("Welcome qaplanet1 is Dispalyed");
			 }
			 //Create WebElements for Change Password and Logout
			 WebElement objChangePassword=driver.findElement(By.linkText("Change Password"));
			 WebElement objLogout=driver.findElement(By.linkText("Logout"));
			 if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
			 {
			  System.out.println("ChangePassword and Logout are Displayed");
			 }
			 
			 Thread.sleep(2000);
			 //Create WebElement for Admin
			 WebElement objAdmin=driver.findElement(By.xpath("//span[text()='Admin']"));
			 Act.moveToElement(objAdmin).build().perform();
			 Thread.sleep(2000);
			 List<WebElement>objlist=driver.findElements(By.xpath("//html/body/div[4]/ul/li[1]/a"));
			 for (int i = 0; i < objlist.size(); i++)
			 {
			 String strtext=objlist.get(i).getText();
			 System.out.println(strtext);
			 if(objlist.get(i).isDisplayed())
			 {
			  System.out.println("Admin Links are "+strtext+ " Displayed");
			 }
			 
			 Thread.sleep(2000);
			 //Focus on Job
			 //Create WebLement for job
			 WebElement objJob=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[2]/a/span"));
			 //Mouse over on Job
			 Act.moveToElement(objJob).build().perform();
			 Thread.sleep(3000);
			 
			 List<WebElement>objlist1=driver.findElements(By.xpath(".//*[@id='admin']/ul/li[2]/a/span"));
			 for (int j = 0; j < objlist1.size(); j++) {
			  
			  String strtext1=objlist1.get(j).getText();
			  System.out.println(strtext1);
			 if(objlist1.get(j).isDisplayed())
			 {
			  System.out.println("JobLinks are" +strtext1+"displayed");
			 }
			  Thread.sleep(3000);
			 //create webElements for job specification
			  WebElement objJobSpecification=driver.findElement(By.linkText("Job Specifications"));
			  //Mouse over on job specification
			  Act.moveToElement(objJobSpecification).build().perform();
			  //click on job specification
			  driver.findElement(By.linkText("Job Specifications")).click();
			  //wait for frame and switch to it
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
			  if(driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Job : Job Specifications"))
			{
			 System.out.println("Job : Job Specifications is displayed");
			}
			 Thread.sleep(2000);
			 //Verify add,delete and search
			 WebElement objAdd=driver.findElement(By.xpath("//input[@value='Add']"));
			 WebElement objdelete=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
			 WebElement objSearch=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/input[2]"));
			 if(objAdd.isDisplayed() && objdelete.isDisplayed() && objSearch.isDisplayed())
			 {
			  System.out.println("Add,Delete and Search Buttons are Displayed");
			 }
			 
			 
			 //click on add
			 objAdd.click();
			 Thread.sleep(2000);
			 if(driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/div/h2")).getText().equals("Job : Job Specifications"))
			 {
			  System.out.println("Job : Job Specifications form is Displayed");
			 }
			  //create webelemets for Name, Description and Duties 
			 WebElement objName=driver.findElement(By.name("txtFieldName"));
			 WebElement objDescription=driver.findElement(By.name("txtDesc"));
			 WebElement objDuties=driver.findElement(By.name("txtDuties"));
			 if(objName.isDisplayed() && objDescription.isDisplayed() && objDuties.isDisplayed())
			 {
			  System.out.println("Name,Description and Duty Fields are Displayed");
			 }
			  
			  //Create WebElements for save
			  WebElement objSave=driver.findElement(By.xpath(".//*[@id='editBtn']"));
			  
			  //Keep all fields as blank and click on save
			  
			  objSave.click();
			 
			  //wait for Alert
			  Alert A=wait.until(ExpectedConditions.alertIsPresent());
			  if(A.getText().equals("Please correct the following\n\n	- Please specify Job Specification name\n"))
			  {
			   System.out.println("Please specify Job Specification name\n");
			   A.accept();
			   objName.sendKeys("Test Architect1");
			  }
			  
driver.findElement(By.xpath(".//*[@id='editBtn']")).click();
			  Thread.sleep(2000);
			  
			  String strAdd=driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
			  if(strAdd.equals("Successfully Updated"))
			  {
			   System.out.println("JobSpecification Successfully Added");
			  }
			  
			  //Verify Newly added Job Name in Job Specifications
			  
			  int rc1=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
			  for (int k = 0; k < rc1; k++)
			  
			  {String n=driver.findElement(By.xpath("html/body/div/div[2]/form/table/tbody/tr[7]/td[3]/a")).getText();
			  
			  if(n.equals("Test Architect1"))
			  {
			   System.out.println("Test Architect displayed in Job Specifications");
			   break;
			  }
			   
			  
			  
			  }
			  
			 }
			  
			  }
			  
			  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
