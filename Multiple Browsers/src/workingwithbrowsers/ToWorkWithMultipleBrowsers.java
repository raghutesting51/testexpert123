package workingwithbrowsers;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToWorkWithMultipleBrowsers {

	public static void main(String[] args)throws Exception
	
	{System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		Driver.manage().window().maximize();
		Driver.get("http://qaplanet.in/");
		Thread.sleep(2000);
		//click on linked icon
		Driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[4]/a/img")).click();
		Thread.sleep(2000);
		Set<String>IDS=Driver.getWindowHandles();
		//Way1
		for(String ID :IDS)
		{
			System.out.println(ID);
		}
		
//way2
		Iterator<String> ITR=IDS.iterator();
		String First_ID=ITR.next();
		String Second_ID=ITR.next();
		//Switch to Second Browser
		Driver.switchTo().window(Second_ID);
		Thread.sleep(4000);
		//click on sign in
		Driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		//Enter Email
		Driver.findElement(By.name("session_key")).sendKeys("qaplanet@gmail.com");
Thread.sleep(2000);
//close browser
Driver.close();
Thread.sleep(2000);
//.......................................................
//Switch to second browser
Driver.switchTo().window(First_ID);
Thread.sleep(2000);
//click on Justdial icon
Driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[5]/a/img")).click();
Thread.sleep(3000);
Driver.close();
Driver.quit();
		
		
		
		
		
		
	}

}
