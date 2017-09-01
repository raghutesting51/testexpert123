package webTable;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InWebTableByUsingIteratorForLoop {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\tet\\Selenium_Demp\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(Driver,70);
		Driver.get("http://classroom:90/webapp/AssertXpath.html");
		//wait for AssertXPath
		if (wait.until(ExpectedConditions.titleIs("AssertXPath")))
		{
			System.out.println("AssertXPath is Displayed");
		}
List<WebElement>TDS=Driver.findElements(By.xpath(".//*[@id='idCourse']/tbody/tr/td"));
	
	//Get Cell Data
Iterator<WebElement>IT=TDS.iterator();
while(IT.hasNext())
{
	WebElement TD=IT.next();
	System.out.println(TD.getText());
}
//way2 using for each 
for(WebElement TD:TDS)
{
	System.out.println(TD.getText());
}
	//Way3
	}
	

}
