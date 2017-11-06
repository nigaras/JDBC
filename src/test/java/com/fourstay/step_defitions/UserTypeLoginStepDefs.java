package com.fourstay.step_defitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.UserAcctPage;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTypeLoginStepDefs {
	private WebDriver driver;

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		driver = Driver.getInstance();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		HomePage loginPage = new HomePage();
		loginPage.loginLink.click();
		loginPage.email.sendKeys(ConfigurationReader.getProperty("host.username"));
		loginPage.password.sendKeys(ConfigurationReader.getProperty("host.password"));
		loginPage.SigninButton.click();
	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
		UserAcctPage host = new UserAcctPage();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(host.acctHolderName));
		System.out.println(host.acctHolderName.getText());

	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		// System.out.println("a");
	}

	public void tearDown() {
		driver.quit();
	}
}
