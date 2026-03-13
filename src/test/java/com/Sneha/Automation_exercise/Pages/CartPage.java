package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import com.Sneha.Automation_exercise.utils.Driver;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Shopping Cart'] | //h2[contains(text(),'Cart')]")
    public WebElement cartHeading;

    // Products rows in cart
    @FindBy(xpath = "//tr[contains(@id,'cart_item') or contains(@class,'cart_item')]")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;
    
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    public WebElement proceedToCheckoutButton;
}