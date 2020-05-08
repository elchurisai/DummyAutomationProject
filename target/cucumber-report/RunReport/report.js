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
  "name": "User navigate to \"Bag\" of \"\u003cproduct\u003e\"",
  "keyword": "When "
});
formatter.match({
  "location": "CheckoutFooterSteps.userNavigateTo(String,String)"
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
formatter.scenarioOutline({
  "name": "Verify the Edit Links for Products are working as expected",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "User navigate to \"PDP\" of \"\u003cproduct\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I add 1 Products with \"\u003cproduct\u003e\" type",
  "keyword": "And "
});
formatter.step({
  "name": "User Click on Checkout Toast on PDP Page",
  "keyword": "And "
});
formatter.step({
  "name": "Edit link for the product \"\u003cstatus\u003e\" be displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "the User selects to remove all products in the bag",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "product",
        "status"
      ]
    },
    {
      "cells": [
        "Image\u0026Edit",
        "should"
      ]
    },
    {
      "cells": [
        "NoEdit",
        "should not"
      ]
    }
  ]
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
  "name": "Verify the Edit Links for Products are working as expected",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "User navigate to \"PDP\" of \"Image\u0026Edit\"",
  "keyword": "When "
});
formatter.match({
  "location": "CheckoutFooterSteps.userNavigateTo(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add 1 Products with \"Image\u0026Edit\" type",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.iAddProductsWithType(int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Click on Checkout Toast on PDP Page",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.userClickOnCheckoutToastOnPDPPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Edit link for the product \"should\" be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductBagSteps.editLinkForTheProductBeDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the User selects to remove all products in the bag",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.theUserSelectsToRemoveAllProductsInTheBag()"
});
formatter.result({
  "status": "passed"
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
  "name": "Verify the Edit Links for Products are working as expected",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "User navigate to \"PDP\" of \"NoEdit\"",
  "keyword": "When "
});
formatter.match({
  "location": "CheckoutFooterSteps.userNavigateTo(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add 1 Products with \"NoEdit\" type",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.iAddProductsWithType(int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Click on Checkout Toast on PDP Page",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.userClickOnCheckoutToastOnPDPPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Edit link for the product \"should not\" be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductBagSteps.editLinkForTheProductBeDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the User selects to remove all products in the bag",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.theUserSelectsToRemoveAllProductsInTheBag()"
});
formatter.result({
  "status": "passed"
});
});