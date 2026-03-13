package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.Sneha.Automation_exercise.Pages.ContactUsPage;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

import java.nio.file.Path;

import org.openqa.selenium.Alert;

public class ContactUsSteps extends BaseTest {
    ContactUsPage contact = new ContactUsPage();

    @When("user clicks on Contact us link")
    public void user_clicks_on_contact_us_link() {
        clickOnElement(contact.contactUsLink, "Contact us link");
    }

    @Then("verify Get In Touch text is present")
    public void verify_get_in_touch_text_is_present() {
        assertTrue(isElementVisible(contact.getInTouchLabel, "Get In Touch label"));
    }

    @When("user enters name {string}")
    public void user_enters_name(String name) {
        sendKeys(contact.nameInput, name, "Contact name");
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        sendKeys(contact.emailInput, email, "Contact email");
    }

    @When("user enters subject {string}")
    public void user_enters_subject(String subject) {
        sendKeys(contact.subjectInput, subject, "Contact subject");
    }

    @When("user enters message {string}")
    public void user_enters_message(String message) {
        sendKeys(contact.messageInput, message, "Contact message");
    }

    @When("user uploads file {string}")
    public void user_uploads_file(String path) {
        // Resolve relative path to absolute to ensure upload works from project root
        String absolute = Path.of(path).toAbsolutePath().toString();
        contact.uploadFileInput.sendKeys(absolute);
    }

    @Then("clicks submit button")
    public void clicks_submit_button() {
        clickOnElement(contact.submitButton, "Submit button");
    }

    @Then("verify success message {string}")
    public void verify_success_message(String expected) {
    	
    	
    	Alert alert = Driver.getDriver().switchTo().alert();
    	 alert.accept(); // Accept the alert if it appears
    	 assertTrue(isElementVisible(contact.successMessage, "Success message"));
    }
        
      
}