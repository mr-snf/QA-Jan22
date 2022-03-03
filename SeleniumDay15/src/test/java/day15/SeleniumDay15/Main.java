package day15.SeleniumDay15;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.DemoQA;

public class Main {
	private WebDriver driver;
	private ExtentSparkReporter extentReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;

	private void chooseDriver(int value) {

		switch (value) {
		case 1:
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case 2:
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case 3:
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		chooseDriver(4);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void setup() {
		File reportsFolder = new File("reports");

		if (!reportsFolder.exists() || !reportsFolder.isDirectory()) {
			reportsFolder.mkdirs();
		}

		File report = new File(reportsFolder, "ExtentReport.html");

		extentReporter = new ExtentSparkReporter(report);
		extentReporter.config().setDocumentTitle("Automation report");
		extentReporter.config().setReportName("Regression test");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentReporter);
		extentReports.setSystemInfo("Project", "Mercury");
		extentReports.setSystemInfo("Tester", "Sanish");
	}

	@AfterClass
	public void teardown() {
		extentReports.flush();
	}

	@Test
	public void handleAlerts() throws InterruptedException {
		extentTest = extentReports.createTest("Handling alerts");
		driver.get("https://demoqa.com/alerts");

		DemoQA qa = new DemoQA(driver);

//		qa.simpleAlert();
//		Thread.sleep(2000);
//
//		qa.confirmAlert();
//		Thread.sleep(2000);

//		qa.promptAlert();
//		Thread.sleep(2000);

		qa.timedAlert();
		Thread.sleep(2000);
	}
}
