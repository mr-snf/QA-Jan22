package pageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class InternetDownloadPage {

	WebDriver driver;

	public InternetDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[2]/div/div/a[1]")
	WebElement linkDwnld1;

	@FindBy(xpath = "/html/body/div[2]/div/div/a[2]")
	WebElement linkDwnld2;

	public void download(ExtentTest extentTest, String downloadFolder) {
		extentTest.info("downloading file " + linkDwnld1.getText());
		linkDwnld1.click();

		waitForDwnld(extentTest, downloadFolder, linkDwnld1.getText());

		extentTest.info("downloading file " + linkDwnld2.getText());
		linkDwnld2.click();

		waitForDwnld(extentTest, downloadFolder, linkDwnld2.getText());

	}

	private void waitForDwnld(ExtentTest extentTest, String downloadFolder, String fileName) {
		int count = 0, defaultWaitTime = 40;
		File downloadLocation = new File(downloadFolder);

		try {
			outerLoop: while (count < defaultWaitTime) {
				Thread.sleep(500);

				File[] files = downloadLocation.listFiles();

				for (File file : files) {

					if (file.getName().equals(linkDwnld1.getText())) {
						extentTest.pass("File " + fileName + " downloaded successfully!");
						break outerLoop;
					}
				}
				count++;

				if (count >= defaultWaitTime)
					extentTest.fail("File download failed!!");
			}
		} catch (Exception e) {
			System.err.println("error occurred!");
			extentTest.fail("Error occured " + e.getMessage());
		}
	}

}
