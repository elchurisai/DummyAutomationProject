package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.helpers.Products;
import com.prolian.test.framework.helpers.TestContext;
import com.prolian.test.framework.helpers.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class CheckoutFooter extends PageObject {


    private GlobalHeaderPage globalHeaderPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),GlobalHeaderPage.class);
    private By acceptCookies = By.xpath("//a[contains(text(),'ACCEPT COOKIES')]");


    //    private CustomerBagPage customerBagPage = PageFactory.initElements(WebDriverHelper.getWebDriver(),CustomerBagPage.class);

    public void clickOnNavigationItem(String item,String productType) {

        switch (item.toUpperCase()) {

            case "PDP":
                // This Code is

                System.out.println("This is inside");

              //  System.out.println(products.stream().filter(products1 -> Boolean.parseBoolean(products1.getProductURL())));

            //    System.out.println(products.stream().filter(products1 -> products1.getType().equalsIgnoreCase(productType)).findAny().orElseThrow(() -> new RuntimeException("simple execption" + productType)));

                if (isElementPresentByby(acceptCookies)){
                    clickByElement(acceptCookies);
                }

                System.out.println(products.stream().filter(products1 -> products1.getType().equalsIgnoreCase(productType)).findAny().orElseThrow(() -> new RuntimeException("simple execption" + productType)).getProductURL());

                // System.out.println(products.stream().filter(products1 -> products1.equals(productType)).findAny());
              //  System.out.println(products.stream().filter(products1 -> products1.equals(productType)).findAny().orElseThrow(() -> new RuntimeException("no product found with the given type" + productType)));
             //   WebDriverHelper.getWebDriver().navigate().to(TestContext.getInstance().getBaseURL().toString()+"/cat/horizn-studios-transparent-liquids-bag_R00061060/");

                WebDriverHelper.getWebDriver().navigate().to(TestContext.getInstance().getBaseURL().toString()+products.stream().filter(products1 -> products1.getType().equalsIgnoreCase(productType)).findAny().orElseThrow(() -> new RuntimeException("simple execption" + productType)).getProductURL());

                break;
            case "HOME":
                System.out.println("Code for Home Page");
                break;
            case  "BAG":

                if (isElementPresentByby(acceptCookies)){
                    clickByElement(acceptCookies);
                }

                globalHeaderPage.clickOnBagIcon();
                break;
        }
    }

}
