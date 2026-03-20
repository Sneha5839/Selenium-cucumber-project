package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Sneha.Automation_exercise.utils.Driver;

public class AccountCreatedPage {
    public AccountCreatedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // ACCOUNT CREATED! heading
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedHeading;

    // Continue button after account creation
    @FindBy(xpath = "//a[contains(@data-qa,'continue-button') or (contains(text(),'Continue'))]")
    public WebElement continueButton;

    // Delete Account link in navbar
    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    public WebElement deleteAccountLink;

    // ACCOUNT DELETED! heading
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement accountDeletedHeading;

    // Continue button after account deletion
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement deleteContinueButton;
}
