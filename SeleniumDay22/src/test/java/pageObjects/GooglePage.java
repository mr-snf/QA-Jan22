package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class GooglePage {

	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement inputSearch;

	public void performSearch(String keyword, ExtentTest extentTest) {
		inputSearch.sendKeys(keyword + Keys.ENTER);
		extentTest.info("Performing search for " + keyword);
	}

}
