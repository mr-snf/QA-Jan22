package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MercuryToursHomePage {

	private WebDriver driver;

	public MercuryToursHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(tagName = "h3")
	WebElement labelLoginSuccess;

	public void verifyLogin() {
		String actual = "https://demo.guru99.com/test/newtours/login_sucess.php";
		String url = driver.getCurrentUrl();
		assertEquals(url, actual, "Login Failed!!");
		assertTrue(labelLoginSuccess.isDisplayed(), "Login Failed!!");
//		Assert.assertNotNull(labelLoginSuccess, "Login Failed!!");
	}

	public void verifyLogin2() {
		String actual = "https://demo.guru99.com/test/newtours/login_sucess.php";
		String url = driver.getCurrentUrl();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(url, actual, "Failed!!!");
		soft.assertFalse(labelLoginSuccess.isDisplayed(), "Login Failed!!");

		System.out.println("Login complete");

		soft.assertAll();
	}

}
