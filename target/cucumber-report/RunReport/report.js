$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/web/RegressionTest/deliveryMethods.feature");
formatter.feature({
  "name": "Delivery Methods features",
  "description": "  As a customer\n  I want to able to view my online Bag\n  So that I can see products prior to proceeding through checkout",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
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
  "name": "User navigate to \"PDP\" of \"C\u0026C\"",
  "keyword": "When "
});
formatter.match({
  "location": "CheckoutFooterSteps.userNavigateTo(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add 1 Products with \"C\u0026C\" type",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.iAddProductsWithType(int,String)"
});
formatter.result({
  "status": "passed"
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
formatter.scenario({
  "name": "C\u0026C pre-selected based on products choosen",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
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
  "name": "I click on Secure checkout button in Shooping Bag Page",
  "keyword": "And "
});
formatter.match({
  "location": "ProductBagSteps.iClickOnSecureCheckoutButtonInShoopingBagPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Checkout Now Button in Sign-in Page",
  "keyword": "And "
});
formatter.match({
  "location": "SigninSteps.iClickOnCheckoutNowButtonInSignInPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill user details",
  "keyword": "When "
});
