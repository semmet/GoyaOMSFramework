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
    And   User selects customer from dropdown menu



    Scenario: 1. User adds item to order
      When  User enters item code into UPC box
      And   User clicks Add button
      Then  Item Added alert should display

    Scenario: 2. User adds item that is restricted
      When User enters restricted code item
      And  User clicks Add button
      Then Restricted Item alert should display

    Scenario: 3. User enters invalid UPC code for item
      When User enters an invalid UPC code
      And  User clicks Add button
      Then Item not found alert should display



    Scenario: 4. User adds item by Search Item feature and submits order
      When User clicks on Search Item button
      Then Catalog page should display
      When User selects item and clicks Add to Cart button
      Then Item qty window should display
      When User clicks Add to Cart
      Then Item should display in cart
      When User clicks on Continue button
      Then User should be directed back to Create Order page
      And  Item should display in table
      When user clicks Submit button
      And  user clicks Alert Submit
      Then success message should display





