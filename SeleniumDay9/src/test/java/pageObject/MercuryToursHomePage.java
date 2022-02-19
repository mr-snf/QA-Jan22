package pageObject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Function;

public class MercuryToursHomePage {

	private WebDriver driver;

	public MercuryToursHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(tagName = "h3")
	WebElement labelLoginSuccess;

	public void verifyLogin(ExtentTest extentTest) {

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(labelLoginSuccess));

//		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(2));
//
//		WebElement labelSuccess = fwait.until(new Function<WebDriver, WebElement>() {
//
//			public WebElement apply(WebDriver input) {
//				return driver.findElement(By.tagName("h3"));
//			}
//		});

//		if (labelSuccess.isDisplayed()) {
//			extentTest.pass("Login successful!!");
//		} else {
//			extentTest.fail("Login failed!!");
//			String screenshotPath = capture("login");
//			extentTest.addScreenCaptureFromPath(screenshotPath);
//		}

		Wait<WebDriver> fwait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(2));

		fwait2.until(ExpectedConditions.visibilityOf(labelLoginSuccess));

		if (labelLoginSuccess.isDisplayed()) {
			extentTest.pass("Login successful!!");
		} else {
			extentTest.fail("Login failed!!");
			String screenshotPath = capture("login");
			extentTest.addScreenCaptureFromPath(screenshotPath);
		}
	}

	private String capture(String screenShotName) {
		TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

		File screenshotFolder = new File("reports");

		if (!screenshotFolder.exists() || !screenshotFolder.isDirectory()) {
			screenshotFolder.mkdirs();
		}

		File screenshot = new File(screenshotFolder, screenShotName + ".png");
		try {
			FileUtils.moveFile(screenshotDriver.getScreenshotAs(OutputType.FILE), screenshot);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshot.getAbsolutePath();
	}

}
