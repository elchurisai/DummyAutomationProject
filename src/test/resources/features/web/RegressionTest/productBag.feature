Feature: Product Bag features
  As a customer
  I want to be able to view my online bag
  So that I can see products prior to procedding through checkout

Background:
  Given The User is on the selfRidges Homepage

@Regression
Scenario: Verify the Shopping bag and Order summary on Empty Bag
  When User navigate to "Bag" of "<product>"
  Then Content sections Delivery and Returns should not be visible
  Then I should see empty shoping bag
  And User click on Continue shopping button
  Then User is navigated to HomePage in same Window

@Regression
Scenario Outline: Verify the Edit Links for Products are working as expected
  When User navigate to "PDP" of "<product>"
  And I add 1 Products with "<product>" type
  And User Click on Checkout Toast on PDP Page
  Then Edit link for the product "<status>" be displayed
  And the User selects to remove all products in the bag
  Examples:
    | product | status |
    |Image&Edit | should |
    | NoEdit | should not |