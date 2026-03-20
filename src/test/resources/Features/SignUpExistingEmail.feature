@SignUp
Feature: Sign up with existing email
  Verify that attempting to register with an email that's already registered shows an appropriate error

  Scenario: Register with existing email
    Given user navigates to the application
    When user clicks on Signup/login link
    Then verify New user signup! text is present
    When user enter "existinguser" for name
    And user enters existing signup email "jane1@example.com"
    Then clicks Signup button
    Then message "Email Address already exist!" is displayed