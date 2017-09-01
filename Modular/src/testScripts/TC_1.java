package testScripts;

import webdriver.BusinessFunctions;
public class TC_1 {

	public void LoginOrangeHrm()
	{
		BusinessFunctions Br=new BusinessFunctions();
		Br.Configuration("Chrome");
		Br.OpenApplication("http://apps.qaplanet.in/qahrm/login.php");
		Br.LoginToOrangeHRM("qaplanet1", "user1");
		Br.LogoutFromApp();
		Br.closebrowser();
		Br.quitobject();
		
		
	}

}
