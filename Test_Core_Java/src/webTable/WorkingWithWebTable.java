package webTable;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithWebTable {

	

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\tet\\Selenium_Demp\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(Driver,70);
		Driver.get("http://classroom:90/webapp/AssertXpath.html");
		//wait for AssertXPath
	

		if(wait.until(ExpectedConditions.titleIs("AssertXPath")))
		{
			System.out.println("AssertXPath Displayed");
		}

		//Get row count
		int rc=Driver.findElements(By.xpath(".//*[@id='idCourse']/tbody/tr")).size();
		System.out.println(rc);
		//Get column count
		int colc=Driver.findElements(By.xpath(".//*[@id='idCourse']/tbody/tr[1]/td")).size();
		System.out.println(colc);
		//Get Cell count
		int cc=Driver.findElements(By.xpath(".//*[@id='idCourse']/tbody/tr/td")).size();
		System.out.println(cc);
		//Get cell data
		for(int i=1;i<=rc;i++)
		{
			for(int j=1;j<colc;j++);
		}
		Driver.close();
		
	}

}
