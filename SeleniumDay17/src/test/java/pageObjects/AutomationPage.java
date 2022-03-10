package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPage {

	WebDriver driver;

	public AutomationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[1]/a")
	WebElement tabSingleIframe;

	@FindBy(xpath = "/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")
	WebElement tabMultipleIframe;

	@FindBy(xpath = "//iframe[@src=\"MultipleFrames.html\"]")
	WebElement iframe1;

	@FindBy(xpath = "/html/body/section/div/div/div/input")
	WebElement inputBox;

	@FindBy(xpath = "/html/body/header/div/div/div/div[2]/h1")
	WebElement webpageHeader;

	public void fillText(String value) throws InterruptedException {

		tabMultipleIframe.click();

		driver.switchTo().frame(iframe1);

		driver.switchTo().frame(0);

		inputBox.sendKeys(value);

		Thread.sleep(3000);

		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();

		tabSingleIframe.click();

		driver.switchTo().frame("singleframe");

		Thread.sleep(3000);

		inputBox.sendKeys(value);

		Thread.sleep(3000);

		driver.switchTo().defaultContent();

		System.out.println(webpageHeader.getText());

	}

}
