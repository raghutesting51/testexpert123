package orangeHRM;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddJobtiitle {

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


	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
	WebElement objAdmin=Driver.findElement(By.xpath("//span[text()='Admin']"));
//	Mouse over on Admin
	Act.moveToElement(objAdmin).build().perform();
	
	
	
	List<WebElement>objlist=Driver.findElements(By.xpath("//li[@id='admin']/ul/li/a/span"));
	for (int i = 0; i < objlist.size(); i++) 
	{
		String strtext=objlist.get(i).getText();
		System.out.println(strtext);
		if (objlist.get(i).isDisplayed())
		{
			System.out.println("Admin links are "+strtext+" displayed");
		}
		
	}

////	//Verify Company,Job,Qualification, Skills ..etc
////	ArrayList<String>AL=new ArrayList<String>();
////	String strCompany="Company Info";
////	String strJob="Job";
////	String strQualification="Qualification";
////	String strSkills="Skills";
////	AL.add("strCompany");
////	AL.add("strJob");
////	AL.add("strQualification");
////	AL.add("strSkills");
////	Iterator<String>ITRT=AL.iterator();
////	while(ITRT.hasNext())
////	{
////		String IT= ITRT.next();
////        System.out.println(IT);
////	}
Thread.sleep(2000);
////Focus On JOb
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Job']")));

WebElement objJobs=Driver.findElement(By.xpath("//span[text()='Job']"));
//Mouse over on jobs
	Act.moveToElement(objJobs).build().perform();
List<WebElement>objlist1=Driver.findElements(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[2]/a/span"));
for (int j = 0; j < objlist1.size(); j++) 
{
String strtext=objlist1.get(j).getText();
System.out.println(strtext);
if(objlist1.get(j).isDisplayed())
{
	System.out.println("JobLinks are"+strtext+"displayed");
}




	//objJobs.click();
//	//Verify Job Title,Job specification, Pay Grade ..etc
//	String strJobTitle="Job Titles";
//	String strJobspecification="Job Specifications";
//	String strPayGrade="Pay Grades";
//	AL.add(strJobTitle);
//	AL.add(strJobspecification);
//	AL.add(strPayGrade);
//	Iterator<String>ITRT1=AL.iterator();
//	while(ITRT1.hasNext())
//	{
//		String IT1= ITRT1.next();
//		System.out.println(IT1);
//				
//	}
	
	
	
	
Thread.sleep(2000);
//Create WebElement for JobTitles
		WebElement objJobTitle=Driver.findElement(By.linkText("Job Titles"));
		//Mouse over on JobTittle
		Act.moveToElement(objJobTitle).perform();
		//click on JobTittle
		Driver.findElement(By.linkText("Job Titles")).click();
		//wait for Frame and Switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		if(Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[1]/h2")).getText().equals("Job : Job Title"))
				{
			System.out.println("Job : Job Title is Displayed");
				}
		
		
		//Verify Add,Delete,Search Fields
		WebElement objAdd=Driver.findElement(By.xpath("//input[@value='Add']"));
		WebElement objDelete=Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
		WebElement objSearch=Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/input[2]"));
		if(objAdd.isDisplayed() && objDelete.isDisplayed() && objSearch.isDisplayed())
		{
			System.out.println("Add,Delete and Search Buttons are Displayed");
		}
		
		//click on add
		
		objAdd.click();
		//wait for frame and switch to it
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		
		Thread.sleep(3000);
		if(Driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/div/h2")).getText().equals("Job : Job Title"))
				{
			System.out.println("JobTitle Form is Displayed");
				}
		WebElement objJobTiTleName=Driver.findElement(By.name("txtJobTitleName"));
		WebElement objJobDescription=Driver.findElement(By.name("txtJobTitleDesc"));
		WebElement objSave=Driver.findElement(By.xpath("//input[@value='Save']"));
		if(objJobTiTleName.isDisplayed() && objJobDescription.isDisplayed())
		{
			System.out.println("JobTiTleName and JobDescription are Displayed");
		}
		
		//Keep all Fields as blank and click on save
		objSave.click();
		Thread.sleep(3000);
		//wait for Alert
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		if(A.getText().equals("Job Title Name should be specified"))
		{
			System.out.println("Job Title Name should be specified");
			A.accept();
			objJobTiTleName.sendKeys("Test Engineer 2");
		}
		
		objSave.click();
		Thread.sleep(2000);
		
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		if(A1.getText().equals("Job Description should be specified"))
		{
			System.out.println("Job Description should be specified");
			A1.accept();
			objJobDescription.sendKeys("Test Automation");
		}
		
		objSave.click();
		Thread.sleep(2000);
		
		//Verify Employee status field is Displayed
		 
		WebElement objEmployeeStatus=Driver.findElement(By.id("cmbAssEmploymentStatus"));
		if(objEmployeeStatus.getText().equals("Terminated"))
		{

			System.out.println("Employees status fields are displayed");
		
		}
		
		
		//Edit Employee Status and other info
		 WebElement objEdit=Driver.findElement(By.id("editBtn"));
		objEdit.click();
		Thread.sleep(3000);
		WebElement objJobSpecification=Driver.findElement(By.id("cmbJobSpecId"));
		Select jobSpec=new Select(objJobSpecification);
		jobSpec.selectByIndex(4);
		Thread.sleep(4000);
		Driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/form/div[4]/input[1]")).click();
		
		
		
		
		
		
		
        Thread.sleep(4000);
       
        String strEdit=Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
        		if(strEdit.equals("Successfully Updated"))
        		{
        			System.out.println("JobTitle Successfully Updated");
        		}
		
		//Verify newly added Job title in job table
        		

        		int rc1=Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();

        		for (int i = 1; i <rc1; i++) {
        			String n=Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();


        		if(n.equals("Test Engineer 2"))
        		{
        			System.out.println("Test Engineer 2 is displayed");
        			break;
        		}

        				    		}

}

	}
	

}
	



	


