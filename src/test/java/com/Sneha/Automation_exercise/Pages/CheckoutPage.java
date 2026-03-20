package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Sneha.Automation_exercise.utils.Driver;

public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Register / Login link in the checkout modal (when not logged in)
    @FindBy(xpath = "//u[text()='Register / Login']")
    public WebElement registerLoginLink;

    // Address details section heading
    @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
    public WebElement addressDetailsHeading;

    // Review Your Order section heading
    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    public WebElement reviewYourOrderHeading;

    // Comment text area
    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement commentTextArea;

    // Place Order button
    @FindBy(xpath = "//a[contains(@href,'payment') or contains(text(),'Place Order')]")
    public WebElement placeOrderButton;
}
