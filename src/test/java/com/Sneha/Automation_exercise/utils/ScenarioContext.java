package com.Sneha.Automation_exercise.utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioContext {
    private WebDriver driver;

    public ScenarioContext() {
        // Initialize the driver when this class is instantiated (once per scenario)
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        this.driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    // Optional: Add hooks within the context class to manage lifecycle
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot logic can go here
        }
        if (driver != null) {
            driver.quit();
        }
    }
}