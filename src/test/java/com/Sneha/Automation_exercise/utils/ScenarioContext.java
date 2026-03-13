package com.Sneha.Automation_exercise.utils;



import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
        if (scenario.isFailed()) {
            // Take screenshot and save to test-output/screenshots
            try {
                org.openqa.selenium.WebDriver driver = Driver.getDriver();
                if (driver instanceof TakesScreenshot) {
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

                    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                    String safeScenario = scenario.getName().replaceAll("[^a-zA-Z0-9-_]","_");
                    Path outDir = Path.of("test-output", "screenshots");
                    Files.createDirectories(outDir);
                    Path outFile = outDir.resolve(safeScenario + "-" + timestamp + ".png");
                    Files.write(outFile, screenshot);
                    System.out.println("Saved screenshot to: " + outFile.toAbsolutePath());
                }
            } catch (IOException | RuntimeException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
        // Close and cleanup the shared driver
        Driver.closeDriver();
    }
}