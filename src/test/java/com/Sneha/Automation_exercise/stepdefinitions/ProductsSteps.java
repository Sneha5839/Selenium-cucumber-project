package com.Sneha.Automation_exercise.stepdefinitions;

import static org.testng.Assert.assertTrue;
import static com.Sneha.Automation_exercise.utils.BrowserUtils.*;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.Sneha.Automation_exercise.Pages.ProductsPage;
import com.Sneha.Automation_exercise.Pages.ProductDetailsPage;
import com.Sneha.Automation_exercise.utils.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsSteps {
    ProductsPage products = new ProductsPage();
    ProductDetailsPage details = new ProductDetailsPage();

    @Then("verify that the home page is visible successfully")
    public void verify_that_the_home_page_is_visible_successfully() throws InterruptedException {
        // Collect main header/nav/footer links that indicate homepage is loaded
        List<WebElement> links = Driver.getDriver().findElements(By.xpath("//header//a | //nav//a | //footer//a"));
        assertTrue(links.size() > 0, "Expected to find navigation links on the home page");

        for (WebElement link : links) {
            // Use existing utility which waits for visibility
            boolean visible = false;
            try {
                visible = isElementVisible(link);
            } catch (Exception e) {
                visible = false;
            }
            String text = "[no-text]";
            try { text = link.getText().trim(); } catch (Exception ignored) {}
            try {
                assertTrue(visible, "Expected link to be visible: " + (text.isEmpty() ? link.getAttribute("href") : text));
            } catch (AssertionError ae) {
                // Re-throw with more context
                throw new AssertionError("Home page visibility check failed for link: " + (text.isEmpty() ? link.getAttribute("href") : text), ae);
            }
            
        }
        Thread.sleep(3000); // Short sleep to ensure page is fully loaded before next steps
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

    @Then("verify products list is visible")
    public void verify_products_list_is_visible() {
        assertTrue(products.productLinks.size() > 0, "Expected product list to contain items");
    }

    @When("user opens the first product details")
    public void user_opens_first_product_details() {
        clickOnElement(products.productLinks.get(0), "First product link");
    }

    @Then("verify product details page is displayed")
    public void verify_product_details_page_is_displayed() {
        assertTrue(isElementVisible(details.productDetailsHeading, "Product Details heading"));
    }
}