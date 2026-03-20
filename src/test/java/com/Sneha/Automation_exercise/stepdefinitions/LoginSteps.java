package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.Sneha.Automation_exercise.Pages.LoginPage;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Then("verify Login to your account text is present")
    public void verify_login_to_your_account_text_is_present() {
        assertTrue(isElementVisible(loginPage.loginToYourAccountLabel, "Login label"));
    }

    @When("user enters existing email {string}")
    public void user_enters_existing_email(String email) {
      // Look up the dynamically generated email if this email was used for signup
      String actualEmail = SignupSteps.getDynamicEmail(email);
      sendKeys(loginPage.loginEmailInput, actualEmail, "Login email");
    }

    @When("user enters existing password {string}")
    public void user_enters_existing_password(String password) throws InterruptedException {
        sendKeys(loginPage.loginPasswordInput, password, "Login password");
        Thread.sleep(3000); // wait for password input to be processed
    }

    @Then("clicks login button")
    public void clicks_login_button() throws InterruptedException {
       clickOnElement(loginPage.loginButton, "Login button");
      //Thread.sleep(2000); // wait for login to process and page to update
      
       //clickOnElement(loginPage.loginButton, "Login button");
    }

    @Then("verify user is logged in as {string}")
    public void verify_user_is_logged_in_as(String username) {
        // Look up the dynamically generated name if this name was used for signup
        String actualUsername = SignupSteps.getDynamicName(username);
        assertTrue(isElementVisible(loginPage.loggedInAsLabel, "Logged in as label"));
        String text = getElementText(loginPage.loggedInAsLabel, "Logged in as label");
        assertTrue(text.contains(actualUsername), "Expected logged in username to contain: " + actualUsername + " but was: " + text);
    }
}