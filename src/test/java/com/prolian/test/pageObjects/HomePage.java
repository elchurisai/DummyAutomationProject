package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

  //  @FindBy(css = ".image.component.section.first.odd.last.image-language-selector")
   // private WebElement selectLangAndCurr;

    private By selectLangAndCurr =  By.linkText("GB / GBP £ | English");


    public String getHomePageURL() {

        return getCurrentUrl();
    }

    public void clickOnLeftCorner() {


        clickByElement(selectLangAndCurr);


    }



}
