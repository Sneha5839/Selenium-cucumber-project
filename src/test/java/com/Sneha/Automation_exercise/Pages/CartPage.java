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

    @FindBy(xpath = "//li[contains(@class,'active') and contains(text(),'Shopping Cart')] | //div[@id='cart_info']")
    public WebElement cartHeading;

    // Products rows in cart
    @FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr[contains(@id,'product-')]")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;
    
    @FindBy(xpath = "//a[contains(@class,'check_out')]")
    public WebElement proceedToCheckoutButton;

    // Quantity column for the first cart item
    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    public WebElement firstCartItemQuantity;
}