
 package mouseKeyboardClearActionsDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MousePIMQAHRM {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
FirefoxDriver Brow=new FirefoxDriver();
Brow.get("http://classroom:90/qahrm");
Brow.manage().window().maximize();
Thread.sleep(2000);
Brow.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
Brow.findElement(By.name("txtPassword")).sendKeys("user1");
Brow.findElement(By.name("Submit")).click();
Thread.sleep(4000);
//........................
//create object for action class
Actions A=new Actions(Brow);
//Move to PIM/Mouse over PIM
WebElement PIM=Brow.findElement(By.id("pim"));
//Mouse over on PIM
A.moveToElement(PIM).perform();
Thread.sleep(4000);
Brow.findElement(By.linkText("Add Employee")).click();
Thread.sleep(5000);
Brow.findElement(By.linkText("Logout")).click();
Thread.sleep(4000);
Brow.quit();
Brow.close();







	}

}
