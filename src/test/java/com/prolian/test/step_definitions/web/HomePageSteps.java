package com.prolian.test.step_definitions.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.TestContext;
import com.prolian.test.framework.helpers.WebDriverHelper;
import com.prolian.test.pageObjects.HomePage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class HomePageSteps extends PageObject {

    private HomePage homePage = PageFactory.initElements(WebDriverHelper.getWebDriver(), HomePage.class);


    @Then("^User is navigated to HomePage in same Window$")
    public void userIsNavigatedToHomePageInSameWindow() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("^User is navigated to HomePage in same Window$");

        String actualURL = homePage.getHomePageURL();
        String expectedURL = TestContext.getInstance().getHost()+"/GB/en/";
        assertThat("User is not on the Home Page, Actual URL is --->"+getCurrentUrl(),actualURL,is(expectedURL));
        // Adding to Git...
    }


}
