package raghu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class Hrm {

	public static void main(String[] args) throws Exception {
		
		//System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");

		ChromeDriver Driver=new ChromeDriver();
		
		Driver.manage().window().maximize();
	
	Driver.get ("http://apps.qaplanet.in/qahrm/login.php");
	Thread.sleep(2000);
	Driver.findElement (By.name("txtUserName")).clear();
	Driver.findElement (By.name("txtUserName")).sendKeys ("qaplanet1");
	Driver.findElement (By.name("txtPassword")).clear();
	Driver.findElement (By.name("txtPassword")).sendKeys("user1");
	Driver.findElement (By.name("Submit")).click();
	Thread.sleep(2000);
	Driver.findElement(By.linkText("Logout")).click();
	//Thread.sleep(2000);
	Driver.close();
	//driver.quit();
	
	
	


		
	}

}
