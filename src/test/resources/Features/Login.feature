@Login
Feature: Login Feature
A user with existing account can log in using valid credentials

  Scenario: Login with existing user credentials
    Given user navigates to the application
    When user clicks on Signup/login link
    Then verify Login to your account text is present
    When user enters existing email "jane1@example.com"
    And user enters existing password "Password123"
    Then clicks login button
    And verify user is logged in as "jane"
