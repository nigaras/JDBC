package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class searchResultsPage {
	public searchResultsPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".col-md-12>p")
	public List<WebElement> allStates; // == driver.findElements(by.css...)

	@FindBy(xpath = "//span[@class='ng-binding']")
	public List<WebElement> allAvailableDates;
}
