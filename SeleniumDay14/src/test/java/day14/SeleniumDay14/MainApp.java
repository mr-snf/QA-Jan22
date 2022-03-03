package day14.SeleniumDay14;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
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

public class MainApp {
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
	public void handlingWindow() throws InterruptedException {
		extentTest = extentReports.createTest("handling browser window");
		System.out.println(driver.manage().window().getPosition());
		System.out.println(driver.manage().window().getSize());
//		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println(driver.manage().window().getPosition());
		driver.get("https://google.com");

		Point scrPoint = new Point(100, 100);

		driver.manage().window().setPosition(scrPoint);
		Thread.sleep(3000);

		Dimension scrDim = new Dimension(600, 400);
		driver.manage().window().setSize(scrDim);

//		driver.manage().window().fullscreen();
//		System.out.println(driver.manage().window().getPosition());
//		Thread.sleep(3000);
//		driver.manage().window().minimize();
//
//		System.out.println(driver.manage().window().getPosition());
//		System.out.println(driver.manage().window().getSize());

		Thread.sleep(3000);
	}

	@Test
	public void browserNavigation() throws InterruptedException {
		extentTest = extentReports.createTest("handling browser navigation");
		driver.navigate().to("https://duckduckgo.com");
		driver.get("https://google.com");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
	}

	@Test
	public void handlingTabs() throws InterruptedException {
		extentTest = extentReports.createTest("handling browser tabs");
		driver.navigate().to("https://duckduckgo.com");
		String parent = driver.getWindowHandle();
		System.out.println(driver.getWindowHandle());

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://google.com");
		System.out.println(driver.getWindowHandle());
		driver.close();

		driver.switchTo().window(parent);
		driver.navigate().to("https://bing.com");

//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.close();
		Thread.sleep(3000);

	}

	@Test
	public void handlingTabs2() throws InterruptedException {
		extentTest = extentReports.createTest("handling browser tabs");
		driver.navigate().to("https://demoqa.com/links");

//		Thread.sleep(2000);

		String parentTab = driver.getWindowHandle();

		driver.findElement(By.id("simpleLink")).click();

		Set<String> tabs = driver.getWindowHandles();
		tabs.remove(parentTab);

		if (tabs.iterator().hasNext()) {
			String newTab = tabs.iterator().next();
			driver.switchTo().window(newTab);
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());

			driver.close();
		}

//		Thread.sleep(2000);
		driver.switchTo().window(parentTab);
//		Thread.sleep(2000);

		driver.findElement(By.id("dynamicLink")).click();

		Set<String> tabs2 = driver.getWindowHandles();
		tabs2.remove(parentTab);

		if (tabs2.iterator().hasNext()) {
			String newTab2 = tabs2.iterator().next();
			driver.switchTo().window(newTab2);
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());

			driver.close();
		}

		driver.switchTo().window(parentTab);
		driver.get("https://google.com");
		Thread.sleep(2000);
	}

}
