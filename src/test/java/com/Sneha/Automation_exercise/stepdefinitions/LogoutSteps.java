package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import com.Sneha.Automation_exercise.Pages.LogoutPage;

import Sneha.Automation_Exercise.BaseTest;

import com.Sneha.Automation_exercise.Pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @When("user clicks on Logout link")
    public void user_clicks_on_logout_link() {
        clickOnElement(logoutPage.logoutLink, "Logout link");
    }

    @Then("verify user is logged out and Login to your account text is present")
    public void verify_user_is_logged_out_and_login_text_is_present() {
        assertTrue(isElementVisible(loginPage.loginToYourAccountLabel, "Login label"));
    }
}
