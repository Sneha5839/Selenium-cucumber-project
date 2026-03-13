package com.Sneha.Automation_exercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import com.Sneha.Automation_exercise.utils.Driver;

public class ProductsPage {
    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Products'] | //a[text()='Products']")
    public WebElement productsLink;

    // product list - simplified selector for product boxes
    @FindBy(xpath = "//div[contains(@class,'product')]//a[contains(@href,'product_details')]")
    public List<WebElement> productLinks;

    // Add to cart buttons corresponding to product entries
    @FindBy(xpath = "//div[contains(@class,'product')]//a[contains(text(),'Add to cart') or contains(@class,'add-to-cart')]")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//u[text()='View Cart'] ")
    public WebElement viewCartLink;
}