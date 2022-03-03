package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class GooglePage {

	WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "UUbT9")
	WebElement divSuggestion;

	@FindBy(name = "q")
	WebElement inputSearch;

//	@FindBy(className = "gNO89b")
//	WebElement btnSearch;

	public void performSearch(String keyword, ExtentTest extentTest) throws InterruptedException {
		extentTest.info("attribute value: " + divSuggestion.getAttribute("style"));
		System.out.println("attribute value: " + divSuggestion.getAttribute("style"));
		inputSearch.sendKeys(keyword);
		Thread.sleep(3000);

		if (divSuggestion.getAttribute("style").equals("display: none;")) {
			extentTest.fail("The suggestion box didnot show up");
		} else {
			extentTest.pass("The suggestion box showed up");
		}

		extentTest.info("attribute value: " + divSuggestion.getAttribute("style"));
		System.out.println("attribute value: " + divSuggestion.getAttribute("style"));

		inputSearch.sendKeys(Keys.CONTROL + "z");
		Thread.sleep(1000);
		inputSearch.sendKeys(Keys.BACK_SPACE);

//		Actions actions = new Actions(driver);
//		actions.keyDown(Keys.LEFT_CONTROL).sendKeys(inputSearch, "a").build().perform();
//		actions.sendKeys(inputSearch, Keys.BACK_SPACE).build().perform();
//		actions.keyUp(Keys.LEFT_CONTROL).build().perform();
	}

}
