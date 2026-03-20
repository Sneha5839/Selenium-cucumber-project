package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.Sneha.Automation_exercise.Pages.SignUppage;
import com.Sneha.Automation_exercise.Pages.SignUpExistingEmailPage;

public class SignUpExistingEmailSteps {

    SignUppage signup = new SignUppage();
    SignUpExistingEmailPage existing = new SignUpExistingEmailPage();

  

    @When("user enters existing signup email {string}")
    public void user_enters_existing_signup_email(String email) {
        // Use the email as-is without dynamic generation — this is for testing duplicate email
        sendKeys(signup.newuseremail, email, "Existing signup email");
    }

    @Then("message {string} is displayed")
    public void message_is_displayed(String expected) {
        assertTrue(isElementVisible(existing.emailAlreadyExistsLabel, "Email exists label"));
    }
}
