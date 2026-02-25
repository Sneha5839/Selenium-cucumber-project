Feature: Signup Feature
A user with valid email can register and sign up on the site
entering the user details

  Scenario Outline: Successful signup with new user credentials
    Given user navigates to the application
    When user clicks on Signup/login link
    Then verify New user signup! text is present
    When user enter "<username>" for name
    And user enters "<useremail>" for email
    Then clicks Signup button
    Then Signup page is opened
    And verify Enter account information text is present
    Then user selects the Title
    And verify name is present
    And verify email is present
    Then enter the password
    Then select day month and year of date of birth
    Then tick the checkbox signup for our newsletter
    And tick the checkbox receive special offers from our partners
    When user enters first name "<firstname>"
    And user enters last name "<lastname>"
    And user enters company name "<company>"
    And user enters address "<address1>"
    And user enters address2 "<address2>"
    And user enters country "<country>"
    And user enters state "<state>"
    And user enters city "<city>"
    And user enters zipcode "<zipcode>"
    And user enters mobile number "<mobile>"
    Then clicks Create Account button

Examples:

|username|useremail|firstname|lastname|company|address1|address2|country|state|city|zipcode|mobile|
|reeta1|july1234@example.com|June|Doe|Acme Corp|123 Main St|Suite 100|United States|California|Los Angeles|90001|5551234567|