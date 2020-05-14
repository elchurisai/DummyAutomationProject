package com.prolian.test.pageObjects;

import com.prolian.test.models.cucumber.UserInformationModel;

public class RegistrationPage  extends  AbstractRegistration{


    public void fillUserDetailsForm(UserInformationModel  userInformationModel) {

        selectTitle("Mr");
        timeUnitWait(300);
    }


}
