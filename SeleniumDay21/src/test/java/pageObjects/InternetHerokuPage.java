package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetHerokuPage {

	public InternetHerokuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
	WebElement chkbox1;

	@FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
	WebElement chkbox2;

	public void selectOptions() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.mouseMove(chkbox1.getLocation().getX(), chkbox1.getLocation().getY() + 95);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		Thread.sleep(2000);

		robot.mouseMove(chkbox2.getLocation().getX(), chkbox2.getLocation().getY() + 95);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		Thread.sleep(2000);
	}
}
