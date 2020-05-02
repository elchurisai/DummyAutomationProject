package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalHeaderPage  extends PageObject {

    @FindBy(xpath = "//a[contains(text(),'Shopping Bag')]")
    private WebElement bagIcon;

    public void clickOnBagIcon() {

        movetoElementAndClickUsingJS(bagIcon);
    }

}
