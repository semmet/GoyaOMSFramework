Feature: Goya OMS Smart Order


  Background:
    Given Not a validated user
    When  User browse to website
    Then  Login page should display
    When  User enter username as "013506"
    And   User enter password as "Pwd@013506"
    And   User click login button
    Then  Home page should display
    When  User clicks on Customers
    Then  Customers page should display
    When  User selects customer
    And   User clicks Select button
    And   User accepts Confirm Alert
    Then  User should be direct back to Homepage
    And   Customer info should display at top


  Scenario: 1. Confirmation correct customer info is displayed
    When  User clicks on Smart Order
    Then  Smart Order page should display
    And   Correct customer info should display in field box


  Scenario: 2. User adds one item to order
    When  User clicks on Smart Order
    Then  Smart Order page should display
    When  User adds item to order
    Then  Item count should display as 1
    And   Case qty should display as 1
    And   Item should display in Smart Order cart


  Scenario: 3. User adds multiple items to order
    When  User clicks on Smart Order
    Then  Smart Order page should display
    When  User adds 2 case of first item
    And   User adds 1 case of second item
    Then  Item count should display as 2
    And   Case qty should display as 3
    #And   2 items should display in cart


