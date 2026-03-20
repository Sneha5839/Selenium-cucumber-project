package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.Sneha.Automation_exercise.utils.Driver;

public class AddToCartSteps {

    /** Fresh WebDriverWait each call — never holds stale state */
    private WebDriverWait getWait() {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) Driver.getDriver();
    }

    /** Remove ad overlays & iframes that can intercept clicks */
    private void removeAds() {
        js().executeScript(
            "const ads = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate');" +
            "while (ads.length > 0) ads[0].remove();" +
            "document.querySelectorAll('iframe[id^=\"aswift\"], iframe[id^=\"google_ads\"]').forEach(f => f.remove());"
        );
    }

    @When("user clicks on Products link")
    public void user_clicks_on_products_link() {
        WebElement productsLink = getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Products')]"))
        );
        productsLink.click();
    }

    @Then("user adds the first product to cart")
    public void user_adds_the_first_product_to_cart() throws InterruptedException {
        // Wait for products page to fully load
        getWait().until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector("div.features_items")
        ));
        removeAds();
        Thread.sleep(1000);

        // Locate the first product's Add to Cart button fresh, scroll into view, JS click
        WebElement firstAddToCart = Driver.getDriver().findElement(
            By.cssSelector("a.btn.add-to-cart[data-product-id='1']")
        );
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", firstAddToCart);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", firstAddToCart);
    }

    @Then("clicks on Continue Shopping button")
    public void clicks_on_continue_shopping_button() throws InterruptedException {
        // Wait for the modal to appear and button to be clickable (fresh locate — never stale)
        WebElement continueBtn = getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue Shopping')]"))
        );
        continueBtn.click();
        Thread.sleep(1000);
    }

    @Then("user adds the second product to cart")
    public void user_adds_the_second_product_to_cart() throws InterruptedException {
        removeAds();
        Thread.sleep(500);

        // Locate the second product's Add to Cart button fresh, scroll into view, JS click
        WebElement secondAddToCart = Driver.getDriver().findElement(
            By.cssSelector("a.btn.add-to-cart[data-product-id='2']")
        );
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", secondAddToCart);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", secondAddToCart);
    }

    @When("user clicks on View Cart")
    public void user_clicks_on_view_cart() {
        // The "View Cart" link appears in the modal after adding to cart
        WebElement viewCart = getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']"))
        );
        viewCart.click();
    }

    @Then("verify both the products are present in the cart")
    public void verify_the_product_is_present_in_the_cart() {
        // Wait for cart page to load
        getWait().until(ExpectedConditions.urlContains("view_cart"));
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("cart_info_table")));

        List<WebElement> cartItems = Driver.getDriver().findElements(
            By.cssSelector("#cart_info_table tbody tr")
        );
        assertTrue(cartItems.size() >= 2, "Expected at least 2 items in cart but found " + cartItems.size());
    }
}