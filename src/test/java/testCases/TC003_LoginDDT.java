package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(
			dataProvider="LoginData",
			dataProviderClass=DataProviders.class,
			groups={"Regression","Master"}
		)	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("******** Starting Data Driven Login Test ********");

		try {

			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked on My Account");

			hp.clickLogin();
			logger.info("Clicked on Login");

			LoginPage lp = new LoginPage(driver);

			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			logger.info("Login credentials submitted");

			MyAccountPage myacc = new MyAccountPage(driver);

			boolean targetPage = myacc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage) {

					Assert.assertTrue(true);

					logger.info("Valid Login Successful");

					myacc.clickLogout();

				} else {

					Assert.fail();

				}

			} else if (exp.equalsIgnoreCase("Invalid")) {

				if (targetPage) {

					myacc.clickLogout();

					Assert.fail();

				} else {

					Assert.assertTrue(true);

					logger.info("Invalid Login Validation Successful");

				}

			}

		} catch (Exception e) {

			logger.error("DDT Login Test Failed");

			logger.error(e.getMessage());

			Assert.fail();

		}

	}

}