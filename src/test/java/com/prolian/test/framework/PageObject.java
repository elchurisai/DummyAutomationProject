package com.prolian.test.framework;

import com.prolian.test.framework.helpers.Waiters;
import com.prolian.test.framework.helpers.WebDriverHelper;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageObject {

    @Getter
    @Setter
    public static WebDriver webDriver;
    public static final int DEFAULT_POLLING_IN_MILLS = 500;
    protected WebDriverWait webDriverWait;
    private static long DRIVER_WAIT_TIME = 30;

    public static FluentWait<WebDriver> wait;

    public Waiters waiters = new Waiters(WebDriverHelper.getWebDriver());



    public PageObject() {

        webDriver = WebDriverHelper.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10),this);
        this.wait = new FluentWait<>(WebDriverHelper.getWebDriver())
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_IN_MILLS))
                    .ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
        this.webDriverWait = new WebDriverWait(webDriver,DRIVER_WAIT_TIME);
    }



    public void movetoElementAndClickUsingJS(WebElement element) {

        System.out.println("The value of element" +element);
        scrollIntoView(element);
        clickUsingJS(element);
    }

    public void clickUsingJS(WebElement element) {
        System.out.println("The value of WebDriver" +WebDriverHelper.getWebDriver());

        ((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript("arguments[0].click()",element);
    }

    public void scrollIntoView(WebElement element) {

        System.out.println("The value of WebDriver" +WebDriverHelper.getWebDriver());

        if(WebDriverHelper.getWebDriver() instanceof JavascriptExecutor){
            ((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript("arguments[0].scrollIntoView();",element);
        }
    }

    public boolean isElementPresent(WebElement element) {

        try {

            return element.getLocation() != null;

        } catch (NullPointerException  | NoSuchElementException | StaleElementReferenceException e) {

            return false;
        }

    }


    public  List<WebElement> waitForAllElementsToBeDisplay(List<WebElement> elements) {

        return waiters.waitForAllElementsToBeDisplay(elements);

    }

    public WebElement waitForElementToBeDisplay(WebElement element) {


        return  waiters.waitForElementToBeDisplay(element);
    }

    public String getCurrentUrl(){

        System.out.println("The current URL is === "+webDriver.getCurrentUrl());
        return webDriver.getCurrentUrl();
    }

}
