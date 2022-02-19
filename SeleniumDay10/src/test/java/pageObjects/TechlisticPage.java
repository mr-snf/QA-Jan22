package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TechlisticPage {

	public TechlisticPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	WebElement inputFirstName;

	@FindBy(name = "lastname")
	WebElement inputLastName;

	@FindBy(id = "sex-0")
	WebElement radioGenderMale;

	@FindBy(id = "sex-1")
	WebElement radioGenderFemale;

	@FindBy(id = "profession-0")
	WebElement chkboxManualTester;

	@FindBy(id = "profession-1")
	WebElement chkboxAutomationTester;

	@FindBy(id = "continents")
	WebElement selectContinents;

	@FindBy(id = "selenium_commands")
	WebElement selectSelCommands;

	public void fillupForm(String fname, String lname) throws InterruptedException {
		inputFirstName.sendKeys(fname);
		Thread.sleep(500);
		inputLastName.sendKeys(lname);
		Thread.sleep(500);
		radioGenderMale.click();
		Thread.sleep(500);
		radioGenderFemale.click();
		Thread.sleep(500);
		chkboxManualTester.click();
		Thread.sleep(500);
		chkboxAutomationTester.click();

		Select continents = new Select(selectContinents);
		continents.selectByIndex(3);
		continents.selectByVisibleText("Africa");
//		continents.selectByValue("Dfsafdfs");

		Select seleniumCommands = new Select(selectSelCommands);
		seleniumCommands.selectByIndex(0);
		seleniumCommands.selectByIndex(2);

	}
}
