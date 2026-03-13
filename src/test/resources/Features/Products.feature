@Products
Feature: Products Feature
  Verify product listing and product detail page

  Scenario: Open products list and view first product details
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user clicks on Products link
    Then verify products list is visible
    When user opens the first product details
    Then verify product details page is displayed