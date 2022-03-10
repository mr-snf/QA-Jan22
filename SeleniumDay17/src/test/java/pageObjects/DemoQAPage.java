package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAPage {

	WebDriver driver;

	public DemoQAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "frame1")
	WebElement iframe1;

	@FindBy(id = "sampleHeading")
	WebElement headerIframe1;

	@FindBy(id = "frame2")
	WebElement iframe2;

	public void switchToIframe1() {

//		driver.switchTo().frame(iframe1);

//		driver.switchTo().frame("frame1");

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame(2);

		System.out.println(headerIframe1.getText());
	}

}
