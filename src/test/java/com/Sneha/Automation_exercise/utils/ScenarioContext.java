package com.Sneha.Automation_exercise.utils;



import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScenarioContext {

    // Ensure the shared Driver (ThreadLocal) is used for scenarios
    @Before
    public void setUp() {
        // initialize the shared driver if not already
        Driver.getDriver();
    }

    // Optional getter if other code wants access to the driver via this context
    public static org.openqa.selenium.WebDriver getDriverFromContext() {
        return Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        org.openqa.selenium.WebDriver driver = null;
        try {
            driver = Driver.getDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

                // Attach screenshot to Allure report (for both pass and fail)
                Allure.addAttachment(scenario.getName() + " - Screenshot", "image/png",
                        new ByteArrayInputStream(screenshot), ".png");

                // Also attach to Cucumber scenario
                scenario.attach(screenshot, "image/png", scenario.getName());

                if (scenario.isFailed()) {
                    // Save screenshot to file system on failure
                    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                    String safeScenario = scenario.getName().replaceAll("[^a-zA-Z0-9-_]","_");
                    Path outDir = Path.of("test-output", "screenshots");
                    Files.createDirectories(outDir);
                    Path outFile = outDir.resolve(safeScenario + "-" + timestamp + ".png");
                    Files.write(outFile, screenshot);
                    System.out.println("Saved screenshot to: " + outFile.toAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        } finally {
            // Always close and cleanup the driver, even if screenshot fails
            try {
                Driver.closeDriver();
            } catch (Exception e) {
                System.err.println("Failed to close driver: " + e.getMessage());
            }
        }
    }
}