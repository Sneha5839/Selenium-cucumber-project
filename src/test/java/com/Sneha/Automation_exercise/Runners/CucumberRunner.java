package com.Sneha.Automation_exercise.Runners;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	        features = "src/test/resources/Features",
	        glue = "com.Sneha.Automation_exercise.stepdefinitions",
	        plugin = {"pretty", "html:target/cucumber-reports/index.html", "json:target/cucumber-reports/Cucumber.json"}) 
	 	public class CucumberRunner extends AbstractTestNGCucumberTests {
		 @Override
		    @DataProvider(parallel = true)
		public Object[][] scenarios() {
		    return super.scenarios();
		  }
	}

