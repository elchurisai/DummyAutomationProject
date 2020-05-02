$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/web/RegressionTest/productBag.feature");
formatter.feature({
  "name": "Product Bag features",
  "description": "  As a customer\n  I want to be able to view my online bag\n  So that I can see products prior to procedding through checkout",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "The User is on the selfRidges Homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "NavigationSteps.theUserIsOnTheSelfRidgesHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify the Shopping bag and Order summary on Empty Bag",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "User navigate to \"Bag\"",
  "keyword": "When "
});
formatter.match({
  "location": "CheckoutFooterSteps.userNavigateTo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Content sections Delivery and Returns should not be visible",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductBagSteps.contentSectionsDeliveryAndReturnsShouldNotBeVisible(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see empty shoping bag",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductBagSteps.iShouldSeeEmptyShopingBag()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Continue shopping button",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.userClickOnContinueShoppingButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is navigated to HomePage in same Window",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.userIsNavigatedToHomePageInSameWindow()"
});
formatter.result({
  "status": "passed"
});
});