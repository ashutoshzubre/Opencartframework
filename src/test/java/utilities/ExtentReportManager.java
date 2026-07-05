package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	private static String reportPath;

	public static ExtentReports getExtentReport() {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		reportPath = System.getProperty("user.dir") + "\\reports\\OpenCartReport_" + timeStamp + ".html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkReporter.config().setReportName("OpenCart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Customer");
		extent.setSystemInfo("Tester", "Ashutosh Zubre");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extent;
	}

	public static void openReport() {

		try {

			File file = new File(reportPath);

			if (file.exists()) {

				Desktop.getDesktop().browse(file.toURI());

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}