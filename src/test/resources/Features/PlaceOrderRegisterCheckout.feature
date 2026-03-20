@PlaceOrderRegisterCheckout
Feature: Place Order - Register while Checkout
  Verify that a user can place an order by registering during checkout

  Scenario: Place Order Register while Checkout
    Given user navigates to the application
    Then verify that the home page is visible successfully
    When user adds the first product to cart
    Then clicks on Continue Shopping button
    When user clicks on Cart button
    Then verify that cart page is displayed
    When user clicks Proceed To Checkout
    Then user clicks Register Login button on checkout modal
    When user clicks on Signup/login link
    Then verify New user signup! text is present
    When user enter "TestOrder" for name
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
    And user enters address "456 Test Avenue"
    And user enters address2 "Apt 200"
    And user enters country "United States"
    And user enters state "New York"
    And user enters city "New York"
    And user enters zipcode "10001"
    And user enters mobile number "9876543210"
    Then clicks Create Account button
    Then verify ACCOUNT CREATED and click Continue button
    Then verify user is logged in as "TestOrder"
    When user clicks on Cart button
    Then user clicks Proceed To Checkout button
    Then verify Address Details and Review Your Order section
    When user enters description in comment area "Please deliver between 9 AM and 5 PM"
    And user clicks Place Order button
    Then user enters payment details name "Test Order" card number "4100000000000" cvc "123" expiry month "12" expiry year "2026"
    And user clicks Pay and Confirm Order button
    Then verify order success message "ORDER PLACED!"
    When user clicks Delete Account button
    Then verify ACCOUNT DELETED and click Continue button
