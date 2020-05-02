package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerBagPage extends PageObject {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerBagPage.class);
    CheckoutFooter checkoutFooter = PageFactory.initElements(WebDriverHelper.getWebDriver(),CheckoutFooter.class);
    GlobalHeaderPage globalHeaderPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),GlobalHeaderPage.class);

    @FindBy(css = ".panel--clear.accordion div:nth-of-type(2):nth-child(3)")
    private WebElement deliverySection;

    @FindBy(css = ".col-xs-12.col-sm-6.col-md-8.col-lg-8 p")
    private List<WebElement> shoppingBagEmptyText;

    @FindBy(css = "#button--checkout")
    private WebElement continueShoppingButton;

   public boolean isDeliveryContentHeader(){

       return isElementPresent(deliverySection);
   }

    public Boolean isBasketEmpty() {

        System.out.println("The value of shoping bag empty text==" +waitForAllElementsToBeDisplay(shoppingBagEmptyText).get(0).getText());

        return isElementPresent(waitForAllElementsToBeDisplay(shoppingBagEmptyText).get(0));


    }

    public void clickContinueShopping() {

        movetoElementAndClickUsingJS(waitForElementToBeDisplay(continueShoppingButton));

    }
}
