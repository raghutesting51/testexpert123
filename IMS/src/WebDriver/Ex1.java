package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex1 {
	
		public static void main(String[] args)throws Exception
		{
			FirefoxDriver Driver=new FirefoxDriver();
			Driver.get("http://apps.qaplanet.in/qahrm/login.php");;
			Thread.sleep(2000);
			Driver.findElement(By.name("txtpassword")).clear();
			Driver.findElement(By.name("txtUsername")).sendKeys("qaplanet1");
			Driver.findElement(By.name("txtpassword")).clear();
			Driver.findElement(By.name("txtPassworde")).clear();
			Driver.findElement(By.name("txtPassword")).sendKeys("user1");
			Driver.findElement(By.name("submit")).click();
			Thread.sleep(2000);
			Driver.findElement(By.linkText("layout")).click();
			Thread.sleep(3000);
			Driver.close();
			Driver.quit();
		}
	}
	
	
	


