package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class SignUpExistingEmailPage {
    public SignUpExistingEmailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[text()='Email Address already exist!'] | //div[contains(text(),'already exist')]")
    public WebElement emailAlreadyExistsLabel;
}