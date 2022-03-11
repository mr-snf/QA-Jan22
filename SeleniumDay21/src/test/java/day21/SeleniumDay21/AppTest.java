package day21.SeleniumDay21;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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

import pageObjects.InternetHerokuPage;

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
	public void handleAuthUsingRobot() throws AWTException, InterruptedException {
		extentTest = extentReports.createTest("handleAuthUsingRobot");

		driver.get("https://the-internet.herokuapp.com/basic_auth");

		Robot robot = new Robot();
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

//		robot.mouseMove(700, 200);
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_A);
//		robot.keyPress(KeyEvent.VK_D);
//		robot.keyPress(KeyEvent.VK_M);
//		robot.keyPress(KeyEvent.VK_I);
//		robot.keyPress(KeyEvent.VK_N);
//		robot.keyRelease(KeyEvent.VK_SHIFT);
//		Thread.sleep(3000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(3000);
////		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
////		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_A);
//		robot.keyPress(KeyEvent.VK_D);
//		robot.keyPress(KeyEvent.VK_M);
//		robot.keyPress(KeyEvent.VK_I);
//		robot.keyPress(KeyEvent.VK_N);
//		robot.keyRelease(KeyEvent.VK_SHIFT);
//		Thread.sleep(3000);
//		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

	}

	@Test
	public void clickUsingRobot() throws AWTException, InterruptedException {
		driver.get("https://the-internet.herokuapp.com/checkboxes");

		InternetHerokuPage ihp = new InternetHerokuPage(driver);
		ihp.selectOptions();

		Thread.sleep(2000);
	}
}
