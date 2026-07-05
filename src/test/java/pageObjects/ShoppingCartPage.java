package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
{

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement lnkShoppingCart;

	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement btnViewCart;

	@FindBy(xpath="//td[@class='text-end'][2]")
	WebElement totalPrice;

	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;

	public void clickItemsToNavigateToCart()
	{
		lnkShoppingCart.click();
	}

	public void clickViewCart()
	{
		btnViewCart.click();
	}

	public String getTotalPrice()
	{
		try
		{
			return totalPrice.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

	public void clickOnCheckout()
	{
		btnCheckout.click();
	}
}