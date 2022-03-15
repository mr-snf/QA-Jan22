package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class ToolsQAPage {

	WebDriver driver = null;

	public ToolsQAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userName")
	WebElement inputUsername;

	@FindBy(id = "userEmail")
	WebElement inputEmail;

	@FindBy(id = "currentAddress")
	WebElement inputCurrentAddress;

	@FindBy(id = "permanentAddress")
	WebElement inputPermanentAddress;

	@FindBy(id = "submit")
	WebElement btnSubmit;

	public void fillForm(String name, String email, String currentAddress, String permanentAddress,
			ExtentTest extentTest) {
		inputUsername.sendKeys(name);
		extentTest.info("Added name : " + name);
		inputEmail.sendKeys(email);
		extentTest.info("Added email : " + email);
		inputCurrentAddress.sendKeys(currentAddress);
		extentTest.info("Added current address : " + currentAddress);
		inputPermanentAddress.sendKeys(permanentAddress);
		extentTest.info("Added permanent address : " + permanentAddress);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", btnSubmit);

		btnSubmit.click();
		extentTest.info("Submitted the form");
	}
}
