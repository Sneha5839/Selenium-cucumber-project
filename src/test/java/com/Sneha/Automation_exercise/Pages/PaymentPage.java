package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Sneha.Automation_exercise.utils.Driver;

public class PaymentPage {
    public PaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Name on Card
    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement nameOnCard;

    // Card Number
    @FindBy(xpath = "//input[@name='card_number']")
    public WebElement cardNumber;

    // CVC
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement cvc;

    // Expiration Month
    @FindBy(xpath = "//input[@name='expiry_month']")
    public WebElement expiryMonth;

    // Expiration Year
    @FindBy(xpath = "//input[@name='expiry_year']")
    public WebElement expiryYear;

    // Pay and Confirm Order button
    @FindBy(id = "submit")
    public WebElement payAndConfirmButton;

    // Order success message
    @FindBy(xpath = "//*[@data-qa='order-placed' or contains(text(),'Congratulations! Your order has been confirmed')]")
    public WebElement orderSuccessMessage;
}
