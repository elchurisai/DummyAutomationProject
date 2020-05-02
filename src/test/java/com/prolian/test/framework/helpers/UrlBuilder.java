package com.prolian.test.framework.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

public class UrlBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(UrlBuilder.class);
    private static final String RUN_CONFIG_PROPERTIES = "/environment.properties";
    private TestContext testContext = TestContext.getInstance();
    // private static URL apiUrl;

    static {
        try {
            TestContext.getInstance().setBaseURL("GB/en/");
            // apiUrl = new URL(Props.getMessage("api.url"));
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    public void goToHomePage() {

        System.out.println("This is on Home Page ");
        if (!(WebDriverHelper.getSpecificWebDriver(testContext.getDevice()).getCurrentUrl().equalsIgnoreCase(testContext.getBaseURL().toString()))) {
            WebDriverHelper.getWebDriver().navigate().to(testContext.getBaseURL());
            System.out.println(WebDriverHelper.getWebDriver().getTitle());
            //  System.out.println("Print the details" +cookiedetail);
            // WebDriverHelper.getWebDriver().manage().addCookie(cookiedetail);

            WebDriverHelper.getWebDriver().findElement(By.xpath("//a[contains(text(),'ACCEPT COOKIES')]")).click();
        }
    }


}
