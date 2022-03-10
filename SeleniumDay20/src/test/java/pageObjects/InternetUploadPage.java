package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class InternetUploadPage {

	public InternetUploadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "file-upload")
	WebElement inputFile;

	@FindBy(id = "file-submit")
	WebElement btnSubmit;

	public void uploadFile(ExtentTest extentTest, String fileLocation) {

		extentTest.info("Uploading file " + fileLocation);
		inputFile.sendKeys(fileLocation);
		btnSubmit.click();
	}

}
