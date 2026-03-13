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

    @FindBy(xpath = "//button[contains(text(),'Add to cart') or contains(@class,'add-to-cart')]")
    public WebElement addToCartButton;
}