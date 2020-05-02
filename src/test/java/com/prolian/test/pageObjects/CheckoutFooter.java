package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.TestContext;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class CheckoutFooter extends PageObject {


    private GlobalHeaderPage globalHeaderPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),GlobalHeaderPage.class);

    public void clickOnNavigationItem(String item) {

        switch (item.toUpperCase()) {

            case "PDP":
                WebDriverHelper.getWebDriver().navigate().to(TestContext.getInstance().getBaseURL().toString()+"/cat/horizn-studios-transparent-liquids-bag_R00061060/");
                break;
            case "HOME":
                System.out.println("Code for Home Page");
                break;
            case  "BAG":
                globalHeaderPage.clickOnBagIcon();
                break;
        }
    }

}
