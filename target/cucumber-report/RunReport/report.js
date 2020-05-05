$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/web/RegressionTest/payment.feature");
formatter.feature({
  "name": "Place order as Guest user and make a payment",
  "description": "  As a Customer\n  I want to know if my payment is successfull\n  so that i know if my order has been placed",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Regression1"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verify user card details are not retained",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I fill user details",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "section"
      ]
    },
    {
      "cells": [
        "Personal Details"
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
formatter.step({
  "name": "User navigate to \"PDP\" of \"\u003cproduct\u003e\"",
  "keyword": "When "
});
formatter.match({
  "location": "CheckoutFooterSteps.userNavigateTo(String,String)"
});
formatter.result({
  "error_message": "java.lang.RuntimeException: simple execption\u003cproduct\u003e\r\n\tat com.prolian.test.pageObjects.CheckoutFooter.lambda$clickOnNavigationItem$1(CheckoutFooter.java:37)\r\n\tat java.util.Optional.orElseThrow(Optional.java:290)\r\n\tat com.prolian.test.pageObjects.CheckoutFooter.clickOnNavigationItem(CheckoutFooter.java:37)\r\n\tat com.prolian.test.step_definitions.web.CheckoutFooterSteps.userNavigateTo(CheckoutFooterSteps.java:28)\r\n\tat ✽.User navigate to \"PDP\" of \"\u003cproduct\u003e\"(src/test/resources/features/web/RegressionTest/payment.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I add 1 Products with \"\u003cproduct\u003e\" type",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.iAddProductsWithType(int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User Click on Checkout Toast on PDP Page",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.userClickOnCheckoutToastOnPDPPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Verify user card details are not retained",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Regression1"
    }
  ]
});
formatter.step({
  "name": "I fill user details",
  "keyword": "When "
});
formatter.match({
  "location": "PaymentSteps.iFillUserDetails()"
});
formatter.result({
  "status": "skipped"
});
});