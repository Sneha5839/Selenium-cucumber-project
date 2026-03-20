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

    @FindBy(xpath="//a[contains(text(),'Products')]")
    public WebElement productsLink;

    // product list - simplified selector for product boxes
    @FindBy(xpath = "//div[contains(@class,'product')]//a[contains(@href,'product_details')]")
    public List<WebElement> productLinks;

    //product boxes - to hover and reveal add to cart button
    @FindBy(xpath = "//div[contains(@class,'product')]")
    public List<WebElement> productboxes;
    
    //features items - to ensure we are on the products page
    @FindBy(xpath = "div[contains(@class,'features_items')]")
    public WebElement featuresItemsSection;
    
    @FindBy(css="a.btn.add-to-cart[data-product-id='1']")
    public WebElement firstProduct;
    
    //Continue Shopping Button
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueButton;
    
    // Add to cart buttons corresponding to product entries
    @FindBy(xpath = "//div[contains(@class,'product')]//a[contains(text(),'Add to cart') or contains(@class,'add-to-cart')]")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//u[text()='View Cart'] ")
    public WebElement viewCartLink;

    // Search elements
    @FindBy(id = "search_product")
    public WebElement searchInput;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    public WebElement searchedProductsHeading;

    // Search result product items
    @FindBy(xpath = "//div[@class='features_items']//div[contains(@class,'productinfo')]")
    public List<WebElement> searchedProducts;
}