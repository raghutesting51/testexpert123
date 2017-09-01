package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedAlerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//maximize browser
		Driver.manage().window().maximize();
		//....................
		//Explicit wait object
		WebDriverWait Wait=new WebDriverWait(Driver,60);
		//..............................
		//Open application
		Driver.get("http://classroom:90/webapp/Ex3.html");
		//wait for submit
		WebElement objSubmit=Wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		//verify submit button
		if(objSubmit.isDisplayed())
		{
			System.out.println("Submit Button is Displayed");
		}
		//choose answer
		Driver.findElement(By.xpath("html/body/input[4]"));
		//click on submit
		objSubmit.click();
		//wait for alert
		Alert A=Wait.until(ExpectedConditions.alertIsPresent());
		//verify are you sure you want to submit this answer?message
		if(A.getText().equals("Are you sure you want to submit this answer?"))
		{
			System.out.println("Confirmation Displayed");
			A.accept();
			//wait for submitted alert
			Alert A1=Wait.until(ExpectedConditions.alertIsPresent());
			//verify submitted alert
			if(A1.getText().equals("submitted"))
			{
				System.out.println("submitted displayed");
				A1.accept();
			}
			Driver.close();
			Driver.quit();
		}
		
		

	}

}
