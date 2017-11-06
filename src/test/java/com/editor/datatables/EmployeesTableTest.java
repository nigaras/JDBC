package com.editor.datatables;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class EmployeesTableTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("herokuUrl"));
	}

	@Test
	public void test() {
		// print rows in table1
		WebElement webTable1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = webTable1.findElements(By.tagName("tr"));
		System.out.println("Table 1 rows count: " + rows.size());

		// print rows in table2
		WebElement webTable2 = driver.findElement(By.id("table2"));
		List<WebElement> rows2 = webTable2.findElements(By.tagName("tr"));
		System.out.println("Table 2 rows count: " + rows2.size());

		List<WebElement> cells = rows.get(4).findElements(By.tagName("td"));
		System.out.println(cells.get(4).getText());
	}

	@Test
	public void loopWebtable() {
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			// System.out.println(row.getText());
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}
	}

	@Test
	public void loopWebtableXpath() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table2']//tr[1]/td"));
		System.out.println("Rows count: " + rows.size());
		System.out.println("Cells count: " + cells.size());

		for (int rowNum = 1; rowNum <= rows.size(); rowNum++) {
			for (int cellNum = 1; cellNum <= cells.size(); cellNum++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@id='table2']/tbody/tr[" + rowNum + "]/td[" + cellNum + "]"))
						.getText() + " | ");
			}
			System.out.println();
		}
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
