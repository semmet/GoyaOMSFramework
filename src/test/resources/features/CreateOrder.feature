Feature: Goya OMS Create Order

  Background:
    Given Not a validated user
    When  User browse to website
    Then  Login page should display
    When  User enter username as "013506"
    And   User enter password as "Pwd@013506"
    And   User click login button
    Then  Home page should display
    When  User clicks Create Order
    Then  Create Order page should display


    Scenario: User creates customer order
      When User selects customer from dropdown menu
      And  User enters item code into UPC box
      And  User clicks Add button
      Then Item Added alert should display