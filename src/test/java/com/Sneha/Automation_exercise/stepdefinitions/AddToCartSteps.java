package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.Sneha.Automation_exercise.Pages.ProductsPage;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

import com.Sneha.Automation_exercise.Pages.CartPage;

public class AddToCartSteps extends BaseTest {
    ProductsPage products = new ProductsPage();
    CartPage cart = new CartPage();

    @When("user clicks on Products link")
    public void user_clicks_on_products_link() {
        clickOnElement(products.productsLink, "Products link");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

    @Then("user adds the first product to cart")
    public void user_adds_the_first_product_to_cart() {
        // Wait for products to be visible
        waitForVisibility(products.productLinks.get(0));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        clickOnElement(products.addToCartButtons.get(0), "Add to cart first product");
        // If modal appears, click continue shopping or close — best effort
        /*try {
            // try clicking view cart if displayed in modal
            waitSleep(com.Sneha.Automation_exercise.utils.WaitTime.VERY_SHORT);
        } catch (Exception ignored) {}*/
        
        js.executeScript("window.scrollBy(0, 500);");
    }
    @Then("clicks on Continue Shopping button")
    public void clicks_on_continue_shopping_button() {
        // Write code here that turns the phrase above into concrete actions
    	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
       clickOnElement(cart.continueShoppingButton, "Continue Shopping button");
       js.executeScript("window.scrollBy(0, 500);");
    }

    @Then("user adds the second product to cart")
    public void user_adds_the_second_product_to_cart() {
        // Write code here that turns the phrase above into concrete actions
    	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        //waitForVisibility(products.productLinks.get(0));
        js.executeScript("window.scrollBy(0, 500);"); // Scroll down to ensure next products are in view
        hoverOverElement(products.productLinks.get(2), "Hover over second product");
        clickOnElement(products.addToCartButtons.get(2), "Add to cart second product");
    }

    

    @When("user clicks on View Cart")
    public void user_clicks_on_view_cart() {
        clickOnElement(products.viewCartLink, "View Cart link");
    }

    @Then("verify both the products are present in the cart")
    public void verify_the_product_is_present_in_the_cart() {
        assertTrue(isElementVisible(cart.cartHeading, "Cart heading"));
        assertTrue(cart.cartItems.size() > 0, "Expected at least one item in cart");
    }
}
