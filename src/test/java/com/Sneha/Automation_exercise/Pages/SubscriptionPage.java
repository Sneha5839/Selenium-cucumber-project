package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Sneha.Automation_exercise.utils.Driver;

public class SubscriptionPage {
    public SubscriptionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Cart button in navbar
    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    public WebElement cartNavLink;

    // Footer subscription heading
    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    public WebElement subscriptionHeading;

    // Subscription email input field
    @FindBy(id = "susbscribe_email")
    public WebElement subscriptionEmailInput;

    // Subscription arrow button
    @FindBy(id = "subscribe")
    public WebElement subscribeButton;

    // Success message after subscribing
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    public WebElement successMessage;
}
