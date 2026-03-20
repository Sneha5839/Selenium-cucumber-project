@SearchProduct
Feature: Search Product
  Verify that a user can search for a product and see relevant results

  Scenario: Search for a product and verify results
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user clicks on Products link
    Then verify user is navigated to ALL PRODUCTS page
    When user enters product name "Top" in search input and clicks search button
    Then verify SEARCHED PRODUCTS heading is visible
    And verify all the products related to search are visible
