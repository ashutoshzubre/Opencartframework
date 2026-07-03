package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOpenCart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.opencart.com/en-gb?route=common/home");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}
}      