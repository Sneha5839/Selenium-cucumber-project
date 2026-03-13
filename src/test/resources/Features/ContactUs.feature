@ContactUs
Feature: Contact Us Feature
  Verify that a user can submit the contact form successfully

  Scenario: Submit contact form successfully
    Given user navigates to the application
    When user clicks on Contact us link
    Then verify Get In Touch text is present
    When user enters name "Jane Doe"
    And user enters email "jane1@example.com"
    And user enters subject "Test Subject"
    And user enters message "This is a test message"
    And user uploads file "src/test/resources/test-files/sample.txt"
    Then clicks submit button
    And verify success message "Success! Your details have been submitted successfully."