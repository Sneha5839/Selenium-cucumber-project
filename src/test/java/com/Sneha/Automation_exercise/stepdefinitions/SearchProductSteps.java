package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.Sneha.Automation_exercise.Pages.ProductsPage;
import com.Sneha.Automation_exercise.utils.Driver;

import Sneha.Automation_Exercise.BaseTest;

public class SearchProductSteps extends BaseTest {

    ProductsPage products = new ProductsPage();

    @Then("verify user is navigated to ALL PRODUCTS page")
    public void verify_user_is_navigated_to_all_products_page() throws InterruptedException {
        // Verify URL contains /products
    	Thread.sleep(2000); // Short sleep to ensure page is fully loaded before assertions
        assertTrue(Driver.getDriver().getCurrentUrl().contains("/products"),
                "Expected to be on the products page");
        // Verify product list is visible
        assertTrue(products.productLinks.size() > 0,
                "Expected product list to contain items");
        // Remove ads
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript(
            "const ads = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate');" +
            "while (ads.length > 0) ads[0].remove();" +
            "document.querySelectorAll('iframe[id^=\"aswift\"], iframe[id^=\"google_ads\"]').forEach(f => f.remove());"
        );
    }

    @When("user enters product name {string} in search input and clicks search button")
    public void user_enters_product_name_in_search_input_and_clicks_search_button(String productName) {
        sendKeys(products.searchInput, productName, "Search input");
        clickOnElement(products.searchButton, "Search button");
    }

    @Then("verify SEARCHED PRODUCTS heading is visible")
    public void verify_searched_products_heading_is_visible() {
        assertTrue(isElementVisible(products.searchedProductsHeading, "Searched Products heading"),
                "Expected 'SEARCHED PRODUCTS' heading to be visible");
    }

    @Then("verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() throws InterruptedException {
        assertTrue(products.searchedProducts.size() > 0,
                "Expected at least one product in search results");
        // Verify each search result product is displayed
        for (WebElement product : products.searchedProducts) {
        	Thread.sleep(1000); // Short sleep to ensure product elements are fully rendered
            assertTrue(product.isDisplayed(),
                    "Expected each searched product to be visible");
        }
    }
}
