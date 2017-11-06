package com.editor.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class ExamplePage {
	public ExamplePage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(id = "example")
	public WebElement webTable;

	@FindAll({ @FindBy(tagName = "tr") })
	public List<WebElement> rows;

	@FindBy(linkText = "New")
	public WebElement newButton;

	@FindBy(id = "DTE_Field_first_name")
	public WebElement firstName;

	@FindBy(id = "DTE_Field_last_name")
	public WebElement lastName;

	@FindBy(id = "DTE_Field_position")
	public WebElement position;

	@FindBy(id = "DTE_Field_office")
	public WebElement office;

	@FindBy(id = "DTE_Field_extn")
	public WebElement extension;

	@FindBy(id = "DTE_Field_start_date")
	public WebElement startDate;

	@FindBy(id = "DTE_Field_salary")
	public WebElement salary;

	@FindBy(className = "btn")
	public WebElement createButton;

}