package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class UserAcctPage {
	public UserAcctPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".user-name")
	// xpath = "//h3[@class='user-name ng-binding']")
	public WebElement acctHolderName;
}
