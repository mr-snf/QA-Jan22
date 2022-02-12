package day5.SeleniumDay6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.MercuryToursHomePage;
import pageObjects.MercuryToursLoginPage;

public class Runner {

	WebDriver driver;

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

	@Test(priority = 1)
	public void loginTest() {
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		MercuryToursLoginPage mtl = new MercuryToursLoginPage(driver);
		mtl.login("test123", "test123r");

		MercuryToursHomePage mth = new MercuryToursHomePage(driver);
		mth.verifyLogin();

		System.out.println("login successful");
	}

	@Test(priority = 2)
	public void loginTest2() {
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		MercuryToursLoginPage mtl = new MercuryToursLoginPage(driver);
		mtl.login("test123", "test123d");

		MercuryToursHomePage mth = new MercuryToursHomePage(driver);
		mth.verifyLogin2();

		System.out.println("login successful");
	}

}
