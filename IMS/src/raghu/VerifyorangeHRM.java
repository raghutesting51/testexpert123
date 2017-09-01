package raghu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyorangeHRM {

	public static void main(String[] args) throws Exception
	{ 
	System.setProperty ("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
	ChromeDriver Driver= new ChromeDriver();
	
	Driver.manage().window().maximize();
	Driver.get("http://apps.qaplanet.in/qahrm/login.php");
	Thread.sleep(2000);
	if(Driver.getTitle().equals ("OrangeHRM - New Level of HR Management"))
	{ 
	System.out.println("Home page dsplayed");

	}
	
	else
		
	{
		System.out.println("Failed to open home page");
		return;
	}
	//create web elements for  user name,password,login and clear
	WebElement objUserName=Driver.findElement(By.name("txtUserName"));
	WebElement objPassword=Driver.findElement(By.name("txtPassword"));
	WebElement objLogin=Driver.findElement(By.name("Submit"));
	WebElement objClear=Driver.findElement(By.name("clear"));
	//.......................................................

	if(objUserName.isDisplayed())
	{
		System.out.println("User Name displayed");
	}
	if(objPassword.isDisplayed())
	{
		System.out.println("Password is displayed");
		
	}
	if(objLogin.isDisplayed()&& objClear.isDisplayed())
	{
		System.out.println("Login and clear buttons are displayed");
	}
	
	
	//.................................................................
	String strUserName=("qaplanet1");
    String strPassword=("user1");
      //.........................................................
    //Login to OrangeHRM
    objUserName.clear();
    objUserName.sendKeys(strUserName);
    objPassword.clear();
    objPassword.sendKeys(strPassword);
    objLogin.click();
    // wait for 2 seconds
    Thread.sleep(2000);
    //Verify OrangeHRM
    if(Driver.getTitle().equals("OrangeHRM"))
    {
    	System.out.println("OrangeHRM is displayed");
    }
    else
    {
    	System.out.println("Home page failed to display");
    	return;
    }
//............................................................
    //Get welcome Text
    String strwelText= Driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
    //verify welcome Text
    if(strwelText.equals("Welcome "+strUserName))
    {
    	System.out.println("welcome"+strUserName+"Dispalyed");
    }
	//Create webElements for Change Password and Logout
    WebElement objChangePassword=Driver.findElement(By.linkText("Change Password"));
    WebElement objLogout=Driver.findElement(By.linkText("Logout"));
    //Verify ChangePassword and Logout
    if(objChangePassword.isDisplayed()&&objLogout.isDisplayed())
    {
    	System.out.println("ChangePassword and Logout are displayed");
    	
    }
    //...................................
    //Click on Logout
    objLogout.click();
    //wait 2 
    Thread.sleep(2000);
    //Verify Home Page
    if (Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
    {
    	System.out.println("Signoff Successfull and Homepage displayed");
    	
    }
    else
    {
    	System.out.println("Failed to Signoff");
    	
    }
    
    //....................
    Driver.close();
    Driver.quit();
    
}

}