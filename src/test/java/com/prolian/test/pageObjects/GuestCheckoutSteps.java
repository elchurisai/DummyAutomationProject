package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.DataGenerator;
import com.prolian.test.framework.helpers.WebDriverHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class GuestCheckoutSteps extends PageObject {


    private DeliveryAddressPage deliveryAddressPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),DeliveryAddressPage.class);

    private RegistrationPage registrationPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),RegistrationPage.class);

    private CustomerBagPage customerBagPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),CustomerBagPage.class);
   DataGenerator dataGenerator = DataGenerator.getInstance();



    @When("^(?:I|User) fill user details$")
    public void i_fill_user_details() {
        System.out.println("I fill user details");
        //  pageObject.getCurrentUrl();

        if (!deliveryAddressPage.isDeliveryTypeInfoDisplayed()) {

            registrationPage.fillUserDetailsForm(dataGenerator.getUserInfo());

        }
    }

    @And("^I click on Continue to Delivery button$")
    public void iClickOnContinueToDeliveryButton() {

        System.out.println("I click on Continue to Delivery button");

        if (!deliveryAddressPage.isDeliveryTypeInfoDisplayed()) {

            registrationPage.clickOnContinueToDeliveryButton();
        }

        customerBagPage.waitUntilSpinnerDisappears();

    }


}
