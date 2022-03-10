package day19.SeleniumDay19;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.GooglePage;
import pageObjects.InternetDownloadPage;

public class TestApp {
	private WebDriver driver;
	private ExtentSparkReporter extentReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;

	private void chooseDriver(int value) {

		switch (value) {
		case 1:
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");

			FirefoxOptions firefox = new FirefoxOptions();

//			firefox.setHeadless(true);
//			firefox.setAcceptInsecureCerts(true);
			firefox.setBrowserVersion("84.54564.554");

			driver = new FirefoxDriver(firefox);
			break;

		case 2:
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");

			EdgeOptions edge = new EdgeOptions();

			Map<String, String> dwnldedge = new HashMap<String, String>();
			dwnldedge.put("download.default_directory", "D:\\download");
			edge.setExperimentalOption("prefs", dwnldedge);

			driver = new EdgeDriver(edge);
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");

			ChromeOptions chrome = new ChromeOptions();
//			chrome.addArguments("--start-maximized");
//			chrome.addArguments("--ignore-certificate-error");
//			chrome.addArguments("--headless");

//			chrome.setHeadless(true);
//			chrome.setAcceptInsecureCerts(true);
//			chrome.addExtensions(new File("c:/abc.crx"));
//			chrome.setBrowserVersion("97.5164.54");

//			Map<String, String> maps = new HashMap<String, String>();
////			maps.put("deviceName", "Nexus 4");
////			maps.put("deviceName", "iPhone 8");
//			maps.put("deviceName", "Galaxy S5");
//			chrome.setExperimentalOption("mobileEmulation", maps);

			Map<String, String> dwnld = new HashMap<String, String>();
			dwnld.put("download.default_directory", "D:\\download");
			chrome.setExperimentalOption("prefs", dwnld);

			driver = new ChromeDriver(chrome);
			break;
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		chooseDriver(2);
//		driver.manage().window().maximize();
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
	public void desiredCaps() throws InterruptedException {
		extentTest = extentReports.createTest("Using browser capabilities");

		driver.get("https://google.com");

		GooglePage gp = new GooglePage(driver);
		gp.search("Apple", extentTest);

		Thread.sleep(2000);
	}

	@Test
	public void download() throws InterruptedException {
		extentTest = extentReports.createTest("Using browser capabilities");

		driver.get("https://the-internet.herokuapp.com/download");

		InternetDownloadPage ip = new InternetDownloadPage(driver);
		ip.download();

		Thread.sleep(2000);
	}
}
