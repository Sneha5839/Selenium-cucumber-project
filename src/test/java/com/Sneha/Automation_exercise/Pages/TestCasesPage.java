package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class TestCasesPage {
    public TestCasesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Test Cases'] | //a[text()='Test Cases']")
    public WebElement testCasesLink;

    @FindBy(xpath = "//b[text()='Test Cases']")
    public WebElement testCasesHeading;
}