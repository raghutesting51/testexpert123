package raghu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class VerifyVtigerCRM {

	public static void main(String[] args) throws Exception
	{
		System.setProperty ("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver Driver= new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://classroom:8888/");
		Thread.sleep(2000);
		if(Driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Home page is Displayed");
		}
		else
		{
			System.out.println("Failed to display home page");
			return;
		}
	//create WebElements for user name,password and login
		WebElement objUserName=Driver.findElement (By.name("user_name"));
		WebElement objPassword=Driver.findElement(By.name("user_password"));
		WebElement objLogin=Driver.findElement(By.id("submitButton"));
		if (objUserName.isDisplayed())
		{
			System.out.println("User name is Displayed");
		}
		if (objPassword.isDisplayed())
		{
			System.out.println("Password is Displayed");
		}
		if (objLogin.isDisplayed())
		{
			System.out.println("Login is Displayed");
		}
		//.................................
		String strUserName=("qaplanet1");
		String strpassword=("user1");
		//...............................
		//Login to VtigerCRM
		objUserName.clear();
		objUserName.sendKeys(strUserName);
		objPassword.clear();
	    objPassword.sendKeys(strpassword);
	    objLogin.click();
	    Thread.sleep(2000);
	    // Verify VtigerCRM
	    if(Driver.getTitle().equals("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM"))
	    {
	    	System.out.println("Vtiger is Displayed");
	    }
	    else
	    {
	    	System.out.println("Home Page Failed to Display");
	    }
	    
		//......................................
/*	// Get Welcome Text
	String strwelText=Driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[1]/a/img")).getText();
	//Verify Welcome Text
			if(strwelText.equals("welcome "+strUserName))
			{
		System.out.println("welcome"+strUserName+"displayed");
			}*/
		//Create WebElements for home,calendar,leads,organization,contacts,opportunities,products
			WebElement objHome=Driver.findElement(By.linkText("Home"));
			WebElement objcalendar=Driver.findElement(By.linkText("Calendar"));
			WebElement objleads=Driver.findElement(By.linkText("Leads"));
			WebElement objorganization=Driver.findElement(By.linkText("Organizations"));
			WebElement objcontacts=Driver.findElement(By.linkText("Contacts"));
			WebElement objopportunities=Driver.findElement(By.linkText("Opportunities"));
			WebElement objproducts=Driver.findElement(By.linkText("Products"));
			//Verify home,calendar,leads,organization,contacts,opportunities,products
			if(objHome.isDisplayed()&&objcalendar.isDisplayed()&&objleads.isDisplayed()&&objorganization.isDisplayed()&&objcontacts.isDisplayed()&&objopportunities.isDisplayed()&&objproducts.isDisplayed());
			{
				System.out.println("home,calendar,leads,organization,contacts,opportunities and products are displayed");
			}

			
			Actions act=new Actions(Driver);
			WebElement u=Driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));
			act.moveToElement(u).perform();
			act.moveToElement(Driver.findElement(By.xpath(".//*[@id='ondemand_sub']/table/tbody/tr[2]/td/a"))).click().perform();
			//click on Sign out
			//objSignout.click();
			Thread.sleep(2000);
			if(Driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"));
			{
				System.out.println("Sign off Successfull and Home Page Displayed");
				
			}
			
			
		
			Driver.close();
		    Driver.quit();
			
			
	}
}
		

