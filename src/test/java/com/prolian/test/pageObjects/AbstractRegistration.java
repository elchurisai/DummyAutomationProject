package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AbstractRegistration extends PageObject {

    @FindBy(css=".radio-group.radio-group__personal-title")
    private List<WebElement> personTitle;


    public void selectTitle(String title) {

        if (!title.isEmpty()){

            movetoElementAndClickUsingJS(getElementFromOptions(personTitle,title));
        }


    }
}
