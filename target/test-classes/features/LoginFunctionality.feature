Feature: Goya OMS Login Functionality

  Background:
    Given Not a validated user
    When  User browse to website
    Then  Login page should display


  Scenario: 1.Valid user with valid password - Broker

    When User enter username as "013506"
    And User enter password as "Pwd@013506"
    And User click login button
    Then Home page should display

  Scenario: 2.Valid user with valid password - Sales Author

    When User enter username as "salesauthor1"
    And User enter password as "Pwd1@salesauthor1"
    And User click login button
    Then Home page should display



  Scenario Outline: 3.User login negative testing
    When User enter username as "<UserName>"
    And User enter password as "<Password>"
    And User click login button
    Then Login error message should display

    Examples:
      |UserName      |Password         |
      |013506        |invalid          |
      |invalid       |Pwd@013506       |
      |invalid       |invalid          |
      |013506        |                 |
      |              |Pwd@013506       |
      |              |                 |
      |salesauthor1  |invalid          |
      |invalid       |Pwd1@salesauthor1 |
      |invalid       |invalid          |
      |salesauthor1  |                 |
      |              |Pwd1@salesauthor1 |
      |              |                 |
