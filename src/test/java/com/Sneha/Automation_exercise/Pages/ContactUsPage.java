package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class ContactUsPage {
    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Contact us'] | //a[text()='Contact us']")
    public WebElement contactUsLink;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouchLabel;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement subjectInput;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement messageInput;

    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement uploadFileInput;

    @FindBy(xpath = "//input[@name='submit'] | //button[text()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'status alert')] | //div[contains(text(),'Success!')]")
    public WebElement successMessage;
}
