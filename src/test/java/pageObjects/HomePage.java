package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	// My Account
	@FindBy(xpath="//span[text()='My Account']")
	WebElement linkMyAccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;

	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkLogin;

	// Search Product
	@FindBy(name="search")
	WebElement txtSearch;

	@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
	WebElement btnSearch;

	// Action Methods

	public void clickMyAccount()
	{
		linkMyAccount.click();
	}

	public void clickRegister()
	{
		linkRegister.click();
	}

	public void clickLogin()
	{
		linkLogin.click();
	}

	public void enterProductName(String productName)
	{
		txtSearch.clear();
		txtSearch.sendKeys(productName);
	}

	public void clickSearch()
	{
		btnSearch.click();
	}
}