package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class ProductDetailsPage {
    public ProductDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Product Details') or contains(text(),'Product Details for')] | //div[@class='product-information']//h2")
    public WebElement productDetailsHeading;

    @FindBy(xpath = "//button[contains(@class,'cart')]")
    public WebElement addToCartButton;

    // Quantity input on product detail page
    @FindBy(id = "quantity")
    public WebElement quantityInput;

    // View Cart link in the success modal after adding to cart
    @FindBy(xpath = "//u[text()='View Cart']")
    public WebElement viewCartLink;
}