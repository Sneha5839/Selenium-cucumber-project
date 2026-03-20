@ProductQuantity
Feature: Verify Product Quantity in Cart
  Verify that a user can set product quantity on detail page and see it in cart

  Scenario: Verify product quantity in Cart
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user clicks View Product for any product on home page
    Then verify product detail is opened
    When user increases quantity to "4"
    And user clicks Add to Cart button on product detail page
    Then user clicks View Cart link in success modal
    Then verify that product is displayed in cart page with exact quantity "4"
