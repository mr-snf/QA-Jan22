package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.MercuryToursHomePage;

public class MercuryToursTests {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/index.php");

		MercuryToursHomePage mth = new MercuryToursHomePage(driver);

		mth.login("test123", "test123");

		Thread.sleep(3000);

		driver.close();

	}

}
