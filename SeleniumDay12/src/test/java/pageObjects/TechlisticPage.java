package pageObjects;

import java.util.List;

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
		List<WebElement> webTableParts = webTable2.findElements(By.xpath("./*"));

		for (WebElement tablePart : webTableParts) {
			List<WebElement> webTableRows = tablePart.findElements(By.xpath("./*"));

			for (WebElement tableRow : webTableRows) {
				List<WebElement> webTableCells = tableRow.findElements(By.xpath("./*"));

				for (WebElement tableCell : webTableCells) {

					System.out.print(tableCell.getText());

					System.out.print("\t");
				}

				System.out.println("\n");
			}

			System.out.println("\n\n");
		}

	}

}
