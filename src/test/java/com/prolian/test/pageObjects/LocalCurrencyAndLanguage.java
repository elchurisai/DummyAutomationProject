package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LocalCurrencyAndLanguage  extends PageObject {


    @FindBy(css = ".content .js-custom-select-wrapper")
    private List<WebElement> localCurrency;

    @FindBy(css =".content .js-custom-select-wrapper li")
    private List<WebElement> localc;

   //   @FindBy(css = "#languages option")
   // private List<WebElement> localLanguage;


   @FindBy(xpath = "//span[contains(text(),'English')]")
    private List<WebElement> localLanguage;


    @FindBy(css = ".js-custom-select-options li")
    private List<WebElement> localL;



    @FindBy(css = ".btn-black.cta.flyout-continue")
    private WebElement clickContinue;



    public void selectLocalCurrency(String currencyTxt) {



        clickValueFromDropDownByWebElement(localCurrency,currencyTxt);
        selectValueFromDropDownByWebElement(localc,currencyTxt);


    }

    public void selectLanguage(String languageTxt) {



          //  System.out.println("??????" +localLanguage.getAttribute("value"));
           // System.out.println("??????" +localLanguage.getTagName());
           // System.out.println("??????" +localLanguage.getText());
        clickValueFromDropDownByWebElement(localLanguage,languageTxt);
        selectValueFromDropDownByWebElement(localL,languageTxt);
       timeUnitWait(300);



    }

}
