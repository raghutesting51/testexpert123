package raghu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frontaccounting {

	

	

	public static void main(String[] args) throws Exception 
	{
	
	System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
	ChromeDriver Driver=new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.get("http://apps.qaplanet.in/frontaccounting/");
	Thread.sleep(4000);
	if(Driver.getTitle().equals("FrontAccounting 2.3.20 - Login"))
	{
		System.out.println("Home Page is Displayed");
		
	}
	else
	{
		System.out.println("Home Page failed to Display");
		return;
		
	}
	//create WebElements for user name,password,company,login
	WebElement objUserName=Driver.findElement(By.name("user_name_entry_field"));
	WebElement objpassword=Driver.findElement(By.name("password"));
	WebElement objcompany=Driver.findElement(By.name("company_login_name"));
	WebElement objlogin=Driver.findElement(By.name("SubmitUser"));
	if (objUserName.isDisplayed())
	{
	System.out.println("user name displayed");
	
}
		if (objpassword.isDisplayed())
		{
			System.out.println("password displayed");
		}
			if(objcompany.isDisplayed())
			{
				System.out.println("company is displayed");
				
			}
		if (objlogin.isDisplayed())
		{
			System.out.println("login is displayed");
		}
 String  strUserName = "demo";
 String	strpassword = "guest";
	
	//................................
	//login to front accounting
	objUserName.clear();
	objUserName.sendKeys(strUserName);
	objpassword.clear();
	objpassword.sendKeys(strpassword);
	objcompany.isSelected();
	objlogin.click();
	Thread.sleep(2000);
	//Verify Front Accounting Main Menu
	if(Driver.getTitle().equals("Main Menu"))
	{
		System.out.println("Main Menu Page Displayed");
		
	}
	else
	{
		System.out.println("Main Menu Page Failed to Display");
		return;
	}
	// Create webElements for Sales,Purchases,Items and Inventory,Manufacturing
	WebElement objSales=Driver.findElement(By.linkText("Sales"));
	WebElement objPurchases=Driver.findElement(By.linkText("Purchases"));
	WebElement objItemsandInventory=Driver.findElement(By.linkText("Items and Inventory"));
	WebElement objManufacturing=Driver.findElement(By.linkText("Manufacturing"));
	// Verify Sales,Purchases,Items and Inventory,Manufacturing
	if(objSales.isDisplayed()&&objPurchases.isDisplayed()&&objItemsandInventory.isDisplayed()&&objManufacturing.isDisplayed());
	{
		System.out.println("Sales,Purchases,Items and Inventory,Manufacturing links are Displayed");
		
	}
	
	//Create WebElement for Logout
	WebElement objLogout=Driver.findElement(By.linkText("Logout"));
	
	if(objLogout.isDisplayed());
	{
		System.out.println("Logout page is Displayed");
		
	}
	//Click on Logout
	objLogout.click();
	Thread.sleep(2000);
	
	
	//Create WebElement for Click here to Login Again
	WebElement objClickheretoLoginAgain=Driver.findElement(By.linkText("Click here to Login Again."));
	objClickheretoLoginAgain.click();
	if(Driver.getTitle().equals("FrontAccounting 2.3.20 - Login"))
	{
		System.out.println("Home Page is Displayed");
		
	}
	else
	{
		System.out.println("Home Page failed to Display");
		return;
	}
		Driver.close();
		Driver.quit();
			
}
}
