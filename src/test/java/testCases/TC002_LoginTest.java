package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() {

		logger.info("******** Starting Login Test ********");

		try {

			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked My Account");

			hp.clickLogin();
			logger.info("Clicked Login");

			LoginPage lp = new LoginPage(driver);

			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));

			logger.info("Entered Login Credentials");

			lp.clickLogin();

			MyAccountPage myacc = new MyAccountPage(driver);

			boolean targetPage = myacc.isMyAccountPageExists();

			Assert.assertTrue(targetPage);

			logger.info("Login Successful");

		}
		catch(Exception e)
		{
			logger.error("Login Failed");
			logger.debug(e.getMessage());
			Assert.fail();
		}

	}

}