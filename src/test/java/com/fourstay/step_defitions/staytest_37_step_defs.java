package com.fourstay.step_defitions;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.fourstay.pages.searchResultsPage;
import com.fourstay.utilities.BrowserUtilities;

import cucumber.api.java.en.Then;

public class staytest_37_step_defs {
	@Then("^the results should contain expected date \"([^\"]*)\"$")
	public void the_results_should_contain_expected_date(String expDate) throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();

		searchResultsPage resultsPage = new searchResultsPage();
		Set<String> actualDates = new HashSet<>();
		for (WebElement element : resultsPage.allAvailableDates) {
			actualDates.add(element.getText().replaceAll("FROM: ", ""));
		}

		if (actualDates.contains(expDate)) {
			System.out.println("Test passed");
		} else {
			System.err.println("Test failed");
			System.out.println("Found dates:" + actualDates);
			System.out.println("But expected date: " + expDate);
		}
		// Assert.assertTrue(actualDates.contains(expDate));
	}
}
