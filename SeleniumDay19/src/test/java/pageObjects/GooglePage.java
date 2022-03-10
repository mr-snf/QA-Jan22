package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class GooglePage {

	WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement inputSearch;

	public void search(String keyword, ExtentTest extentTest) {
		extentTest.info("Searching keyword " + keyword);
		inputSearch.sendKeys(keyword + Keys.ENTER);

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		extentTest.info("Landed on the URL " + driver.getCurrentUrl());
	}
}
