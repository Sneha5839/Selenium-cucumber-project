package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class LogoutPage {

    public LogoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Logout'] | //a[text()='Logout']")
    public WebElement logoutLink;

}
