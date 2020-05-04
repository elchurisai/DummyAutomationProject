package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.Products;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(css = ".c-filter__atb.o-button.--cta" )
    private WebElement addToBagButton;

    @FindBy(css = ".c-notifications__link")
    private WebElement checkOutToast;

    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    private WebElement editLinkOnProduct;

    @FindBy(css = ".link--icon.basket-product__remove.removeItemcta")
    private List<WebElement> removeLink;

    private By acceptCookies = By.xpath("//a[contains(text(),'ACCEPT COOKIES')]");

    private By checkOut = By.linkText("Checkout");


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


    public void addProductsToBag() {

        movetoElementAndClickUsingJS(waitForElementToBeDisplay(addToBagButton));
    }

    public void clickOnCheckOutToastLink() {

       // WebDriverHelper.getWebDriver().findElement(By.linkText("Checkout")).click();

        if (isElementPresentByby(checkOut)) {
            clickByElement(checkOut);
        }
        //movetoElementAndClickUsingJS(waitForElementToBeDisplay(checkOutToast));
    }

    public Boolean isEditLinkDisplayed() {

        timeUnitWait(20);

        return isElementPresent(editLinkOnProduct);


         }

         // Remove the product from the Bag
    public void clickOnRemoveAllProducts() {

         List<WebElement> removeProducts =  getRemoveProductElement();

            if (removeProducts.size()>0) {

                System.out.println(("No of Products to be deleted " + removeProducts.size()));
                LOG.info("No of Products to be deleted " +removeProducts.size());

                for (int i = 0; i < removeProducts.size(); i++) {


                    movetoElementAndClickUsingJS(waitForElementToBeDisplay(removeProducts.get(i)));
                }

            }

   }

    private List<WebElement> getRemoveProductElement() {


        List<WebElement> itertest = waitForAllElementsToBeDisplay(removeLink);

        for (WebElement webElement : itertest) {

            System.out.println("?????????" +itertest.get(0));
        }


       return waitForAllElementsToBeDisplay(removeLink).stream().
                filter(element -> element.getAttribute("title").equalsIgnoreCase("Remove")).collect(Collectors.toList());
   }
}
