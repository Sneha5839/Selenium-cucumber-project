@PlaceOrderLoginBeforeCheckout
Feature: Place Order - Login before Checkout
  Verify that a user can login before checkout and place an order

  Scenario: Create account for TC16
    Given user navigates to the application
    When user clicks on Signup/login link
    Then verify New user signup! text is present
    When user enter "TestOrder21" for name
    And user enters "testorder_tc21@example.com" for email
    Then clicks Signup button
    And verify Enter account information text is present
    Then user selects the Title
    And verify name is present
    Then enter the password
    Then select day month and year of date of birth
    Then tick the checkbox signup for our newsletter
    And tick the checkbox receive special offers from our partners
    When user enters first name "Test"
    And user enters last name "Order"
    And user enters company name "TestCorp"
    And user enters address "789 Login Avenue"
    And user enters address2 "Suite 300"
    And user enters country "United States"
    And user enters state "California"
    And user enters city "San Francisco"
    And user enters zipcode "94102"
    And user enters mobile number "5559876543"
    Then clicks Create Account button
    Then verify ACCOUNT CREATED and click Continue button

  Scenario: Place Order Login before Checkout
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user clicks on Signup/login link
    Then verify Login to your account text is present
    When user enters existing email "testorder_tc21@example.com"
    And user enters existing password "Password123"
    Then clicks login button
    Then verify user is logged in as "TestOrder21"
    When user adds the first product to cart
    Then clicks on Continue Shopping button
    When user clicks on Cart button
    Then verify that cart page is displayed
    Then user clicks Proceed To Checkout button
    Then verify Address Details and Review Your Order section
    When user enters description in comment area "Order via login before checkout"
    And user clicks Place Order button
    Then user enters payment details name "Test Order" card number "4100000000000" cvc "123" expiry month "12" expiry year "2026"
    And user clicks Pay and Confirm Order button
    Then verify order success message "Order Placed!"
    When user clicks Delete Account button
    Then verify ACCOUNT DELETED and click Continue button
