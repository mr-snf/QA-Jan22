package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechlisticPage {

	WebDriver driver;

	public TechlisticPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"customers\"]")
	WebElement table1;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article[1]/div/div/div[3]/div[1]/div[2]/table")
	WebElement table2;

	@FindBy(id = "customers")
	WebElement table;

	public void displayTable1() {
		System.out.println(table1.getText());
	}

	public void displayTable2() {
		System.out.println(table2.getText());
	}

	public void getChildren() {
		WebElement child = table.findElement(By.tagName("tbody"));
		System.out.println(child.getText());
		List<WebElement> children = child.findElements(By.tagName("tr"));

		System.out.println(children.size());

		List<WebElement> children2 = table.findElements(By.tagName("tr"));
		System.out.println(children2.size());
	}

	public void getImmediateChildren() {
		WebElement child = table.findElement(By.xpath("./*"));

		List<WebElement> children = table.findElements(By.xpath("./*"));
		System.out.println(children);
		System.out.println(children.size());

		List<WebElement> children2 = table.findElements(By.xpath("./tr"));
		System.out.println(children2);
		System.out.println(children2.size());

	}

	public void getAllChildren() {
		List<WebElement> children = table.findElements(By.cssSelector("*"));
		System.out.println(children.size());
		System.out.println(children);

//		for (WebElement el : children) {
//			System.out.println(el.getTagName());
//		}
	}

	public void getParent() {
		WebElement parent = table.findElement(By.xpath(".."));
		System.out.println(parent.getTagName());
		System.out.println(parent.getAttribute("dir"));
	}
}
