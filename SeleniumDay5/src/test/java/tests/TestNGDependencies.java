package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDependencies {

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

	@BeforeClass
	public void beforeClass() {

	}

	@BeforeMethod
	public void beforeMethod() {
		chooseDriver(4);
		driver.get("https://google.com");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority = 23)
	public void test1() {
		System.out.println("test 1");
	}

	@Test(dependsOnMethods = { "test1", "test3" })
	public void test2() {
		System.out.println("test 2");
	}

	@Test(priority = 8)
	public void test3() {
		System.out.println("test 3");
	}

	@Test(groups = "testGroup1")
	public void test4() {
		System.out.println("test 4");
	}

	@Test(groups = "testGroup2")
	public void test5() {
		System.out.println("test 5");
	}

	@Test(groups = "testGroup2")
	public void test6() {
		System.out.println("test 6");
	}

	@Test(groups = "testGroup1")
	public void test7() {
		System.out.println("test 7");
	}

	@Test(dependsOnGroups = { "testGroup1", "testGroup2" })
	public void test8() {
		System.out.println("test 8");
	}
}
