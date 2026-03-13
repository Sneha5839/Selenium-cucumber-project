@TestCases
Feature: Test Cases page
  Verify that the Test Cases page is accessible from the main navigation

  Scenario: Open Test Cases page
    Given user navigates to the application
    When user clicks on Test Cases link
    Then verify Test Cases page is opened and Test Cases text is present