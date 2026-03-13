@AddToCart
Feature: Add to cart
  Verify that a user can add a product to the cart and view it in the cart page

  Scenario: Add first product to cart and verify in cart
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user clicks on Products link
    Then user adds the first product to cart
    Then clicks on Continue Shopping button
    Then user adds the second product to cart
    And user clicks on View Cart
    Then verify both the products are present in the cart
