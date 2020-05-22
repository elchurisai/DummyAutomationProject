package com.prolian.test.step_definitions.web;

import com.prolian.test.framework.helpers.WebDriverHelper;
import com.prolian.test.pageObjects.HomePage;
import com.prolian.test.pageObjects.LocalCurrencyAndLanguage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.PageFactory;

public class otherCountryAndLanguageSteps {

    HomePage homePage = PageFactory.initElements(WebDriverHelper.getWebDriver(),HomePage.class);
    LocalCurrencyAndLanguage localCurrencyAndLanguage = PageFactory.initElements(WebDriverHelper.getWebDriver(), LocalCurrencyAndLanguage.class);

    @And("^Click on left corner header$")
    public void clickOnLeftCornerHeader() {

        homePage.clickOnLeftCorner();


    }


    @And("^Select \"([^\"]*)\" and \"([^\"]*)\" on shop local currency and language page$")
    public void selectAndOnShopLocalCurrencyAndLanguagePage(String currency, String language) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

      //  System.out.println("~~~~~~~~~" +currency);
       localCurrencyAndLanguage.selectLocalCurrency(currency);

        localCurrencyAndLanguage.selectLanguage(language);




    }
}
