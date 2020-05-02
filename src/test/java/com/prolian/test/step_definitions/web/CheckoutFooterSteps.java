package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.helpers.WebDriverHelper;
import com.prolian.test.pageObjects.CheckoutFooter;
import com.prolian.test.pageObjects.GlobalHeaderPage;
import cucumber.api.java.en.When;
import gherkin.lexer.Gl;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFooterSteps {

    CheckoutFooter checkoutFooter = PageFactory.initElements(WebDriverHelper.getWebDriver(),CheckoutFooter.class);
 //   GlobalHeaderPage globalHeaderPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),GlobalHeaderPage.class);

    @When("^User navigate to \"([^\"]*)\"$")
    public void userNavigateTo(String item) {


        // Write code here that turns the phrase above into concrete actions
        System.out.println("^User navigate to \"([^\"]*)\"$");

        if ("Sign in or Register".equalsIgnoreCase(item)) {
            // Code to implement  Hover on account page and click on Account link
        }
        else {
            checkoutFooter.clickOnNavigationItem(item);
        }



    }


}
