package mouseKeyboardClearActionsDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyCommands {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement objUn=Driver.findElement(By.name("txtUserName"));
		objUn.sendKeys("admin");
		objUn.click();
		objUn.sendKeys(Keys.chord(Keys.CONTROL,"G"));
		Thread.sleep(4000);
		objUn.sendKeys(Keys.DELETE);
		Thread.sleep(4000);
		objUn.sendKeys("qaplanet1");
		Thread.sleep(4000);
		Driver.close();
		//Driver.quit();
		
			

	}

}
