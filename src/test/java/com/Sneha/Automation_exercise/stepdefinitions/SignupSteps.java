package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

import com.Sneha.Automation_exercise.Pages.SignUppage;
import com.Sneha.Automation_exercise.utils.BrowserUtils.*;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;
public class SignupSteps extends BaseTest{
	 SignUppage signuppage=new SignUppage();
	 // store entered values to verify on the account info page
	 private String enteredName;
	 private String enteredEmail;
	 
	@Given("user navigates to the application")
	public void user_navigates_to_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		Driver.getDriver().get("https://automationexercise.com");
		logger.info("reached user navigates to the application");
		assertTrue(isElementVisible(signuppage.signup,"About signup link"));
	    //throw new io.cucumber.java.PendingException();
	}

	
	@When("user clicks on Signup\\/login link")
	public void user_clicks_on_signup_login_link() {
	    // Write code here that turns the phrase above into concrete actions
		clickOnElement(signuppage.signup,"Signup link");
	}


	@Then("verify New user signup! text is present")
	public void verify_new_user_signup_text_is_present() {
	    // Write code here that turns the phrase above into concrete actions
	   assertTrue(isElementVisible(signuppage.newusersignuplabel,"About New User Sign up label"));
	}

	@When("user enter {string} for name")
	public void user_enter_for_name(String string) {
	    // store the entered name and type into the field
		this.enteredName = string;
		sendKeys(signuppage.newusername,string,"user name");
	   
	}

	@When("user enters {string} for email")
	public void user_enters_for_email(String string) {
	    // store the entered email and type into the field
		this.enteredEmail = string;
		sendKeys(signuppage.newuseremail,string,"User email");
	}

	@Then("clicks Signup button")
	public void clicks_signup_button() {
	    // Write code here that turns the phrase above into concrete actions
	   clickOnElement(signuppage.signupbutton,"Sign up button");
	}

	@Then("Signup page is opened")
	public void signup_page_is_opened() {
	    // Write code here that turns the phrase above into concrete actions

	
	assertEquals(Driver.getDriver().getTitle(),"Automation Exercise - Signup");
	//System.out.println(Driver.getDriver().getTitle());
	logger.info("Signup page is opened and title is verified");	
	}

	@Then("verify Enter account information text is present")
	public void verify_enter_account_information_text_is_present() {
	    // Verify the 'Enter Account Information' label is visible
		assertTrue(isElementVisible(signuppage.getAccountInfoLabel(), "Account info label"));
	}
	@Then("user selects the Title")
	public void user_selects_the_title() {
	    // Select the 'Mr' title radio button and assert it's selected
		clickOnElement(signuppage.titleMr, "Title Mr radio");
		assertTrue(signuppage.titleMr.isSelected(), "Expected 'Mr' title to be selected");
	}
	@Then("verify name is present")
	public void verify_name_is_present() {
	    // Verify that the account name field is visible and matches the entered name
		assertTrue(isElementVisible(signuppage.accountName, "Account name field"));
		String actualName = signuppage.accountName.getAttribute("value");
		assertEquals(actualName, this.enteredName, "Account name should match the entered name");
	}
	@Then("verify email is present")
	public void verify_email_is_present() {
	    // Verify that the account email field is visible and matches the entered email
		assertTrue(isElementVisible(signuppage.accountEmail, "Account email field"));
		String actualEmail = signuppage.accountEmail.getAttribute("value");
		assertEquals(actualEmail, this.enteredEmail, "Account email should match the entered email");
	}
	@Then("enter the password")
	public void enter_the_password() {
	    // Enter a password into the password field
		sendKeys(signuppage.password, "Password123", "Account password");
	}
	@Then("select day month and year of date of birth")
	public void select_day_month_and_year_of_date_of_birth() {
	    // Select a day, month and year from the dropdowns. Use helper for dropdowns.
		// Choose day = 1 (index 1 — second option), month = January (index 1), year = 1990 (select by visible text)
		sendKeysToDropDownByIndex(signuppage.days, 1, "Day dropdown");
		sendKeysToDropDownByIndex(signuppage.months, 1, "Month dropdown");
		sendKeysToDropDownByValue(signuppage.years, "1990", "Year dropdown");
	}
	@Then("tick the checkbox signup for our newsletter")
	public void tick_the_checkbox_signup_for_our_newsletter() {
	    // Tick the newsletter checkbox if not already selected
		if(!signuppage.newsletter.isSelected()){
			clickOnElement(signuppage.newsletter, "Newsletter checkbox");
		}
	}

	@Then("tick the checkbox receive special offers from our partners")
	public void tick_the_checkbox_receive_special_offers_from_our_partners() {
		// Tick the offers checkbox if not selected
		if(!signuppage.offersCheckbox.isSelected()){
			clickOnElement(signuppage.offersCheckbox, "Offers checkbox");
		}
	}

	@When("user enters first name {string}")
	public void user_enters_first_name(String firstname) {
		// enter the provided first name
		sendKeys(signuppage.firstName, firstname, "First name");
	}

	@When("user enters last name {string}")
	public void user_enters_last_name(String lastname) {
		// enter the provided last name
		sendKeys(signuppage.lastName, lastname, "Last name");
	}

	@When("user enters company name {string}")
	public void user_enters_company_name(String company) {
		sendKeys(signuppage.company, company, "Company");
	}

	@When("user enters address {string}")
	public void user_enters_address(String address1) {
		sendKeys(signuppage.address1, address1, "Address1");
	}

	@When("user enters address2 {string}")
	public void user_enters_address2(String address2) {
		sendKeys(signuppage.address2, address2, "Address2");
	}

	@When("user enters country {string}")
	public void user_enters_country(String country) {
		// select a country by visible text
		sendKeysToDropDown(signuppage.country, country, "Country dropdown");
	}

	@When("user enters state {string}")
	public void user_enters_state(String state) {
		sendKeys(signuppage.state, state, "State");
	}

	@When("user enters city {string}")
	public void user_enters_city(String city) {
		sendKeys(signuppage.city, city, "City");
	}

	@When("user enters zipcode {string}")
	public void user_enters_zipcode(String zipcode) {
		sendKeys(signuppage.zipcode, zipcode, "Zipcode");
	}

	@When("user enters mobile number {string}")
	public void user_enters_mobile_number(String mobile) {
		sendKeys(signuppage.mobileNumber, mobile, "Mobile number");
	}

	@Then("clicks Create Account button")
	public void then_clicks_create_account_button() {
		clickOnElement(signuppage.createAccountButton, "Create Account button");
	}

	}