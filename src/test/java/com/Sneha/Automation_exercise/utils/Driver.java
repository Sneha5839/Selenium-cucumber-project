package com.Sneha.Automation_exercise.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {}

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
        	
            //WebDriverManager.chromedriver().setup();
            
           // driverPool.set(new ChromeDriver());
        	
        	FirefoxOptions options = new FirefoxOptions();
        	
        	
        	FirefoxProfile profile = new FirefoxProfile();

            // Disable disk and memory cache
            profile.setPreference("browser.cache.disk.enable", false);
            profile.setPreference("browser.cache.memory.enable", false);
            options.addArguments("-private");
            // Add the profile to the options
            options.setProfile(profile);
        driverPool.set(new FirefoxDriver(options));
          
            driverPool.get().manage().window().maximize();
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            try {
                driverPool.get().quit();
            } catch (Exception e) {
                System.err.println("Error during driver quit: " + e.getMessage());
            } finally {
                driverPool.remove(); // Essential for ThreadLocal cleanup
            }
        }
    }
}