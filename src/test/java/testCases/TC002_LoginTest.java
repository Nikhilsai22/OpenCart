package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

//import day47.LoginPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***starting TC002_LoginTest***");
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targerPage=macc.isMyAccountPageExits();
		
		//Assert.assertEquals(targerPage, true, "Login failed");
		Assert.assertTrue(targerPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Finished TC002_LoginTest***");
	}
}
