Feature: Select Different country and language
  As a customer
  I want to be able to select different country and language
  So that i can purchase items in different country


Background:
  Given The User is on the selfRidges Homepage
  When User navigate to "Home" of "<product>"

  Scenario Outline:
    And Click on left corner header
    And Select "<currency>" and "<Language>" on shop local currency and language page
    Examples:
      | currency    | Language     |
      | China / CNY ¥ | Simplified Chinese |


