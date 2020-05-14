package com.prolian.test.pageObjects;

import com.prolian.test.framework.helpers.WebDriverHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class SigninSteps {

    private SignInPage signInPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),SignInPage.class);

    @And("^(?:I|User) click on Checkout Now Button in Sign-in Page$")
    public void iClickOnCheckoutNowButtonInSignInPage() {

        signInPage.checkOutNowButton();

    }
}
