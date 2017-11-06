package com.fourstay.step_defitions;

import org.junit.Assert;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAcctPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class staytest_124_step_defs {
	HomePage loginPage = new HomePage();

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		loginPage.loginLink.click();
	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		Thread.sleep(2000);
		loginPage.email.sendKeys(email);
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String psw) throws Throwable {
		Thread.sleep(2000);
		loginPage.password.sendKeys(psw);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		loginPage.SigninButton.click();
	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String expextedName) throws Throwable {
		UserAcctPage userAcctPage = new UserAcctPage();
		BrowserUtilities.waitForPageLoad();
		String actulName = userAcctPage.acctHolderName.getText();
		// WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 500);
		// wait.until(ExpectedConditions.visibilityOf(userAcctPage.acctHolderName));
		Assert.assertEquals(expextedName, actulName);
	}

}
