package day7.SeleniumDay7;

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

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;

public class Runner {

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

	@Test(priority = 1)
	public void loginTest() {

		extentTest = extentReports.createTest("Login test", "Logging in mercury tours page");

		driver.get("https://demo.guru99.com/test/newtours/index.php");
		MercuryToursLoginPage mtl = new MercuryToursLoginPage(driver);
		mtl.login("test123", "test123343", extentTest);

		MercuryToursHomePage mth = new MercuryToursHomePage(driver);
		mth.verifyLogin(extentTest);

		System.out.println("login successful");
	}

	@Test(priority = 2)
	public void test23() {
		extentTest = extentReports.createTest("test 2 ", "tfdssfdsf hdfb gcasdfsfsdaf");
		extentTest.info("some thisndsfjdhfk");
	}

}
