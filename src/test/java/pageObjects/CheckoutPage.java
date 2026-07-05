package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage
{

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(id="input-payment-firstname")
	WebElement txtFirstName;

	@FindBy(id="input-payment-lastname")
	WebElement txtLastName;

	@FindBy(id="input-payment-address-1")
	WebElement txtAddress1;

	@FindBy(id="input-payment-address-2")
	WebElement txtAddress2;

	@FindBy(id="input-payment-city")
	WebElement txtCity;

	@FindBy(id="input-payment-postcode")
	WebElement txtPostCode;

	@FindBy(id="input-payment-country")
	WebElement drpCountry;

	@FindBy(id="input-payment-zone")
	WebElement drpState;

	@FindBy(id="button-payment-address")
	WebElement btnBillingContinue;

	@FindBy(id="button-shipping-address")
	WebElement btnDeliveryAddressContinue;

	@FindBy(name="comment")
	WebElement txtComment;

	@FindBy(id="button-shipping-method")
	WebElement btnDeliveryMethodContinue;

	@FindBy(name="agree")
	WebElement chkTerms;

	@FindBy(id="button-payment-method")
	WebElement btnPaymentMethodContinue;

	@FindBy(xpath="//strong[contains(text(),'Total')]//parent::td/following-sibling::td")
	WebElement lblTotal;

	@FindBy(id="button-confirm")
	WebElement btnConfirmOrder;

	@FindBy(xpath="//h1[contains(text(),'Your order has been placed!')]")
	WebElement orderPlacedMsg;

	public void setFirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void setAddress1(String address)
	{
		txtAddress1.clear();
		txtAddress1.sendKeys(address);
	}

	public void setAddress2(String address)
	{
		txtAddress2.clear();
		txtAddress2.sendKeys(address);
	}

	public void setCity(String city)
	{
		txtCity.clear();
		txtCity.sendKeys(city);
	}

	public void setPin(String pin)
	{
		txtPostCode.clear();
		txtPostCode.sendKeys(pin);
	}

	public void setCountry(String country)
	{
		Select sc = new Select(drpCountry);
		sc.selectByVisibleText(country);
	}

	public void setState(String state)
	{
		Select sc = new Select(drpState);
		sc.selectByVisibleText(state);
	}

	public void clickContinueAfterBillingAddress()
	{
		btnBillingContinue.click();
	}

	public void clickContinueAfterDeliveryAddress()
	{
		btnDeliveryAddressContinue.click();
	}

	public void setDeliveryMethodComment(String comment)
	{
		txtComment.sendKeys(comment);
	}

	public void clickContinueAfterDeliveryMethod()
	{
		btnDeliveryMethodContinue.click();
	}

	public void selectTermsAndConditions()
	{
		chkTerms.click();
	}

	public void clickContinueAfterPaymentMethod()
	{
		btnPaymentMethodContinue.click();
	}

	public String getTotalPriceBeforeConOrder()
	{
		return lblTotal.getText();
	}

	public void clickConfirmOrder()
	{
		btnConfirmOrder.click();
	}

	public boolean isOrderPlaced()
	{
		try
		{
			return orderPlacedMsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}