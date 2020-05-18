package com.prolian.test.pageObjects;

import com.prolian.test.models.cucumber.UserInformationModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage  extends  AbstractRegistration{

    @FindBy(name = "continueToDelivery")
    private WebElement continueToDeliveryButton;

    public void fillUserDetailsForm(UserInformationModel  userInformationModel) {

        selectTitle("Mr");
        enterPersonDetails(userInformationModel);


    }

    private void enterPersonDetails(UserInformationModel userInformationModel) {

        enterFirstName(userInformationModel.getFirstName());
        enterLastName(userInformationModel.getLastName());
        enterEmail(userInformationModel.getEmail());
        selectMarketingPreference("Y");
    }

    public void clickOnContinueToDeliveryButton() {

        movetoElementAndClickUsingJS(continueToDeliveryButton);
    }

}
