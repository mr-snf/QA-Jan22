package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsQA {

	WebDriver driver;

	public ToolsQA(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "draggable")
	WebElement draggable;

	@FindBy(id = "droppable")
	WebElement droppable;

	public void dragAndDrop() {
		Actions act = new Actions(driver);

		act.clickAndHold(draggable);
		act.moveToElement(droppable);
		act.release(draggable);
		act.build().perform();
	}

	public void dragAndDrop2() {
		Actions act = new Actions(driver);
		act.dragAndDrop(draggable, droppable).build().perform();
	}
}
