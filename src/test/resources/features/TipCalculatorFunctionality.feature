Feature: Calculate Functionality
  As a user of the Tipcalculator App
  I want to enter the valid input element
  So that I can view result

  Scenario: Calculate with empty input fields

    Given I am on the calculate page
    When I click on the calculate button
    Then an error message 'Please Enter a Valid Input.' should be visible

  Scenario: Calculate with invalid input fields

    Given I am on the calculate page
    When I Enter the tip percentage as 10f.
    When I click on the calculate button
    Then an error message 'Please Enter a Valid Input.' should be visible

  Scenario: Calculate with valid input fields

    Given I am on the calculate page
    When I Enter the tip percentage as 15.
    When I Enter the bill amount as 1000.
    When I click on the calculate button
    Then an expected the tip amount and total amount

