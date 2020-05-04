package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.UrlBuilder;
import com.prolian.test.framework.helpers.WebDriverHelper;
import com.prolian.test.pageObjects.CheckoutFooter;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class NavigationSteps  {


 // UrlBuilder  urlBuilder = new UrlBuilder();
  UrlBuilder urlBuilder = PageFactory.initElements(WebDriverHelper.getWebDriver(),UrlBuilder.class);


  @Given("^The User is on the selfRidges Homepage$")
    public void theUserIsOnTheSelfRidgesHomepage() {

      urlBuilder.goToHomePage();

        // Write code here that turns the phrase above into concrete actions
        System.out.println("^The User is on the selfRidges Homepage$");

    }



}
