package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class GooglePage {

	WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement inputSearch;

	@FindBy(name = "btnK")
	WebElement btnSearch;

	@FindBy(name = "btnI")
	WebElement btnLuckySearch;

	@FindBy(className = "UUbT9")
	WebElement divSuggestions;

	public void search(String keyword, ExtentTest test) {
		test.info("Searching " + keyword + " in google");
//		inputSearch.sendKeys(keyword + Keys.ENTER);

		System.out.println(divSuggestions.isDisplayed());

		inputSearch.sendKeys(keyword);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(btnSearch));

		btnSearch.click();

		// btnLuckySearch.click();

//		driver.switchTo().alert();

	}

}
