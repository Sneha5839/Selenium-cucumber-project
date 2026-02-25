package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sneha.Automation_exercise.utils.Driver;
import com.Sneha.Automation_exercise.utils.ScenarioContext;

import Sneha.Automation_Exercise.BaseTest;



public class SignUppage {
	
	public SignUppage()
	{
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	@FindBy(xpath="//a[text()=' Signup / Login']")
	public  WebElement signup;
	@FindBy(xpath="//div/div/h2[text()='New User Signup!']")
	public WebElement newusersignuplabel;
	@FindBy(xpath="//input[@data-qa='signup-name']")
	public WebElement newusername;

	@FindBy(xpath="//input[@data-qa='signup-email']")
	public WebElement newuseremail;

	@FindBy(xpath="//button[text()='Signup']")
	public WebElement signupbutton; 

	@FindBy(xpath="//h2//b[text()='Enter Account Information']")
	private WebElement accountinfolabel;

	@FindBy(xpath="//input[@id='id_gender1']")
	public WebElement titleMr;

	@FindBy(xpath="//input[@id='id_gender2']")
	public WebElement titleMrs;

	public WebElement getAccountInfoLabel(){
		return accountinfolabel;
	}		
	// Account info fields (on the account information form after initial signup)
	@FindBy(id = "name")
	public WebElement accountName;

	@FindBy(id = "email")
	public WebElement accountEmail;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "days")
	public WebElement days;

	@FindBy(id = "months")
	public WebElement months;

	@FindBy(id = "years")
	public WebElement years;

	@FindBy(id = "newsletter")
	public WebElement newsletter;

	// Additional account fields
	@FindBy(id = "optin")
	public WebElement offersCheckbox;

	@FindBy(id = "first_name")
	public WebElement firstName;

	@FindBy(id = "last_name")
	public WebElement lastName;

	@FindBy(id = "company")
	public WebElement company;

	@FindBy(id = "address1")
	public WebElement address1;

	@FindBy(id = "address2")
	public WebElement address2;

	@FindBy(id = "country")
	public WebElement country;

	@FindBy(id = "state")
	public WebElement state;

	@FindBy(id = "city")
	public WebElement city;

	@FindBy(id = "zipcode")
	public WebElement zipcode;

	@FindBy(id = "mobile_number")
	public WebElement mobileNumber;

	@FindBy(xpath = "//button[text()='Create Account']")
	public WebElement createAccountButton;

	}