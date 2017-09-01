package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class verifyalert {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe" );
ChromeDriver Driver=new ChromeDriver();
//maximize window
Driver.manage().window().maximize();
//............................
//Explicit Wait Object
WebDriverWait wait=new WebDriverWait(Driver,60);
//..................................
//open application
Driver.get("http://classroom:90/webapp/AgeProb.html");
//wait for home page
boolean blnRes=wait.until(ExpectedConditions.titleIs("Age Problem"));
//verify Age Problem
if(blnRes)
{
	System.out.println("Age Probelm page is Displayed");
	
}

else
{
	System.out.println("Age Probelm page falied to Display");
}
//enter age
Driver.findElement(By.id("idAge")).sendKeys("10");
//click on submit
Driver.findElement(By.id("idSubGo")).click();
//wait for alert
wait.until(ExpectedConditions.alertIsPresent());
//switch to alert
Alert A=Driver.switchTo().alert();
//verify Alert message as kid
if(A.getText().equals("Kid"))
{
	System.out.println("kid Alert Displayed");
	A.accept();
}
Driver.close();
Driver.quit();


	






	}

}
