package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryToursPage {

	public MercuryToursPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	WebElement inputUsername;

	@FindBy(name = "password")
	WebElement inputPassword;

	@FindBy(name = "submit")
	WebElement btnSubmit;

	public void login(String username, String password) {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		btnSubmit.click();
	}

}
