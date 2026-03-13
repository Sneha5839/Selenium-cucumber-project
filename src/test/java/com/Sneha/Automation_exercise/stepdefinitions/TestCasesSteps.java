package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.Sneha.Automation_exercise.Pages.TestCasesPage;

import Sneha.Automation_Exercise.BaseTest;

public class TestCasesSteps extends BaseTest {

    TestCasesPage page = new TestCasesPage();

    @When("user clicks on Test Cases link")
    public void user_clicks_on_test_cases_link() {
        clickOnElement(page.testCasesLink, "Test Cases link");
    }

    @Then("verify Test Cases page is opened and Test Cases text is present")
    public void verify_test_cases_page_is_opened_and_text_is_present() {
        assertTrue(isElementVisible(page.testCasesHeading, "Test Cases heading"));
    }
}
