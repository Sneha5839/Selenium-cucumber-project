Feature: Login Feature
A user  cannot log in using invalid credentials

  Scenario: Login with existing user credentials
    Given user navigates to the application
    When user clicks on Signup/login link
    Then verify Login to your account text is present
    When user enters existing email "jane1@example.com"
    And user enters existing password "Pass123"
    Then clicks login button
    And error message "Your email or password is incorrect!" is displayed