package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQA {

	WebDriver driver = null;

	public DemoQA(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "alertButton")
	WebElement btnAlert;

	@FindBy(id = "timerAlertButton")
	WebElement btnTimedAlert;

	@FindBy(id = "confirmButton")
	WebElement btnConfirmAlert;

	@FindBy(id = "promtButton")
	WebElement btnPromptAlert;

	public void simpleAlert() throws InterruptedException {
		btnAlert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}

	public void timedAlert() throws InterruptedException {
		btnTimedAlert.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}

	public void confirmAlert() throws InterruptedException {
		btnConfirmAlert.click();
		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

	}

	public void promptAlert() throws InterruptedException {
		btnPromptAlert.click();
		Thread.sleep(2000);

		driver.switchTo().alert().sendKeys("This is a test");

		driver.switchTo().alert().accept();

	}
}
