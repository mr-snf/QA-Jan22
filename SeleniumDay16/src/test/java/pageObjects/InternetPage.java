package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetPage {

	WebDriver driver = null;

	public InternetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Basic Auth")
	WebElement linkBasicAuth;

	@FindBy(linkText = "Digest Authentication")
	WebElement linkDigestAuth;

	public void basicAuth() throws InterruptedException, IOException {
		linkBasicAuth.click();
		Runtime.getRuntime().exec("D:\\sanish\\QA III\\Eclipse-workspace\\SeleniumDay16\\autoIT\\autoIT.exe");
		Thread.sleep(2000);
	}

	public void digestAuth() throws InterruptedException, IOException {
		linkDigestAuth.click();
		Runtime.getRuntime().exec("D:\\sanish\\QA III\\Eclipse-workspace\\SeleniumDay16\\autoIT\\autoIT.exe");
		Thread.sleep(2000);
	}

}
