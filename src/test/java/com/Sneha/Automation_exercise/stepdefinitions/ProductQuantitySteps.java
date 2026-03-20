package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import com.Sneha.Automation_exercise.Pages.ProductDetailsPage;
import com.Sneha.Automation_exercise.Pages.CartPage;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

public class ProductQuantitySteps extends BaseTest {

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

    @When("user clicks View Product for any product on home page")
    public void user_clicks_view_product_for_any_product_on_home_page() throws InterruptedException {
        // Wait for products to load on home page
        getWait().until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector("div.features_items")
        ));
        removeAds();
        Thread.sleep(1000);

        // Click the first "View Product" link on the home page
        WebElement viewProduct = Driver.getDriver().findElement(
            By.xpath("(//a[contains(@href,'product_details')])[1]")
        );
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", viewProduct);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", viewProduct);
    }

    @Then("verify product detail is opened")
    public void verify_product_detail_is_opened() {
        // Wait for the product detail page URL and content
        getWait().until(ExpectedConditions.urlContains("product_details"));
        removeAds();
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        getWait().until(ExpectedConditions.visibilityOf(detailsPage.productDetailsHeading));
        assertTrue(detailsPage.productDetailsHeading.isDisplayed(),
                "Product detail page should be displayed");
    }

    @When("user increases quantity to {string}")
    public void user_increases_quantity_to(String quantity) {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        WebElement quantityInput = detailsPage.quantityInput;
        // Clear the existing quantity and set the new value
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    @And("user clicks Add to Cart button on product detail page")
    public void user_clicks_add_to_cart_button_on_product_detail_page() throws InterruptedException {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        removeAds();
        Thread.sleep(500);
        js().executeScript("arguments[0].scrollIntoView({block: 'center'});", detailsPage.addToCartButton);
        Thread.sleep(500);
        js().executeScript("arguments[0].click();", detailsPage.addToCartButton);
    }

    @Then("user clicks View Cart link in success modal")
    public void user_clicks_view_cart_link_in_success_modal() {
        // The "View Cart" link appears in the modal after adding to cart
        WebElement viewCart = getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']"))
        );
        viewCart.click();
    }

    @Then("verify that product is displayed in cart page with exact quantity {string}")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity(String expectedQuantity) {
        // Wait for cart page to fully load including cart rows
        getWait().until(ExpectedConditions.urlContains("view_cart"));
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("cart_info_table")));
        removeAds();

        // Wait for at least one product row to appear in the cart table
        getWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(
            By.xpath("//table[@id='cart_info_table']//tbody/tr[contains(@id,'product-')]"), 0
        ));

        CartPage cartPage = new CartPage();
        assertTrue(cartPage.cartItems.size() > 0, "Expected at least 1 item in the cart");

        // Verify the quantity of the first item matches expected
        String actualQuantity = cartPage.firstCartItemQuantity.getText().trim();
        assertEquals(actualQuantity, expectedQuantity,
                "Expected quantity '" + expectedQuantity + "' but found '" + actualQuantity + "'");
    }
}
