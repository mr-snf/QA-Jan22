package day20.SeleniumDay20;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.InternetDownloadPage;
import pageObjects.InternetUploadPage;

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

		chooseDriver(1);
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
	public void downloadTest() throws InterruptedException {
		extentTest = extentReports.createTest("Downloading files test");

		driver.get("https://the-internet.herokuapp.com/download");

		InternetDownloadPage idp = new InternetDownloadPage(null);
		idp.download(extentTest, downloadFolder);

		Thread.sleep(3000);

	}

	@Test
	public void uploadTest() throws InterruptedException {
		extentTest = extentReports.createTest("Uploading files test");

		driver.get("https://the-internet.herokuapp.com/upload");

		InternetUploadPage iup = new InternetUploadPage(driver);

		String fileToUpload = "C:\\Users\\sanish.n_homeloanexp\\Downloads\\autoIT.zip";

		iup.uploadFile(extentTest, fileToUpload);

		Thread.sleep(3000);
	}
}
