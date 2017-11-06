package com.herokuapp.tables;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class EmployeesTableTest {
	@BeforeClass
	public static void setUp() {
		Driver.getInstance().get(ConfigurationReader.getProperty("herokuUrl"));
	}

	@Test
	public void test() {
		WebElement webTable1 = Driver.getInstance().findElement(By.id("table1"));
		List<WebElement> rows = webTable1.findElements(By.tagName("tr"));
		System.out.println("WebTable 1 rows count: " + rows.size());

		WebElement webTable2 = Driver.getInstance().findElement(By.id("table2"));
		List<WebElement> rows2 = webTable2.findElements(By.tagName("tr"));
		System.out.println("WebTable 2 rows count: " + rows2.size());

		List<WebElement> cells = rows.get(0).findElements(By.tagName("th"));
		System.out.println(cells.get(0).getText());
		// table[@id='table1']/thead/tr/th[1]
		// table[@id='table1']//tr[1]/th[1]

		System.out.println(
				Driver.getInstance().findElement(By.xpath("//table[@id='table1']//tr[1]/th[1]" + "")).getText());
		// Driver.getInstance().quit();
	}

	@Test
	public void loopWebTables() {
		WebElement webTable1 = Driver.getInstance().findElement(By.id("table1"));
		// get all rows from table
		List<WebElement> rows = webTable1.findElements(By.tagName("tr"));
		System.out.println("WebTable 1 rows count: " + rows.size());

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
	public void loopTableXpath() {
		// List<WebElement> rowsInTable2 =
		// Driver.getInstance().findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		//
		// System.out.println("Number of rows in Table2: " + rowsInTable2.size());
		//
		// for (int rowNum = 0; rowNum < rowsInTable2.size(); rowNum++) {
		// System.out.println(Driver.getInstance()
		// .findElement(By.xpath("//table[@id='table2']/tbody/tr[" + (rowNum + 1) +
		// "]")).getText());
		// }

		for (int rowNum = 1; rowNum <= 4; rowNum++) {
			for (int cellNum = 1; cellNum <= 6; cellNum++) {
				String cellValue = Driver.getInstance()
						.findElement(By.xpath("//table[@id='table2']/tbody/tr[" + rowNum + "]/td[" + cellNum + "]"))
						.getText();
				System.out.print(cellValue + " | ");
			}
			System.out.println();

		}
	}

}
