package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{

		logger.info("******** Starting Account Registration Test ********");

		try
		{

			HomePage hp=new HomePage(driver);

			hp.clickMyAccount();

			logger.info("Clicked on My Account");

			hp.clickRegister();

			logger.info("Clicked on Register");

			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

			regpage.setFirstName(randomString().toUpperCase());

			regpage.setLastName(randomString().toUpperCase());

			String email=randomString()+System.currentTimeMillis()+"@gmail.com";

			regpage.setEmail(email);

			String password=randomAlphaNumeric();

			regpage.setPassword(password);

			regpage.confirmPassword(password);

			regpage.subscribe();

			regpage.privacy();

			regpage.clickContinue();

			logger.info("Registration Form Submitted");

			String confmsg=regpage.getConfirmationMessage();

			Assert.assertEquals(confmsg,"Your Account Has Been Created!");

			logger.info("Account Registered Successfully");

		}
		catch(Exception e)
		{

			logger.error("Test Failed");

			logger.debug(e.getMessage());

			Assert.fail();

		}

	}

}