package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {


    @FindBy(css = ".guestContinueToCheckout .btnN.btnN3")
    private WebElement checkOutNowButton;

    public void checkOutNowButton() {

        if (!WebDriverHelper.getWebDriver().getCurrentUrl().contains("/secure")) {

            clickUsingJS(checkOutNowButton);

        }
    }



}
