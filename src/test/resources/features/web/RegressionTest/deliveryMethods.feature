
Feature:Delivery Methods features
  As a customer
  I want to able to view my online Bag
  So that I can see products prior to proceeding through checkout


Background:
 Given The User is on the selfRidges Homepage
  When User navigate to "PDP" of "C&C"
  And I add 1 Products with "C&C" type
  When User navigate to "PDP" of "NoEdit"
  And I add 1 Products with "NoEdit" type

  @wip
  Scenario: C&C pre-selected based on products choosen
    And User Click on Checkout Toast on PDP Page
    And I click on Secure checkout button in Shooping Bag Page
    And I click on Checkout Now Button in Sign-in Page
    When I fill user details
    And I click on Continue to Delivery button
    And User should see Checkout Page
    And I should see C&C Pre-selected and display the "Sorry, the item below is unavailable for Click & Collect" message




