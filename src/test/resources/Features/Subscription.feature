@Subscription
Feature: Subscription Feature
  Verify subscription functionality on home page and cart page

  Scenario: Verify Subscription in home page
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user scrolls down to footer
    Then verify text SUBSCRIPTION is visible
    When user enters email address "testsubscription@example.com" in subscription input
    And user clicks the subscription arrow button
    Then verify success message "You have been successfully subscribed!" is visible

  Scenario: Verify Subscription in Cart page
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user clicks on Cart button
    When user scrolls down to footer
    Then verify text SUBSCRIPTION is visible
    When user enters email address "testcartsubscription@example.com" in subscription input
    And user clicks the subscription arrow button
    Then verify success message "You have been successfully subscribed!" is visible
