package orangeHRM;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddLocation {

	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
ChromeDriver Driver=new ChromeDriver();
Driver.manage().window().maximize();
WebDriverWait wait=new WebDriverWait(Driver,60);
Actions Act=new Actions(Driver);
Driver.get("http://apps.qaplanet.in/qahrm/login.php");
if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
{
	System.out.println("OrangeHRM - New Level of HR Management is Displayed");
}
else
{
	System.out.println("HomePage Failed To Display");
	return;
}
//Create WebElement for Login Name,Password,Login and Clear
WebElement objLoginName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
WebElement objPassword=Driver.findElement(By.name("txtPassword"));
WebElement objLogin=Driver.findElement(By.name("Submit"));
WebElement objClear=Driver.findElement(By.name("clear"));
//Verify LoginName,Password,Login&Clear
if(objLoginName.isDisplayed())
{
	System.out.println("LoginName Displayed");
}
if(objPassword.isDisplayed())
{
	System.out.println("Password Displayed");
}
if(objLogin.isDisplayed() && objClear.isDisplayed())
{
	System.out.println("Login and Clear Button are Displayed");
}

String strLoginName="qaplanet1";
String strPassowrd="user1";

//Enter Valid LoginName and Password
objLoginName.sendKeys(strLoginName);
objPassword.sendKeys(strPassowrd);
objLogin.click();
if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
{
	System.out.println("OrangeHRM Page Is Displayed");
}
else
{
	System.out.println("Failed to Login");
	return;
}
//Get Welcome Text
String StrWelText=Driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
//Verify Welcome Text
if(StrWelText.equals("Welcome" +strLoginName))
{
	System.out.println("Welcome" +strLoginName +"Displayed");
}

//Create WebElements for Change Password and Logout
WebElement objChangePassword=Driver.findElement(By.linkText("Change Password"));
WebElement objLogout=Driver.findElement(By.linkText("Logout"));
//Verify ChangePassowrd & Logout
if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
{
	System.out.println("Change Password and Logout Are Displayed");
}
//Focus on Admin
//Create WebElement for Admin
WebElement objAdmin=Driver.findElement(By.id("admin"));
//Mouse over on Admin
Act.moveToElement(objAdmin).perform();
//Verify Company,Job,Qualification,Skills
ArrayList<String>AL=new ArrayList<String>();
String strCompany="Company Info";
String strJob="Job";
String strQualification="Qualification";
String strSkills="Skills";
AL.add("strCompany");
AL.add("strJob");
AL.add("strQualification");
AL.add("strSkills");
Iterator<String>ITRT=AL.iterator();
while(ITRT.hasNext())
{
String IT=ITRT.next();
System.out.println(IT);
}
Thread.sleep(2000);
//Focus on Company info
//Create WebElement for Company Info
WebElement objCompanyInfo=Driver.findElement(By.xpath(".//*[@id='admin']/ul/li[1]/a/span"));
//Mouse over on objCompanyInfo
Act.moveToElement(objCompanyInfo).perform();
//Verify General,Locations,Company Structure and Company Property
String strGeneral="General";
String strLocations="Locations";
String strCompanyStructure="Company Structure";
String strCompanyProperty="Company Property";
AL.add(strGeneral);
AL.add(strLocations);
AL.add(strCompanyStructure);
AL.add(strCompanyProperty);
Iterator<String>ITRT1=AL.iterator();
while(ITRT1.hasNext())
{   
	String IT1=ITRT1.next();
	System.out.println(IT1);
}
Thread.sleep(2000);
//Create WebElement for Locations
WebElement objLocations=Driver.findElement(By.linkText("Locations"));
//Mouse over on Locations
Act.moveToElement(objLocations).perform();
//Click on Locations
Driver.findElement(By.linkText("Locations")).click();
//Wait for Frame And Switch To it
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[1]/h2")).getText().equals("Company Info : Locations"))
{
	System.out.println("Company Info : Locations is Displayed");
}
Thread.sleep(2000);
//Create WebElements for SearchBy,SearchEditBox,SearchButton,Reset,Add and Delete buttons
WebElement objSearchBy=Driver.findElement(By.id("loc_code"));
WebElement objSearchEditBox=Driver.findElement(By.id("loc_name"));
WebElement objSearchButton=Driver.findElement(By.className("plainbtn"));
WebElement objReset=Driver.findElement(By.xpath("html/body/div/div[2]/form/div[2]/input[3]"));
WebElement objAdd=Driver.findElement(By.xpath("html/body/div/div[2]/form/div[3]/div[1]/input[1]"));
WebElement objDelete=Driver.findElement(By.xpath("html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
if(objSearchBy.isDisplayed())
{
	System.out.println("SearchBy Dispalyed");
}
if(objSearchEditBox.isDisplayed())
{
	System.out.println("SearchEditBox Displayed");
}
if(objSearchButton.isDisplayed())
{
	System.out.println("SearchButton Displayed");
}
if(objReset.isDisplayed())
{
	System.out.println("Reset Displayed");
}
if(objAdd.isDisplayed())
{
	System.out.println("Add Displayed");
}
if(objDelete.isDisplayed())
{
	System.out.println("Delete Displayed");
}
Thread.sleep(2000);
//Mouse over on add
Act.moveToElement(objAdd).perform();
//Click on Add
objAdd.click();
Thread.sleep(2000);
//Wait for Frame and Switch to it
//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
if(Driver.findElement(By.xpath("//html/body/div/div[3]/div[2]/div/h2")).getText().equals("Company Info : Locations"))
{
	System.out.println("Company Info : Locations is Displayed");
}
//Create WebElements for Name,Country,Address,ZIP Code
WebElement objName=Driver.findElement(By.name("txtLocDescription"));
WebElement objCountry=Driver.findElement(By.id("cmbCountry"));
WebElement objAddress=Driver.findElement(By.id("txtAddress"));
WebElement objZIPCode=Driver.findElement(By.id("txtZIP"));
if(objName.isDisplayed() && objCountry.isDisplayed())
{
	System.out.println("Name and Country are Displayed");
}
if(objAddress.isDisplayed() && objZIPCode.isDisplayed())
{
	System.out.println("Address and ZIP code are Displayed");
}

//Keep all Fields as Blank and click on save
//Create WebElements for save
WebElement objSave=Driver.findElement(By.id("editBtn"));
objSave.click();
//wait for Alert
Alert A=wait.until(ExpectedConditions.alertIsPresent());
//Verify Location Name,Country,Address and Zip Code should be Specified
if(A.getText().equals("Please correct the following\n\n	- Location Name has to be specified\n	- Country should be selected!\n	- Address should be specified\n	- Zip Code should be specified\n"))
{
	System.out.println("Loction Name,Country,Address and ZIP code Should Be Specified");
	A.accept();
	objName.sendKeys("Hyd");
}
//Click On Save
objSave.click();

//Wait for Alert
Alert A1=wait.until(ExpectedConditions.alertIsPresent());
//Verify country,address and Zipcode
if(A1.getText().equals("Please correct the following\n\n	- Country should be selected!\n	- Address should be specified\n	- Zip Code should be specified\n"));
{
	System.out.println("Country,Address and ZIP code Should be Specified");
	A1.accept();
	Select scl=new Select(objCountry);
	scl.selectByVisibleText("India");
}

//click on save
objSave.click();
//A1.accept();
//wait for Alert
Alert A2=wait.until(ExpectedConditions.alertIsPresent());
//Verify Address and ZipCode
if(A2.getText().equals("Please correct the following\n\n	- Address should be specified\n	- Zip Code should be specified\n"))
{
	System.out.println("Address and ZIP code Should be Specified");
	A2.accept();
	Driver.findElement(By.id("txtAddress")).sendKeys("Mytrivanam,Ameerpet,");
}
//Click on save
objSave.click();
//A2.accept();
//wait for Alert
Alert A3=wait.until(ExpectedConditions.alertIsPresent());
//Verify Zip code
if(A3.getText().equals("Please correct the following\n\n	- Zip Code should be specified\n"))
{
	System.out.println("Zipcode Should Be Specified");
	A3.accept();
	Driver.findElement(By.id("txtZIP")).sendKeys("456565");
}
//Click on save
objSave.click();
//A3.accept();
Thread.sleep(2000);
//Driver.switchTo().defaultContent();
//Wait for Frame and Switch to it
//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));

if(Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[1]/h2")).getText().equals("Company Info : Locations"))
{
	System.out.println("Location info displayed on Location Table");
}
//Get location Code
//Driver.findElement(By.xpath("//html/body/div/div[2]/form/table/tbody/tr[32]/td[1]/input")).click();
//Verify Location Info Must be displayed in Location Table
/*Driver.findElement(By.xpath("//html/body/div/div[2]/form/table/tbody/tr[32]/td[3]/a")).getText().equals("Company Info : Locations");
{
	System.out.println("Location info displayed on Location Table");
}*/
	Thread.sleep(2000);
int rc=Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
System.out.println(rc);
for (int i = rc; i <=rc; i++) {
	String n=Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();


if(n.equals("Hyd"))
{
	System.out.println("Hyd is displayed");
}
Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();

}

//--------------------------------------------------------------------------------------------------------------------

WebElement objEdit=Driver.findElement(By.id("editBtn"));
objEdit.click();
Thread.sleep(2000);
//Mouse over on objName
Driver.findElement(By.name("txtLocDescription")).click();
Driver.findElement(By.name("txtLocDescription")).clear();
Driver.findElement(By.name("txtLocDescription")).sendKeys("HYDE");
//CLICK ON SAVE
Driver.findElement(By.id("editBtn")).click();
Thread.sleep(2000);
String strEdit=Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
if(strEdit.equals("Successfully Updated"))
{
	System.out.println("Location Edited Successfully");
}

Thread.sleep(2000);
int rc1=Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();

for (int j = rc1; j <rc1; j++) {
	String n=Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();


if(n.equals("HYDE"))
{
	System.out.println("HYDE is displayed");
}

//Verify Delete
Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click();

}

Driver.findElement(By.xpath("//input[@value='Delete']")).click();
Driver.switchTo().alert().accept();
String strDel=Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[2]/span")).getText();
if(strDel.equals("Successfully Deleted"))
{
	System.out.println("Location Successfully Deleted");
}























	}
	

}
