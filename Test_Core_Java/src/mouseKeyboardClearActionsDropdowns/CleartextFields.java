package mouseKeyboardClearActionsDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CleartextFields {

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.firefox.marionette", "F:\\D-Drive\\FromC\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		FirefoxDriver Brow=new FirefoxDriver();
		Brow.get("http://apps.qaplanet.in/qahrm/login.php");
		Brow.manage().window().maximize();
		Thread.sleep(2000);
		WebElement objUN=Brow.findElement(By.name("txtUserName"));
		objUN.sendKeys("admin");
		objUN.click();
		objUN.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		Thread.sleep(3000);
		objUN.sendKeys(Keys.DELETE);
		Thread.sleep(4000);
		objUN.sendKeys("QA Planet");
		Brow.close();
		Brow.quit();
		
		
		
		
		

	

		
	}

}
