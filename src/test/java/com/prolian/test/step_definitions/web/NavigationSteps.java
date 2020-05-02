package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.helpers.UrlBuilder;
import cucumber.api.java.en.Given;

public class NavigationSteps {

  UrlBuilder  urlBuilder = new UrlBuilder();


    @Given("^The User is on the selfRidges Homepage$")
    public void theUserIsOnTheSelfRidgesHomepage() {

       urlBuilder.goToHomePage();

        // Write code here that turns the phrase above into concrete actions
        System.out.println("^The User is on the selfRidges Homepage$");

    }



}
