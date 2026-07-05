package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass
{

	@Test(groups={"Regression","Master"})
	public void verify_searchProduct()
	{
		logger.info("***** Starting TC004_SearchProductTest *****");

		try
		{
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);

			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage mp = new MyAccountPage(driver);

			Assert.assertTrue(mp.isMyAccountPageExists());

			logger.info("Logged into application");

			hp.enterProductName("MacBook");
			hp.clickSearch();

			SearchPage sp = new SearchPage(driver);

			boolean status = sp.isProductExist("MacBook");

			Assert.assertEquals(status, true);

			logger.info("Product searched successfully");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}

		logger.info("***** Finished TC004_SearchProductTest *****");
	}
}