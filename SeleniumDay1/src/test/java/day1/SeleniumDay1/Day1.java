package day1.SeleniumDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {

	public static void main(String[] args) throws InterruptedException {

		// chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\sanish\\QA III\\Eclipse-workspace\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// firefox browser
//		System.setProperty("webdriver.gecko.driver", "D:\\sanish\\QA III\\Eclipse-workspace\\drivers\\geckodriver.exe");
//
//		WebDriver driver = new FirefoxDriver();

		driver.get("https://google.com");

		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys("apple");

		Thread.sleep(3000);

		WebElement btnSearch = driver.findElement(By.name("btnK"));
		btnSearch.click();

		Thread.sleep(5000);
		driver.close();

	}

}
