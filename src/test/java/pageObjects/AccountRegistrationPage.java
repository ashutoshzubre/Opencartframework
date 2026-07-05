package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement chkSubscribe;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath="//button[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Action Methods

	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void confirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}

	public void subscribe()
	{
		chkSubscribe.click();
	}

	public void privacy()
	{
		chkPolicy.click();
	}

	public void clickContinue()
	{
		btnContinue.click();
	}

	public String getConfirmationMessage()
	{
		try
		{
			return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

	public void setTelephone(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPrivacyPolicy() {
		// TODO Auto-generated method stub
		
	}
}