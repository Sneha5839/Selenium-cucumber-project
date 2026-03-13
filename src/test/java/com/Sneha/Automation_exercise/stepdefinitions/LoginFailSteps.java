package com.Sneha.Automation_exercise.stepdefinitions;

import io.cucumber.java.en.Then;
import com.Sneha.Automation_exercise.Pages.LoginFailPage;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;
import com.Sneha.Automation_exercise.utils.Driver;
import static org.testng.Assert.assertTrue;
import Sneha.Automation_Exercise.BaseTest;

import io.cucumber.java.en.When;
public class LoginFailSteps extends BaseTest {
	LoginFailPage loginFail = new LoginFailPage();

	@Then("error message {string} is displayed")
	public void error_message_is_displayed(String string) {
		assertTrue(isElementVisible(loginFail.loginFailLabel, "Login fail label"));
	  
	}

}
