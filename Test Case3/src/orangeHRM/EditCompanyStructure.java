package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCompanyStructure {

	public static void main(String[] args)throws Exception {
	
	    {
	        System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
	        ChromeDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        WebDriverWait wait=new WebDriverWait(driver,60);
	        Actions Act=new Actions(driver);
	        driver.get("http://apps.qaplanet.in/qahrm/login.php");
	        if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
	        {
	            System.out.println("HomePage Displayed");
	        }
	        else
	        {
	            System.out.println("HomePage Failed to Display");
	            return;
	        }
	       
	    //create WebElements for username,password,login and clear
	        WebElement objUsername=driver.findElement(By.name("txtUserName"));
	        WebElement objPassword=driver.findElement(By.name("txtPassword"));
	        WebElement objlogin=driver.findElement(By.name("Submit"));
	        WebElement objclear=driver.findElement(By.name("clear"));
	       
	    //verify username,password,login and clear
	        if(objUsername.isDisplayed() && objPassword.isDisplayed())
	        {
	            System.out.println("username and password are displayed");
	        }
	           
	            if(objlogin.isDisplayed() && objclear.isDisplayed())
	            {
	                System.out.println("Login and Clear Button are displayed");
	            }
	           
	            Thread.sleep(2000);
	           
	    //Login to Orange HRM
	            objUsername.sendKeys("qaplanet1");
	            objPassword.sendKeys("user1");
	            objlogin.click();       
	        if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
	        {
	            System.out.println("login successfull");
	        }
	        else
	        {
	            System.out.println("failed to login");
	            return;
	        }
	        //verify welcome text
	        String strweltext=driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
	        if(strweltext.equals("Welcome qaplanet1"))
	        {
	            System.out.println("Welcome qaplanet1 is displayed");
	        }
	        Thread.sleep(2000);
	       
	        //create WebElement for change password and logout
	        WebElement objChangePassword=driver.findElement(By.linkText("Change Password"));
	        WebElement objLogout=driver.findElement(By.linkText("Logout"));
	       
	        //Verify change passowrd and logout
	       
	        if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
	        {
	            System.out.println("Change Password and Logout Are Displayed");
	        }
	    Thread.sleep(2000);
	//Create WebElement for Admin
	    WebElement objAdmin=driver.findElement(By.xpath("//span[text()='Admin']"));
	// Mouse over on Admin/Focus on Admin
	    Act.moveToElement(objAdmin).build().perform();
	//Verify Elements under Admin
	    java.util.List<WebElement>objlist=driver.findElements(By.xpath("//span[text()='Admin']"));
	    for (int i = 0; i < objlist.size(); i++)
	   
	{String strtext=objlist.get(i).getText();
	System.out.println("strtext is Displayed");
	    if(objlist.get(i).isDisplayed())
	    {
	        System.out.println("Admin linlks are"+strtext+"displayed");
	    }
	        Thread.sleep(2000);
	       
	//Cretate WebElements for Company info
	    WebElement objCompanyinfo=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[1]/a/span"));
	//Focus on Company Info
	    Act.moveToElement(objCompanyinfo).build().perform();
	//Verify Elements under Company info
	    java.util.List<WebElement>objlist1=driver.findElements(By.xpath(".//*[@id='admin']/ul/li[1]/a/span"));
	    for (int j = 0; j < objlist1.size(); j++)
	    {String strtext1=objlist1.get(j).getText();
	    System.out.println("company info links are displayed");
	        if(objlist1.get(j).isDisplayed())
	        {
	            System.out.println("company info links are"+strtext1+"displayed");
	        }
	    Thread.sleep(2000);   
	//Create WebElements for company structure
	    WebElement objcompanystructure=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[1]/ul/li[3]/a/span"));
	//click on company structure
	  Act.moveToElement(objcompanystructure).build().perform();
	  objcompanystructure.click();
	  //verify company info:company structure
	  if(driver.findElement(By.xpath("//html/body/div[1]/h2")).getText().equals("Company Info : Company Structure"))
	  {
		System.out.println("Company Info : Company Structure is displayed");
	  }
	  Thread.sleep(2000);
	  
	  //Select company info
	  driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr[55]/td[1]/a")).click();
	  //wait for frame and switch to it
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
	  //Verify the Edit Company Frame
	  if(driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/div/h3")).getText().equals("Edit Boeing Department"))
	  {
		  System.out.println("Edit Boeing Department Frame is Displayed");
	  }
	 
	  Thread.sleep(2000);
	//create WebElement for Department id,name,type,location and description 
	  WebElement objDepartment=driver.findElement(By.id("txtDeptId"));
	  WebElement objName=driver.findElement(By.id("txtTitle"));
	  WebElement objType=driver.findElement(By.id("cmbType"));
	  WebElement objLocation=driver.findElement(By.id("cmbLocation"));
	  WebElement objDescription=driver.findElement(By.id("txtDesc"));
	 
	  //Edit Company Structure
	  
	  Select Type=new Select(objType);
	  Type.selectByVisibleText("Team");
	  
	  //click on save
	  
	  WebElement objSave=driver.findElement(By.xpath(".//*[@value='Save']"));
	  objSave.click();
	  
	  
	  
	 

	}

	}
	    }
	}
}
