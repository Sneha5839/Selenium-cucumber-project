package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import com.Sneha.Automation_exercise.Pages.SubscriptionPage;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

import org.openqa.selenium.JavascriptExecutor;

public class SubscriptionSteps extends BaseTest {
    SubscriptionPage subscriptionPage = new SubscriptionPage();

    @When("user scrolls down to footer")
    public void user_scrolls_down_to_footer() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("user clicks on Cart button")
    public void user_clicks_on_cart_button() {
        clickOnElement(subscriptionPage.cartNavLink, "Cart navigation link");
    }

    @Then("verify text SUBSCRIPTION is visible")
    public void verify_text_subscription_is_visible() {
        assertTrue(isElementVisible(subscriptionPage.subscriptionHeading, "Subscription heading"),
                "SUBSCRIPTION heading should be visible in the footer");
    }

    @When("user enters email address {string} in subscription input")
    public void user_enters_email_address_in_subscription_input(String email) throws InterruptedException {
        sendKeys(subscriptionPage.subscriptionEmailInput, email, "Subscription email input");
        Thread.sleep(4000); // Short sleep to ensure input is processed before clicking subscribe
    }

    @And("user clicks the subscription arrow button")
    public void user_clicks_the_subscription_arrow_button() throws InterruptedException {
        clickOnElement(subscriptionPage.subscribeButton, "Subscribe button");
        //Thread.sleep(2000); // Short sleep to allow time for subscription processing and success message to appear
    }

    @Then("verify success message {string} is visible")
    public void verify_success_message_is_visible(String expectedMessage) {
        assertTrue(isElementVisible(subscriptionPage.successMessage, "Subscription success message"),
                "Success message should be visible after subscribing");
        String actualMessage = getElementText(subscriptionPage.successMessage, "Subscription success message");
        assertTrue(actualMessage.contains(expectedMessage),
                "Expected success message: '" + expectedMessage + "' but got: '" + actualMessage + "'");
    }
}
