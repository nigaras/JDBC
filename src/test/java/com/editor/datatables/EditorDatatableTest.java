package com.editor.datatables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.editor.pages.ExamplePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditorDatatableTest {
	ExamplePage exPage = new ExamplePage();
	WebElement webTable = exPage.webTable;

	@Given("^I am on the aditor example page$")
	public void i_am_on_the_aditor_example_page() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("editorUrl"));
	}

	@Given("^Verify that headers siz and text\\.$")
	public void verify_that_headers_siz_and_text() throws Throwable {
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		List<WebElement> cells = rows.get(0).findElements(By.tagName("th"));
		// Verify cell size
		Assert.assertTrue(cells.size() == 6);
		// Verify headers text
		List<String> expTexts = Arrays.asList("Name", "Position", "Office", "Extn.", "Start date", "Salary");
		List<String> cellTexts = new ArrayList<>();
		for (WebElement cell : cells) {
			cellTexts.add(cell.getText());
		}
		Assert.assertTrue(expTexts.containsAll(cellTexts));
		// System.out.println(expTexts);
		// System.out.println(cellTexts);
	}

	@Then("^Find Bruno Nash in the table then verify that he is a Software Engineer and works in London$")
	public void find_Bruno_Nash_in_the_table_then_verify_that_he_is_a_Software_Engineer_and_works_in_London()
			throws Throwable {
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		String testPersonInfo = "";
		for (WebElement row : rows) {
			if (row.getText().contains(ConfigurationReader.getProperty("testName"))) {
				testPersonInfo = row.getText();
			}
		}
		Assert.assertTrue(testPersonInfo.contains(ConfigurationReader.getProperty("testPositionLocation")));
	}

	@When("^Print all webtable content in a similar looking format$")
	public void print_all_webtable_content_in_a_similar_looking_format() throws Throwable {
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
	}

	@When("^Add new Employee information$")
	public void add_new_Employee_information() throws Throwable {
		exPage.newButton.click();
		exPage.firstName.sendKeys(ConfigurationReader.getProperty("firstName"));
		exPage.lastName.sendKeys(ConfigurationReader.getProperty("lastName"));
		exPage.position.sendKeys(ConfigurationReader.getProperty("position"));
		exPage.office.sendKeys(ConfigurationReader.getProperty("office"));
		exPage.extension.sendKeys(ConfigurationReader.getProperty("extension"));
		exPage.startDate.sendKeys(ConfigurationReader.getProperty("startDate"));
		exPage.salary.sendKeys(ConfigurationReader.getProperty("salary"));
		exPage.createButton.click();
	}

	@Then("^Verify All data displayed in the webtable matched the data you entered in step (\\d+)\\.$")
	public void verify_All_data_displayed_in_the_webtable_matched_the_data_you_entered_in_step(int arg1)
			throws Throwable {
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		String addPersonInfo = "";
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 3000);
		// wait.until(ExpectedConditions.visibilityOf());
		for (WebElement row : rows) {
			if (row.getText().contains(ConfigurationReader.getProperty("addName"))) {
				addPersonInfo = row.getText();
			}
		}
		Assert.assertTrue(addPersonInfo.contains(ConfigurationReader.getProperty("addPersonInfo")));
		System.out.println("addName info: " + addPersonInfo);
	}

}
