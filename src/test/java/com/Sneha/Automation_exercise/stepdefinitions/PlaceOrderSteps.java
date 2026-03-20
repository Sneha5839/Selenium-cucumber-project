package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import com.Sneha.Automation_exercise.Pages.CartPage;
import com.Sneha.Automation_exercise.Pages.CheckoutPage;
import com.Sneha.Automation_exercise.Pages.PaymentPage;
import com.Sneha.Automation_exercise.Pages.AccountCreatedPage;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

public class PlaceOrderSteps extends BaseTest {

    private WebDriverWait getWait() {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) Driver.getDriver();
    }

    private void removeAds() {
        js().executeScript(
            "const ads = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate');" +
            "while (ads.length > 0) ads[0].remove();" +
            "document.querySelectorAll('iframe[id^=\"aswift\"], iframe[id^=\"google_ads\"]').forEach(f => f.remove());"
        );
    }

    @Then("verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        getWait().until(ExpectedConditions.urlContains("view_cart"));
        removeAds();
        CartPage cartPage = new CartPage();
        assertTrue(isElementVisible(cartPage.cartHeading, "Shopping Cart heading"),
                "Cart page should be displayed");
    }

    @When("user clicks Proceed To Checkout")
    public void user_clicks_proceed_to_checkout() throws InterruptedException {
        removeAds();
        Thread.sleep(1000);
        CartPage cartPage = new CartPage();
        getWait().until(ExpectedConditions.elementToBeClickable(cartPage.proceedToCheckoutButton));
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", cartPage.proceedToCheckoutButton);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", cartPage.proceedToCheckoutButton);
    }

    @Then("user clicks Register Login button on checkout modal")
    public void user_clicks_register_login_button_on_checkout_modal() {
        // The Register / Login link appears in a modal when user is not logged in
        WebElement registerLogin = getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='Register / Login']"))
        );
        registerLogin.click();
    }

    @Then("verify ACCOUNT CREATED and click Continue button")
    public void verify_account_created_and_click_continue_button() throws InterruptedException {
        removeAds();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
        getWait().until(ExpectedConditions.visibilityOf(accountCreatedPage.accountCreatedHeading));
        assertTrue(accountCreatedPage.accountCreatedHeading.isDisplayed(),
                "ACCOUNT CREATED! heading should be visible");
        Thread.sleep(1000);
        removeAds();
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", accountCreatedPage.continueButton);
        js().executeScript("arguments[0].click();", accountCreatedPage.continueButton);
    }

    @Then("user clicks Proceed To Checkout button")
    public void user_clicks_proceed_to_checkout_button() throws InterruptedException {
        getWait().until(ExpectedConditions.urlContains("view_cart"));
        removeAds();
        Thread.sleep(1000);
        CartPage cartPage = new CartPage();
        getWait().until(ExpectedConditions.elementToBeClickable(cartPage.proceedToCheckoutButton));
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", cartPage.proceedToCheckoutButton);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", cartPage.proceedToCheckoutButton);
    }

    @Then("verify Address Details and Review Your Order section")
    public void verify_address_details_and_review_your_order_section() {
        removeAds();
        CheckoutPage checkoutPage = new CheckoutPage();
        getWait().until(ExpectedConditions.visibilityOf(checkoutPage.addressDetailsHeading));
        assertTrue(checkoutPage.addressDetailsHeading.isDisplayed(),
                "Address Details heading should be visible");
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", checkoutPage.reviewYourOrderHeading);
        assertTrue(checkoutPage.reviewYourOrderHeading.isDisplayed(),
                "Review Your Order heading should be visible");
    }

    @When("user enters description in comment area {string}")
    public void user_enters_description_in_comment_area(String comment) {
        CheckoutPage checkoutPage = new CheckoutPage();
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", checkoutPage.commentTextArea);
        sendKeys(checkoutPage.commentTextArea, comment, "Comment text area");
    }

    @And("user clicks Place Order button")
    public void user_clicks_place_order_button() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", checkoutPage.placeOrderButton);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", checkoutPage.placeOrderButton);
    }

    @Then("user enters payment details name {string} card number {string} cvc {string} expiry month {string} expiry year {string}")
    public void user_enters_payment_details(String name, String cardNum, String cvcVal, String month, String year) {
        removeAds();
        PaymentPage paymentPage = new PaymentPage();
        getWait().until(ExpectedConditions.visibilityOf(paymentPage.nameOnCard));
        sendKeys(paymentPage.nameOnCard, name, "Name on Card");
        sendKeys(paymentPage.cardNumber, cardNum, "Card Number");
        sendKeys(paymentPage.cvc, cvcVal, "CVC");
        sendKeys(paymentPage.expiryMonth, month, "Expiry Month");
        sendKeys(paymentPage.expiryYear, year, "Expiry Year");
    }

    @And("user clicks Pay and Confirm Order button")
    public void user_clicks_pay_and_confirm_order_button() throws InterruptedException {
        PaymentPage paymentPage = new PaymentPage();
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", paymentPage.payAndConfirmButton);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", paymentPage.payAndConfirmButton);
    }

    @Then("verify order success message {string}")
    public void verify_order_success_message(String expectedMessage) {
        // Wait for the order confirmation page to load
        getWait().until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//*[@data-qa='order-placed' or contains(text(),'Congratulations! Your order has been confirmed')]")
        ));
        removeAds();
        PaymentPage paymentPage = new PaymentPage();
        assertTrue(paymentPage.orderSuccessMessage.isDisplayed(),
                "Order success message should be visible");
        String actualMessage = paymentPage.orderSuccessMessage.getText().trim().toLowerCase();
        assertTrue(actualMessage.contains(expectedMessage.toLowerCase()),
                "Expected order success message: '" + expectedMessage + "' but got: '" + actualMessage + "'");
    }

    @When("user clicks Delete Account button")
    public void user_clicks_delete_account_button() throws InterruptedException {
        removeAds();
        AccountCreatedPage accountPage = new AccountCreatedPage();
        getWait().until(ExpectedConditions.elementToBeClickable(accountPage.deleteAccountLink));
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", accountPage.deleteAccountLink);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", accountPage.deleteAccountLink);
    }

    @Then("verify ACCOUNT DELETED and click Continue button")
    public void verify_account_deleted_and_click_continue_button() throws InterruptedException {
        removeAds();
        AccountCreatedPage accountPage = new AccountCreatedPage();
        getWait().until(ExpectedConditions.visibilityOf(accountPage.accountDeletedHeading));
        assertTrue(accountPage.accountDeletedHeading.isDisplayed(),
                "ACCOUNT DELETED! heading should be visible");
        Thread.sleep(1000);
        removeAds();
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", accountPage.deleteContinueButton);
        js().executeScript("arguments[0].click();", accountPage.deleteContinueButton);
    }
}
