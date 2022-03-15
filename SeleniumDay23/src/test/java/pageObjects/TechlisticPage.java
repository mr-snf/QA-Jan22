package pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechlisticPage {

	public TechlisticPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "tsc_table_s13")
	WebElement webTable2;

	@FindBy(id = "customers")
	WebElement webTable1;

	public void getTableComponents() {

		File fileToWrite = new File("D:\\sanish\\QA III\\Eclipse-workspace\\SeleniumDay23\\data\\DataWritten.xlsx");
		try {
			FileOutputStream out = new FileOutputStream(fileToWrite);

			Workbook excelToWrite = new XSSFWorkbook();

			Sheet excelSheet = excelToWrite.createSheet("data");

			List<WebElement> webTableParts = webTable2.findElements(By.xpath("./*"));

			int excelRowCount = 0;

			for (WebElement tablePart : webTableParts) {
				List<WebElement> webTableRows = tablePart.findElements(By.xpath("./*"));

				for (WebElement tableRow : webTableRows) {
					List<WebElement> webTableCells = tableRow.findElements(By.xpath("./*"));

					Row excelRow = excelSheet.createRow(excelRowCount++);

					int excelColumnCount = 0;

					for (WebElement tableCell : webTableCells) {

						Cell excelCell = excelRow.createCell(excelColumnCount++);

						excelCell.setCellValue(tableCell.getText());
					}
				}
			}

			excelToWrite.write(out);
			out.close();
			excelToWrite.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
