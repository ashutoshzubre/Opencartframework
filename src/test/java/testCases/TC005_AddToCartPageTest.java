package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {

    @Test(groups = {"Master"})
    public void verify_addToCart() {

        logger.info("***** Starting TC005_AddToCartPageTest *****");

        try {

            // Login
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

            // Search Product
            hp.enterProductName("iPhone");
            hp.clickSearch();

            SearchPage sp = new SearchPage(driver);

            if (sp.isProductExist("iPhone")) {

                sp.selectProduct("iPhone");
                sp.setQuantity("2");
                sp.addToCart();

            }

            Assert.assertEquals(sp.checkConfMsg(), true);

            logger.info("Product added to cart successfully");

        }

        catch (Exception e) {

            logger.error("Test Failed");
            Assert.fail();

        }

        logger.info("***** Finished TC005_AddToCartPageTest *****");

    }

}