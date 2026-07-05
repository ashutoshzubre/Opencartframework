package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//div[@class='product-thumb']")
	List<WebElement> products;

	@FindBy(xpath="//input[@name='quantity']")
	WebElement txtQuantity;

	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddToCart;

	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	WebElement confirmationMsg;

	public boolean isProductExist(String productName)
	{
		try
		{
			driver.findElement(By.linkText(productName));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public void selectProduct(String productName)
	{
		driver.findElement(By.linkText(productName)).click();
	}

	public void setQuantity(String qty)
	{
		txtQuantity.clear();
		txtQuantity.sendKeys(qty);
	}

	public void addToCart()
	{
		btnAddToCart.click();
	}

	public String checkConfMsg()
	{
		try
		{
			return confirmationMsg.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}