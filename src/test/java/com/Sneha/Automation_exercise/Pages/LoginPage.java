package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountLabel;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    public WebElement loggedInAsLabel;
}