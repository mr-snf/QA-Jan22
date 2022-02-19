package pageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class WebDriverUniPage {

	WebDriver driver;

	public WebDriverUniPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "plus-icon")
	WebElement btnAddToDo;

	@FindBy(xpath = "/html/body/div/input")
	WebElement inputToDo;

	@FindBy(xpath = "/html/body/div/ul")
	WebElement listToDo;

	public void addToDo(String todo, ExtentTest test) {

		btnAddToDo.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		test.info("Clicked on add");
		inputToDo.sendKeys(todo + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		test.info("Added a new todo '" + todo + "'");

		if (listToDo.getText().contains(todo)) {
			test.pass("New todo is added successfully");
		} else {
			test.fail("Todo addition failed!!");
		}
	}

	public void addToDo2(String todo, ExtentTest test) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		wait.until(ExpectedConditions.elementToBeClickable(btnAddToDo));
		wait.until(ExpectedConditions.visibilityOf(btnAddToDo));
//		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(btnAddToDo),ExpectedConditions.visibilityOf(btnAddToDo)));

		btnAddToDo.click();
		wait.until(ExpectedConditions.visibilityOf(inputToDo));
		test.info("Clicked on add");
		inputToDo.sendKeys(todo + Keys.ENTER);

		wait.until(ExpectedConditions.textToBePresentInElement(listToDo, todo));

		test.info("Added a new todo '" + todo + "'");

		if (listToDo.getText().contains(todo)) {
			test.pass("New todo is added successfully");
		} else {
			test.fail("Todo addition failed!!");
		}
	}
}
