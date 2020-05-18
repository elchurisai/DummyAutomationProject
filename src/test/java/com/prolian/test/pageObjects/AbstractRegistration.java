package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.PanelUI;
import java.util.List;

public abstract class AbstractRegistration extends PageObject {

    @FindBy(css=".radio-group__label")
    private List<WebElement> personTitle;

    @FindBy(name = "firstName")
    private WebElement firstNameTextField;

    @FindBy(id = "registerLogonId")
    private WebElement emailTextField;

    @FindBy(name = "lastName")
    private WebElement lastNameTextField;

    @FindBy(name = "userField3")
    private List<WebElement> marketingPreference;


    public void selectTitle(String title) {

        if (!title.isEmpty()){

            movetoElementAndClickUsingJS(getElementFromOptions(personTitle,title));
            System.out.println("?????????" +title);
        }
    }


    public void enterFirstName(String firstName) {

        clearTextField(firstNameTextField);
        enterText(firstNameTextField,firstName);

    }


    public void enterLastName(String lastName) {

        clearTextField(lastNameTextField);
        enterText(lastNameTextField,lastName);

    }

    public void  enterEmail(String email) {

        clearTextField(emailTextField);
        enterText(emailTextField,email);
    }

    public void selectMarketingPreference(String preference) {

        if (!preference.isEmpty()){

        movetoElementAndClickUsingJS(getElementFromOptionsValue(marketingPreference,preference));
        }
    }




}
