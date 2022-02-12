package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalaryTaxCalculatorPage {

	WebDriver driver;

	public SalaryTaxCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "camount")
	WebElement inputSalaryAmount;

	@FindBy(id = "chours")
	WebElement inputHours;

	@FindBy(id = "cdays")
	WebElement inputDaysPerWeek;

	@FindBy(id = "cholidays")
	WebElement inputHolidays;

	@FindBy(id = "cvacation")
	WebElement inputVacation;

	@FindBy(xpath = "/html/body/div[3]/div[1]/table[1]/tbody/tr/td[1]/table/tbody/tr[6]/td/input[2]")
	WebElement btnCalculate;

	@FindBy(xpath = "//*[@id=\"footernav\"]/a[1]")
	WebElement linkAboutUs;

	public void calculateTax(String salary, String hours) {

		Actions actions = new Actions(driver);
		inputSalaryAmount.clear();
		actions.sendKeys(inputSalaryAmount, salary).build().perform();

		inputHours.clear();
		inputHours.sendKeys(hours);

		btnCalculate.click();
	}

	public void calculateTax2(String salary, String hours) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		inputSalaryAmount.clear();

		jse.executeScript("arguments[0].value='" + salary + "'", inputSalaryAmount);

		inputHours.clear();

		jse.executeScript("arguments[0].value='" + hours + "'", inputHours);

		jse.executeScript("arguments[0].click();", btnCalculate);

	}

	public void visitAboutUs() {

		Actions actions = new Actions(driver);
		actions.moveToElement(linkAboutUs).build().perform();
//		linkAboutUs.click();
	}

	public void visitAboutUs2() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", linkAboutUs);
	}

}
