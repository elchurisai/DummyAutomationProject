package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.ReportManager;
import com.prolian.test.framework.helpers.WebDriverHelper;
import com.prolian.test.pageObjects.DeliveryAddressPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.PageFactory;


public class DeliveryAddressSteps {



    public DeliveryAddressPage deliveryAddressPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),DeliveryAddressPage.class);

    @And("^User should see Checkout Page$")
    public void userShouldSeeCheckoutPage() {

        ReportManager.testPassed("User should see the Checkout Page ");
             MatcherAssert.assertThat("User should see the Checkout Page" ,deliveryAddressPage.isDeliveryInforDisplayed());


    }


    @And("^I should see C&C Pre-selected and display the \"([^\"]*)\" message$")
    public void iShouldSeeCCPreSelectedAndDisplayTheMessage(String deliveryMessage) throws Throwable {

    }
}
