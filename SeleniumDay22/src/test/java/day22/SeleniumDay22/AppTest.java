package day22.SeleniumDay22;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.GooglePage;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private WebDriver driver;
	private ExtentSparkReporter extentReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	private String downloadFolder;

	private void chooseDriver(int value) {

		switch (value) {
		case 1:
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			downloadFolder = "D:\\download\\firefox";

			FirefoxProfile fprofile = new FirefoxProfile();

			fprofile.setPreference("browser.download.dir", downloadFolder);
			fprofile.setPreference("browser.download.folderList", 2);
			fprofile.setPreference("browser.download.manager.showWhenStarting", false);
			fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", "");

			FirefoxOptions firefox = new FirefoxOptions();
			firefox.setProfile(fprofile);

			driver = new FirefoxDriver(firefox);
			break;

		case 2:
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
			downloadFolder = "D:\\download\\edge";
			EdgeOptions edge = new EdgeOptions();

			Map<String, String> dwnldedge = new HashMap<String, String>();
			dwnldedge.put("download.default_directory", downloadFolder);
			edge.setExperimentalOption("prefs", dwnldedge);

			driver = new EdgeDriver(edge);
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			downloadFolder = "D:\\download\\chrome";
			ChromeOptions chrome = new ChromeOptions();

			Map<String, String> dwnld = new HashMap<String, String>();
			dwnld.put("download.default_directory", downloadFolder);
			chrome.setExperimentalOption("prefs", dwnld);

			driver = new ChromeDriver(chrome);
			break;
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {

		File dwnldFolder = new File("D://download");
		if (dwnldFolder.exists())
			FileUtils.deleteDirectory(dwnldFolder);

//		chooseDriver(1);
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

	@DataProvider(name = "dataProviderMethod")
	public String[] dataSet() {
		return new String[] { "apple", "oneplus", "samsung", "lg", "motorola" };
	}

	// @Test(dataProvider = "dataProviderMethod")
	public void googleSearch(String keyword) throws InterruptedException {
		extentTest = extentReports.createTest("Performing search with different keywords");

		driver.get("https://google.com");

		GooglePage gp = new GooglePage(driver);
		gp.performSearch(keyword, extentTest);

		Thread.sleep(2000);
	}

	@DataProvider(name = "dataProvider2")
	public String[][] getData() {
		return new String[][] { { "https://google.com", "apple" }, { "https://google.com", "windows" },
				{ "https://google.com", "linux" }, { "https://www.bing.com", "apple" },
				{ "https://www.bing.com", "linux" }, { "https://www.bing.com", "windows" } };
	}

	// @Test(dataProvider = "dataProvider2")
	public void googleSearch2(String url, String keyword) throws InterruptedException {
		extentTest = extentReports.createTest("Performing search with different keywords");

		driver.get(url);
		extentTest.info("Navigating to " + url);

		GooglePage gp = new GooglePage(driver);
		gp.performSearch(keyword, extentTest);

		Thread.sleep(2000);
	}

	@Test
	@Parameters({ "url", "browserType", "searchText" })
	public void googleSearch3(String url, String browserType, String keyword) throws InterruptedException {
		extentTest = extentReports.createTest("Performing search with different keywords");

		chooseDriver(Integer.valueOf(browserType));
		driver.manage().window().maximize();

		driver.get(url);
		extentTest.info("Navigating to " + url);

		GooglePage gp = new GooglePage(driver);
		gp.performSearch(keyword, extentTest);

		Thread.sleep(2000);
	}

}
