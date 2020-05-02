Feature: Product Bag features
  As a customer
  I want to be able to view my online bag
  So that I can see products prior to procedding through checkout

Background:
  Given The User is on the selfRidges Homepage

@Regression
Scenario: Verify the Shopping bag and Order summary on Empty Bag
  When User navigate to "Bag"
  Then Content sections Delivery and Returns should not be visible
  Then I should see empty shoping bag
  And User click on Continue shopping button
  Then User is navigated to HomePage in same Window
