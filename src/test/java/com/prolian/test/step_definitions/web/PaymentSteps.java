package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.WebDriverHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class PaymentSteps extends PageObject {

    private PageObject pageObject;
        public PaymentSteps(PageObject pageObject){

            this.pageObject=pageObject;
        }


    @And("^I click on Continue to Delivery button$")
    public void iClickOnContinueToDeliveryButton() {

        System.out.println("I click on Continue to Delivery button");



    }
}
