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

  

    @Then("message {string} is displayed")
    public void message_is_displayed(String expected) {
        assertTrue(isElementVisible(existing.emailAlreadyExistsLabel, "Email exists label"));
    }
}
