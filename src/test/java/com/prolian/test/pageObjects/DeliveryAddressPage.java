package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeliveryAddressPage extends PageObject {

    @FindBy(css = ".col-xs-9 .heading--step.mb-0.heading--small")
    private WebElement deliveryTypes;

    @FindBy(css = "#Home_Delivery_Method")
    private List<WebElement> deliveryDetails;

    @FindBy(name = "selectDeliveryType")
    private WebElement chooseDeliveryMethod;

    @FindBy(id = "selectClickAndCollect")
    private WebElement clickAndCollectRadio;

    @FindBy(css = ".alert--error p")
    private WebElement alertMessage;

    public boolean isDeliveryTypeInfoDisplayed(){

        System.out.println("--------what value-----" +texttoBePresentInElementValue(deliveryTypes,"1. Delivery"));

            return texttoBePresentInElementValue(deliveryTypes,"1. Delivery");

    }

    public Boolean isDeliveryInforDisplayed() {


                return isElementDisplayed(deliveryDetails);
    }


    public String radClickAndCollectRadioGetMessage(){

        clickUsingJS(clickAndCollectRadio);

        return alertMessage.getAttribute("innerText");
    }



}
