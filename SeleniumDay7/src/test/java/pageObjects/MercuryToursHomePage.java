package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class MercuryToursHomePage {

	private WebDriver driver;

	public MercuryToursHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(tagName = "h3")
	WebElement labelLoginSuccess;

	public void verifyLogin(ExtentTest extentTest) {
		String actual = "https://demo.guru99.com/test/newtours/login_sucess.php";
		String url = driver.getCurrentUrl();

		if (actual.equals(url) && labelLoginSuccess.isDisplayed()) {
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
