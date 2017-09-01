package orangeHRM;
//import java.util.List;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;





public class AddEditDeleteCompanyStructure {

	public static void main(String[] args) throws Exception 
    {System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
        //WebDriver driver=new InternetExplorerDriver();
        //WebDriver driver=new EdgeDriver();
      //WebDriver driver =new FirefoxDriver();
		 ChromeDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        Actions ACT=new Actions(driver);
   driver.get("http://apps.qaplanet.in/qahrm/login.php");
    // driver.get(" http://classroom/orangehrm-2.6.1/login.php");
        wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
        
        //VERIFY HOME PAGE
        if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
        {
         System.out.println("OrangeHRM - New Level of HR Management PAGE IS DISPLAYED");
        }
        
        // CREATING OBJECTS NAMES
        WebElement OBJUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
        WebElement OBJPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
        WebElement OBJLOGIN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
        WebElement OBJCLEAR=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
        // VERIFYING USERNAME AND PASSWORDS
        if(OBJUN.isDisplayed() && OBJPWD.isDisplayed())
        {
         System.out.println("USERNAME & PASSWORD IS DISPLAYED");
         
        }
        if(OBJLOGIN.isDisplayed() && OBJCLEAR.isDisplayed())
        {
         System.out.println("LOGIN AND CLEAR DISPLAYED");
         
        }
       // String UN="admin";
     //  String PWD="admin";
    String UN="qaplanet1";
     String PWD="user1";
        OBJUN.clear();
        OBJUN.sendKeys(UN);
        OBJPWD.clear();
        OBJPWD.sendKeys(PWD);
        OBJLOGIN.click();
        //VERIFY ORANGE HRM PAGE TITLE
        if(driver.getTitle().equals("OrangeHRM"))
        {
         System.out.println("OrangeHRM IS DISPLAYED");
         
        }
        else
        {
         System.out.println("OrangeHRM NOT DISPLAYED");
         return;
        }
        //GET WELCOME TEXT
          String WELTXT=driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
          //VERIFY WELCOME TEXT
          if(WELTXT.equals("Welcome "+UN))
          {
           System.out.println("Welcome "+UN+"DISPLAYED");
          }
          else
          {
           System.out.println("WELCOME TEXT FAILED TO DISPLAY");
           return;
          }
          WebElement OBJCP=driver.findElement(By.linkText("Change Password"));
          WebElement OBJLOGOUT=driver.findElement(By.linkText("Logout"));
          
          //VERIFY CHANGE PASSWORD AND LOGOUT
          if(OBJCP.isDisplayed() && OBJLOGOUT.isDisplayed())
          {
           System.out.println("CHANGE PASSWORD AND LOGOUT");
          }
          else
          {
           System.out.println("CHANGE PASSWORD AND LOGOUT NOT DISPLAYED");
           return;
          }
          //WAY2
          String[] ARR=WELTXT.split(" ");
          if(ARR[1].equals(UN))
          {
           System.out.println("CHANGE PASSWORD AND LOGOUT");   
          }
          else
          {
           System.out.println("CHANGE PASSWORD AND LOGOUT NOT DISPLAYED");
           return;
          }

         driver.navigate().refresh();

         WebElement OBJADM=driver.findElement(By.id("admin"));
         
         if(OBJADM.isDisplayed())
         {
          System.out.println("Admin is displayed");
         }
         else
         {
          System.out.println("Admin is not Displayed");
          return;
         }
         
         // MOUSE OVER

         ACT.moveToElement(OBJADM).perform();

         // CREATE OBJECT FOR COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,

         WebElement OBJCOM=driver.findElement(By.linkText("Company Info"));
         WebElement OBJJOB=driver.findElement(By.linkText("Job"));
         WebElement OBJQAL=driver.findElement(By.linkText("Qualification"));
         WebElement OBJSKL=driver.findElement(By.linkText("Skills"));
         

         // VERIFY COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,
        if(OBJCOM.isDisplayed()&&OBJJOB.isDisplayed() && OBJQAL.isDisplayed() && OBJSKL.isDisplayed())
         {
          System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE DISPLAYED");
          
         }
         else
         {
          System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE NOT DISPLAYED");
          return;
         }
         ACT.moveToElement(OBJCOM).perform();

         // CREATE OBJECT FOR ,GENERAL, LOCATION,COMPANY STRUCTURE,COMPANY PROPERTY

         //driver.findElement(By.linkText("Company Info"));

         //driver.findElement(By.linkText("Locations")).click();
         WebElement OBJGNL=driver.findElement(By.linkText("General"));
         WebElement OBJLOC=driver.findElement(By.linkText("Locations"));
         WebElement OBJCSTR=driver.findElement(By.linkText("Company Structure"));
         WebElement OBJCPRP=driver.findElement(By.linkText("Company Property"));
         
        
         // verify GENERAL ,LOCATIONS,COMPANY STRUCTURES,COMPANY PROPERTY 
          if(OBJGNL.isDisplayed() && OBJLOC.isDisplayed() && OBJCSTR.isDisplayed() && OBJCPRP.isDisplayed())
          {
           System.out.println("General,Locations,Company Structure,Company Property are Displayed");
           
          }
          else
          {
           System.out.println("General,Locations,Company Structure,Company Property are not Displayed");
           return;
          }
       // CLICK ON LOCATION

          ACT.moveToElement(OBJCSTR).click().perform();
          
          // WAIT FOR FRAME AND SWITCH TO IT
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
          
      // CREATE WEB ELEMENT FOR COMPANY INFO:COMPANY STRUCTURE
        WebElement OBCINFO=driver.findElement(By.xpath("//div[@id='layerComStruct']/h2"));
        
        // VERIFY
          if(OBCINFO.getText().equals("Company Info : Company Structure"))
          {
       	   System.out.println("Company Info : Company Structure IS DISPLAYED");
          }
          else
       	   
          {
       	   System.out.println("Company Info : Company Structure is NOT DISPLAYED");
          }
    
       // VERIFY SUB DIV OF QAPLANET
         // if(driver.findElement(By.xpath("//td[@valign='middle']")).getText().equals("QA Planet"))
         if(driver.findElement(By.xpath("//td[@valign='middle']")).getText().equals("QAPLANET"))
       		   {
       	   		System.out.println("QAPLANET SUBDIV IS DISPLAYED");
       		   }
          else
          {
       	   System.out.println("QAPLANET IS NOT DISPLAYED");
          }
          
       // CLICK ON ADD 
          
          driver.findElement(By.xpath("//a[@class='add']")).click();
          																									
          Thread.sleep(1000);
         // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
          
       // VERIFY Add a sub-division to QA Planet
          if(driver.findElement(By.xpath("//h3[@id='parnt']")).getText().equals("Add a sub-division to QAPLANET"))
          {
       	   System.out.println("Add a sub-division to QA Planet IS DISPLAYED");
          }
          else
          {
       	   System.out.println("Add a sub-division to QA Planet IS NOT DISPLAYED");
       	   
          }
       
          // CREATE  WEB ELEMEMT FOR DEPARTMENT ID, NAME,TYPE,LOCATION,DESCRIPTION
          String DPTID="QAPLANET77";
          String NAME="HEMANTH12";
         
          WebElement OBDPTID=driver.findElement(By.name("txtDeptId"));
          WebElement OBNAME=driver.findElement(By.name("txtTitle"));
          WebElement OBTYPE=driver.findElement(By.name("cmbType"));
          WebElement OBLOC=driver.findElement(By.name("cmbLocation"));
          WebElement OBDESC=driver.findElement(By.name("txtDesc"));
          
          // VERIFY ABOVE
          
          if(OBDPTID.isDisplayed()&&OBNAME.isDisplayed()&&OBTYPE.isDisplayed()&&OBLOC.isDisplayed()&&OBDESC.isDisplayed())
          {
       	   System.out.println("DEPARTMENT ID, NAME,TYPE,LOCATION,DESCRIPTION ARE DISPLAYED");
          }
          else
          {
       	  System.out.println("DEPARTMENT ID, NAME,TYPE,LOCATION,DESCRIPTION ARE NOT DISPLAYED");
          }
         
          Select STYPE=new Select(OBTYPE);
          
          OBDPTID.clear();
          OBDPTID.sendKeys(DPTID);
          // CLICK ON SAVE
          driver.findElement(By.xpath("//input[@value='Save']")).click();
          Thread.sleep(1000);
         // CREATE ALERT
          
          Alert A=driver.switchTo().alert();
          
          // VERIFY ALERT
          if(A.getText().equals("Following errors were found:\n\n- Sub-division Name cannot be empty.\n- Please select a Type or define a custom type.\n"))
       		   {
       	   			System.out.println("ALERT MESSAGE IS DISPLAYED");
       		   }
          A.accept();
          Thread.sleep(1000);
          
          OBNAME.clear();
          OBNAME.sendKeys(NAME);
          STYPE.selectByVisibleText("Department");
          Thread.sleep(1000);
          // CLICK ON SAVE
           driver.findElement(By.xpath("//input[@value='Save']")).click();
          Thread.sleep(3000);
          
          // ROW COUNT
          
         // List<WebElement> LIST1=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr/td/a"));
   
     int rc=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
        System.out.println(rc);
        int i;
          
          for(i=rc;i<=rc;i++)
          //for(int i: LIST1)
       	  System.out.println(i);
   	   
		   {
			   String[] ARR1=DPTID.split(NAME);
       	   String DPTID1=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr["+i+"]/td[1]")).getText();
        String NAM=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).getText();
       	   if(ARR1[i].equals(DPTID))
       	   {
       		   System.out.println(DPTID+" DISPLAYED");
       	   }
      	  if(DPTID1.equals(DPTID)&&NAM.equals(NAME))
       		  
       		   if(NAM.equals(NAME))
         {
       		   System.out.println(NAME+" DISPLAYED AT: "+i);
       		   
       	   }
       	else
       		   {
       			  System.out.println(NAM);
       		   }
       	   driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
       		
		   }
          
          
        
