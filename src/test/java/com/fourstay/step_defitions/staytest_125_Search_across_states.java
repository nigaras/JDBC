package com.fourstay.step_defitions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.searchResultsPage;
import com.fourstay.utilities.BrowserUtilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class staytest_125_Search_across_states {
	HomePage homePage = new HomePage();

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String schoolName) throws Throwable {
		homePage.schoolName.sendKeys(schoolName);
	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String startDate, String endDate) throws Throwable {
		homePage.startDate.sendKeys(startDate);
		homePage.endDate.sendKeys(endDate);
		Thread.sleep(3000);
	}

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		homePage.search.click();
		Thread.sleep(3000);
		// Assert.fail();
	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();

		searchResultsPage resultsPage = new searchResultsPage();
		Set<String> actualStates = new HashSet<>();
		for (WebElement element : resultsPage.allStates) {
			actualStates.add(element.getText());
		}
		System.out.println(actualStates);
		Assert.assertTrue(actualStates.containsAll(states));
	}

	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
		Map<String, String> input = searchCriteria.get(0);
		homePage.schoolName.sendKeys(input.get("school"));
		homePage.startDate.sendKeys(input.get("start"));
		homePage.endDate.sendKeys(input.get("end"));
		homePage.search.click();
	}

}
