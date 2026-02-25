package com.Sneha.Automation_exercise.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {}

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            WebDriverManager.chromedriver().setup();
            driverPool.set(new ChromeDriver());
            driverPool.get().manage().window().maximize();
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove(); // Essential for ThreadLocal cleanup
        }
    }
}
