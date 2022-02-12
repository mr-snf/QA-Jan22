package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.MercuryToursPage;

public class MercuryToursTests {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/index.php");

		MercuryToursPage mtp = new MercuryToursPage(driver);

		mtp.login("test123", "test123");

		Thread.sleep(3000);

		driver.close();

	}

}
