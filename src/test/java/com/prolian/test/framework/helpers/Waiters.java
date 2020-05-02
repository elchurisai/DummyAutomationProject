package com.prolian.test.framework.helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Waiters {

    private WebDriver driver;

    private static final int DEFAULT_POLLING_IN_MILLS =500;

    public static FluentWait<WebDriver> wait;

    public Waiters(WebDriver driver) {
        this.driver= driver;
        this.wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(DEFAULT_POLLING_IN_MILLS))
                    .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
    }


    public FluentWait<WebDriver> getWait(){ return  wait;}

    public List<WebElement> waitForAllElementsToBeDisplay(List<WebElement> elements) {

        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));

    }


    public WebElement waitForElementToBeDisplay(WebElement element) {

        System.out.println("The element displayed????"+element+"The expected condtion is"+ExpectedConditions.visibilityOf(element));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
