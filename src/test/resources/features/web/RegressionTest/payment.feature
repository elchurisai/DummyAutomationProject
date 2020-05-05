@Regression1
Feature: Place order as Guest user and make a payment
  As a Customer
  I want to know if my payment is successfull
  so that i know if my order has been placed


Background:
  Given The User is on the selfRidges Homepage
  When User navigate to "PDP" of "<product>"
  And I add 1 Products with "<product>" type
  And User Click on Checkout Toast on PDP Page


  Scenario Outline: Verify user card details are not retained
  When I fill user details
  And 2nd User I click On Continue to Delivery button
  #And user should see Checkout Page
  #And I select the Delivery Type as "Delivery"
  #And User already has an address
  #And User choose the Billing Address
  #And I click on Continue to payment button
  #And I enter "Visa Debit" card details on Payment form
  #And I move away to "<section>"
  #And I click on Continue to payment button
  #Then Payment card Details with type "Visa Debit" Should not be retained
  Examples:
  |     section         |
  | Personal Details    |
  #| DeliverySection     |
  #| HomePage            |
  #| billing address     |
  #| new payment  method |
