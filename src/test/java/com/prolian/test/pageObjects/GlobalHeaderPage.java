package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;

import com.prolian.test.framework.helpers.TestContext;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalHeaderPage  extends PageObject {

    @FindBy(xpath = "//a[contains(text(),'Shopping Bag')]")
    private WebElement bagIcon;


    public void clickOnBagIcon() {

         movetoElementAndClickUsingJS(bagIcon);

    }

}