          // EDIT TC19
          int rc1=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
          for(int j=rc1;j<=rc1;j++)
          {
          driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+j+"]/td[1]/a")).click();
          
          
          }
          Thread.sleep(2000);
          
          // VERIFY Add a sub-division to QA Planet
             if(driver.findElement(By.xpath("//h3[@id='parnt']")).getText().equals("Add a sub-division to QAPLANET"))
             {
          	   System.out.println("Add a sub-division to QA Planet IS DISPLAYED");
             }
             else
             {
          	   System.out.println("Add a sub-division to QA Planet IS NOT DISPLAYED");
          	   
             }
          
          // SEND DATA 
          
          driver.findElement(By.name("txtTitle")).clear();
          driver.findElement(By.name("txtTitle")).sendKeys("POWER");
          
          // click on save
          
          driver.findElement(By.xpath("//input[@value='Save']")).click();
          Thread.sleep(2000);
          
       
          for(int j=rc;j<=rc;j++)
          {
       //   driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
          driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+j+"]/td[4]/a")).click();
          System.out.println(rc);
          }
          Thread.sleep(2000);
          
          if(A.getText().equals("Are you sure you want to delete POWER Department. It could cause the company structure to change."))
          {
       	   System.out.println("DELETE ALERT IS DISPLAYED");
       	   A.accept();
          }
          else
          {
       	   System.out.println("DELETE ALERT IS NOT DISPLAYED");
          }
       
          }
       
}
