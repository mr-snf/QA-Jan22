package mecuryToursTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.MercuryToursLoginPage;

public class MecuryToursTests {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		System.out.println("before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
//		driver.close();
		driver.quit();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}

	@Test(priority = 1)
	public void test2() {
		System.out.println("test2");
	}

	@Test(priority = 3)
	public void test1() {
		System.out.println("test1");
	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		driver.get("https://demo.guru99.com/test/newtours/index.php");

		MercuryToursLoginPage mtl = new MercuryToursLoginPage(driver);

		mtl.login("test123", "test123");

		Thread.sleep(2000);
	}
}
