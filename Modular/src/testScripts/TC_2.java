package testScripts;


import webdriver.BusinessFunctions;
public class TC_2 {
	public void AddEmployee()
	{
		BusinessFunctions Br=new BusinessFunctions();
		Br.Configuration("Chrome");
		Br.OpenApplication("http://apps.qaplanet.in/qahrm/login.php");
		Br.LoginToOrangeHRM("qaplanet1", "user1");
		Br.AddEmployee();
		Br.LogoutFromApp();
		Br.closebrowser();
		Br.quitobject();
		
		
	}

}
