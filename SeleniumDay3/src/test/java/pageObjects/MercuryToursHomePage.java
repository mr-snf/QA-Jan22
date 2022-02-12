package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryToursHomePage {

	public MercuryToursHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")
	WebElement inputUsername;

	@FindBy(css = "body > div:nth-child(5) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(3) > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")
	WebElement inputPassword;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")
	WebElement btnSubmit;

	@FindBy(id = "site-name")
	WebElement pageTitle1;

	@FindBy(className = "site-name")
	WebElement pageTitle2;

	@FindBy(linkText = "Demo Site")
	WebElement pageTitle3;

	@FindBy(partialLinkText = "Demo Si")
	WebElement pageTitle4;

	@FindBy(tagName = "nav")
	WebElement navBar;

	public void login(String username, String password) throws InterruptedException {
//
//		System.out.println(pageTitle1.getText());
//		System.out.println(pageTitle2.getText());
//		System.out.println(pageTitle3.getText());
		System.out.println(pageTitle4.getText());
//		System.out.println(navBar.getText());
		inputUsername.sendKeys(username);
		Thread.sleep(1000);
		inputUsername.clear();
		Thread.sleep(1000);
		inputPassword.sendKeys(password);
		btnSubmit.click();
	}
}
