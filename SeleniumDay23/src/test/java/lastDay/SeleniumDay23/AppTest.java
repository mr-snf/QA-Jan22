package lastDay.SeleniumDay23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.TechlisticPage;
import pageObjects.ToolsQAPage;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private WebDriver driver;
	private ExtentSparkReporter extentReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	private String downloadFolder;

	private void chooseDriver(int value) {

		switch (value) {
		case 1:
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			downloadFolder = "D:\\download\\firefox";

			FirefoxProfile fprofile = new FirefoxProfile();

			fprofile.setPreference("browser.download.dir", downloadFolder);
			fprofile.setPreference("browser.download.folderList", 2);
			fprofile.setPreference("browser.download.manager.showWhenStarting", false);
			fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", "");

			FirefoxOptions firefox = new FirefoxOptions();
			firefox.setProfile(fprofile);

			driver = new FirefoxDriver(firefox);
			break;

		case 2:
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
			downloadFolder = "D:\\download\\edge";
			EdgeOptions edge = new EdgeOptions();

			Map<String, String> dwnldedge = new HashMap<String, String>();
			dwnldedge.put("download.default_directory", downloadFolder);
			edge.setExperimentalOption("prefs", dwnldedge);

			driver = new EdgeDriver(edge);
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			downloadFolder = "D:\\download\\chrome";
			ChromeOptions chrome = new ChromeOptions();

			Map<String, String> dwnld = new HashMap<String, String>();
			dwnld.put("download.default_directory", downloadFolder);
			chrome.setExperimentalOption("prefs", dwnld);

			driver = new ChromeDriver(chrome);
			break;
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {

		File dwnldFolder = new File("D://download");
		if (dwnldFolder.exists())
			FileUtils.deleteDirectory(dwnldFolder);

//		chooseDriver(1);
//		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}

	@BeforeClass
	public void setup() {
		File reportsFolder = new File("reports");

		if (!reportsFolder.exists() || !reportsFolder.isDirectory()) {
			reportsFolder.mkdirs();
		}

		File report = new File(reportsFolder, "ExtentReport.html");

		extentReporter = new ExtentSparkReporter(report);
		extentReporter.config().setDocumentTitle("Automation report");
		extentReporter.config().setReportName("Regression test");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentReporter);
		extentReports.setSystemInfo("Project", "Mercury");
		extentReports.setSystemInfo("Tester", "Sanish");
	}

	@AfterClass
	public void teardown() {
		extentReports.flush();
	}

	@Test
	public void readFromExcel1() throws InterruptedException {
		extentTest = extentReports.createTest("Reading data from excel");

		File excelToRead = new File("D:\\sanish\\QA III\\Eclipse-workspace\\SeleniumDay23\\data\\DataToRead.xlsx");
		FileInputStream in = null;
		Workbook excelWorkbook = null;

		String fullname, email, currentAddress, permanentAddress;

		try {
			in = new FileInputStream(excelToRead);
			excelWorkbook = new XSSFWorkbook(in);

			Sheet sheet = excelWorkbook.getSheet("Sheet1");
//		Sheet sheet = excelWorkbook.getSheetAt(0);

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				fullname = sheet.getRow(i).getCell(0).getStringCellValue();
				email = sheet.getRow(i).getCell(1).getStringCellValue();
				currentAddress = sheet.getRow(i).getCell(2).getStringCellValue();
				permanentAddress = sheet.getRow(i).getCell(3).getStringCellValue();

				chooseDriver(1);
				driver.manage().window().maximize();

				driver.get("https://demoqa.com/text-box");

				ToolsQAPage qa = new ToolsQAPage(driver);
				qa.fillForm(fullname, email, currentAddress, permanentAddress, extentTest);

				Thread.sleep(2000);

				driver.quit();
			}
			excelWorkbook.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readFromExcel2() throws InterruptedException {
		extentTest = extentReports.createTest("Reading data from excel");

		File excelToRead = new File("D:\\sanish\\QA III\\Eclipse-workspace\\SeleniumDay23\\data\\DataToRead.xlsx");
		FileInputStream in = null;
		Workbook excelWorkbook = null;

		String fullname, email, currentAddress, permanentAddress;

		try {
			in = new FileInputStream(excelToRead);
			excelWorkbook = new XSSFWorkbook(in);

			Sheet sheet = excelWorkbook.getSheetAt(1);

			Row row = sheet.getRow(0);

			for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {

				fullname = sheet.getRow(0).getCell(j).getStringCellValue();
				email = sheet.getRow(1).getCell(j).getStringCellValue();
				currentAddress = sheet.getRow(2).getCell(j).getStringCellValue();
				permanentAddress = sheet.getRow(3).getCell(j).getStringCellValue();

				chooseDriver(1);
				driver.manage().window().maximize();

				driver.get("https://demoqa.com/text-box");

				ToolsQAPage qa = new ToolsQAPage(driver);
				qa.fillForm(fullname, email, currentAddress, permanentAddress, extentTest);

				Thread.sleep(2000);

				driver.quit();
			}

			excelWorkbook.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeIntoExcel() {

		extentTest = extentReports.createTest("Writing data into excel");

		chooseDriver(3);
		driver.manage().window().maximize();

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

		TechlisticPage tlp = new TechlisticPage(driver);

		tlp.getTableComponents();

		driver.quit();

	}
}
