package com.prolian.test.framework;

import com.prolian.test.framework.helpers.JsonHelper;
import com.prolian.test.framework.helpers.Products;
import com.prolian.test.framework.helpers.Waiters;
import com.prolian.test.framework.helpers.WebDriverHelper;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageObject {

@Getter
    @Setter
    public static WebDriver webDriver;
    public static final int DEFAULT_POLLING_IN_MILLS = 500;
    protected WebDriverWait webDriverWait;
    private static long DRIVER_WAIT_TIME = 30;
    private static final Logger LOG = LoggerFactory.getLogger(PageObject.class);

    public static FluentWait<WebDriver> wait;

    public Waiters waiters = new Waiters(WebDriverHelper.getWebDriver());

    public static List<Products> products = new ArrayList<>();
    private JsonHelper jsonHelper = new JsonHelper();

    public PageObject() {

        webDriver = WebDriverHelper.getWebDriver();

        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10),this);
        this.wait = new FluentWait<>(WebDriverHelper.getWebDriver())
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofMillis(DEFAULT_POLLING_IN_MILLS))
                    .ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
        this.webDriverWait = new WebDriverWait(webDriver,DRIVER_WAIT_TIME);

        try {
            products = jsonHelper.loadProducts("products_url.json");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


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

    // Check if the element exists
    public boolean isElementPresentByby(By by) {


        LOG.info("Running: Is element present");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        boolean exists =  webDriver.findElements(by).size()!=0;
        webDriver.manage().timeouts().implicitlyWait(DRIVER_WAIT_TIME,TimeUnit.SECONDS);
        LOG.info("Element " +by+"exists"+ exists);
        return exists;

    }

    // Click on the element if exists

    public void clickByElement(By by) {

        if(isElementPresentByby(by)){
            webDriver.findElement(by).click();
        }
        else {
            LOG.info("Error finding the element" +by);
            LOG.info("Page Titel" +getCurrentUrl());
        }

    }

    public void timeUnitWait(int seconds) {

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Boolean isElementDisplayed(List<WebElement> element) {

        return element.size() < 1 ? false : true ;
    }

    public Boolean texttoBePresentInElementValue(final WebElement element,final String text) {

        System.out.println("The value of element" +element.getText());

        if (element.getText().contains(text)){
            return true;
        }
        return false;

    }


    protected WebElement getElementFromOptions(List<WebElement> elements,String option) {

        System.out.println(elements.stream().filter(element -> Boolean.parseBoolean(element.getAttribute("value"))));

        return elements.stream()
                .filter(delivery->delivery.getText().equalsIgnoreCase(option)).findAny()
                .orElseThrow(()-> new RuntimeException("No Element found for given option" +option ) );

    }

    protected WebElement getElementFromOptionsValue(List<WebElement> elements,String option) {

        for (WebElement element : elements) {

            System.out.println(element.getAttribute("value"));
        }

        return  elements.stream()
                .filter(delivery->delivery.getAttribute("value").equalsIgnoreCase(option)).findAny()
                .orElseThrow(()-> new RuntimeException("No Element with value for given option" +option));
    }




    public void  clearTextField(WebElement element) {

        element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

    }
    public void  enterText(WebElement element,String text) {

        visibilityOf(element);
        element.sendKeys(text);

    }

    public WebElement visibilityOf(final WebElement element) {

        return waiters.waitForElementToBeDisplay(element);
    }

}
