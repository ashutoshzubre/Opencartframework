package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected WebDriver driver;
	protected Logger logger;
	protected Properties p;

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException {

		FileInputStream file = new FileInputStream("./src/test/resources/config.properties");

		p = new Properties();

		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// os and browser
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else {
				System.out.println("No Matching OS");
				return;
			}
			
			switch(browser.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching browser"); return;
			
			}
			driver= new RemoteWebDriver(new URL("new URL(\"http://localhost:4444\")"), capabilities);
		}
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		switch(browser.toLowerCase()) {

		case "chrome":

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);

			break;

		case "edge":

			driver = new EdgeDriver();

			driver.manage().window().maximize();

			break;

		case "firefox":

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			break;

		default:

			throw new IllegalArgumentException("Invalid Browser Name");

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().deleteAllCookies();

		driver.get(p.getProperty("appURL"));

		logger.info("******** Application Launched ********");
		}

		                         

	}

	@AfterClass
	public void tearDown() {

		if(driver != null) 
		{

			driver.quit();

			logger.info("******** Browser Closed ********");

		}

	}

	// Screenshot Method
	public String captureScreen(String testName) throws IOException {

		String targetFilePath = System.getProperty("user.dir")
				+ "\\screenshots\\"
				+ testName
				+ "_"
				+ System.currentTimeMillis()
				+ ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		File targetFile = new File(targetFilePath);

		FileUtils.copyFile(sourceFile, targetFile);

		logger.info("Screenshot Captured : " + targetFilePath);

		return targetFilePath;

	}

	@SuppressWarnings("deprecation")
	public String randomString() {

		return RandomStringUtils.randomAlphabetic(5);

	}

	@SuppressWarnings("deprecation")
	public String randomNumber() {

		return RandomStringUtils.randomNumeric(5);

	}

	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric() {

		return RandomStringUtils.randomAlphanumeric(8);

	}                          
	    
	

}