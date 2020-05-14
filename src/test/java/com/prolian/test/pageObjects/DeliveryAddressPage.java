package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeliveryAddressPage extends PageObject {

    @FindBy(id = "deliveryChoices")
    private List<WebElement> deliveryTypes;


    public boolean isDeliveryTypeInfoDisplayed(){

        return isElementDisplayed(deliveryTypes);
    }



}
