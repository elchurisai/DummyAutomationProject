package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeliveryAddressPage extends PageObject {

    @FindBy(css = ".col-xs-9 .heading--step.mb-0.heading--small")
    private WebElement deliveryTypes;


    public boolean isDeliveryTypeInfoDisplayed(){

        System.out.println("--------what value-----" +texttoBePresentInElementValue(deliveryTypes,"1. Delivery"));

            return texttoBePresentInElementValue(deliveryTypes,"1. Delivery");

    }



}
