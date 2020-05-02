package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.WebDriverHelper;
import com.prolian.test.pageObjects.CheckoutFooter;
import com.prolian.test.pageObjects.CustomerBagPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.is;

public class ProductBagSteps extends PageObject {


    CustomerBagPage customerBagPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),CustomerBagPage.class);
    CheckoutFooter checkoutFooter = PageFactory.initElements(WebDriverHelper.getWebDriver(),CheckoutFooter.class);


    @Then("^Content sections Delivery and Returns (should|should not) be visible$")
    public void contentSectionsDeliveryAndReturnsShouldNotBeVisible(String option) {
        // Write code here that turns the phrase above into concrete actions

        if (option.equalsIgnoreCase("should")) {
        // Code will written when the Contents sections should be avaiable
      //      MatcherAssert.assertThat("Content is not available ",);

        }
        else if(option.equalsIgnoreCase("should not")) {
           // Code it should not be avaiable - false condition
            MatcherAssert.assertThat("Content Header is avaiable  but it shouldn't be available ",customerBagPage.isDeliveryContentHeader(),is(false));
            System.out.println("^Content sections Delivery and Returns should not be visible$"+customerBagPage.isDeliveryContentHeader());

        }



    }

    @Then("^I should see empty shoping bag$")
    public void iShouldSeeEmptyShopingBag() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("^I should see empty shoping bag$");

        MatcherAssert.assertThat("Shoping Bag to be Empty",customerBagPage.isBasketEmpty(),is(true));



    }

    @Then("^User click on Continue shopping button$")
    public void userClickOnContinueShoppingButton() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("^User click on Continue shopping button$");

        customerBagPage.clickContinueShopping();
    }





}
