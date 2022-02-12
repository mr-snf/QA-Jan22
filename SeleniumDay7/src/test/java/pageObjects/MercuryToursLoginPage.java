package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class MercuryToursLoginPage {

	public MercuryToursLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	WebElement inputUsername;

	@FindBy(name = "password")
	WebElement inputPassword;

	@FindBy(name = "submit")
	WebElement btnSubmit;

	public void login(String username, String password, ExtentTest extentTest) {
		inputUsername.sendKeys(username);
//		extentTest.log(Status.INFO, "Entered username");
		extentTest.info("Entered username");
		inputPassword.sendKeys(password);
		extentTest.info("Entered password");
		btnSubmit.click();
		extentTest.info("Clicked login button");
	}
}
