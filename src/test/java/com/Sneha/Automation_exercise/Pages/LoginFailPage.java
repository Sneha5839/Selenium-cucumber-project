package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;

public class LoginFailPage {
	public LoginFailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement loginFailLabel;	
}
