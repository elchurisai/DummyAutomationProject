package com.prolian.test.framework.helpers;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.prolian.test.models.cucumber.UserInformationModel;

public class DataGenerator {

    private static final DataGenerator dataGenerator = new DataGenerator();

    private static Person person;

    private static UserInformationModel userInformationModel;

    private DataGenerator(){
    }

    public static DataGenerator getInstance() {

        return dataGenerator;
    }


    public void setPerson() {

        Fairy fairy = Fairy.create();
        person = fairy.person();
        buildUserInfo(person);

    }


    private void buildUserInfo(Person faker) {

       this.userInformationModel  = new UserInformationModel("Mr",faker.getFirstName(),faker.getLastName(),
                "Auto"+faker.getEmail(),faker.getPassword()
                +"a2M!",
                "1 Millar Street",
                "",
                "Wokingham",
                "RG41 3UG",
                "07824429587",
                "United Kingdom",
                "1");



        }

    public void deletePerson() {
        if (this.userInformationModel!=null){
            userInformationModel =null;
        }
    }

    public static UserInformationModel getUserInfo(){
        return userInformationModel;
    }

}
