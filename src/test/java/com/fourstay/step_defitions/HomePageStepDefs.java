package com.fourstay.step_defitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
		Driver.getInstance().get("http://fourstay.herokuapp.com/");

	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
		Driver.getInstance().findElement(By.cssSelector(".not-login")).click();
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		System.out.println("Email field is now displayed");
		Assert.assertTrue(Driver.getInstance().findElement(By.id("email")).isDisplayed());

	}

}
