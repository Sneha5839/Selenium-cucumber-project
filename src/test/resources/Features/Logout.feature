@Logout
Feature: Logout Feature
  Verify a logged-in user can log out successfully

  Scenario: Logout after successful login
    Given user navigates to the application
    When user clicks on Signup/login link
    And user enters existing email "jane1@example.com"
    And user enters existing password "Password123"
    Then clicks login button
    And verify user is logged in as "jane"
    When user clicks on Logout link
    Then verify user is logged out and Login to your account text is present
