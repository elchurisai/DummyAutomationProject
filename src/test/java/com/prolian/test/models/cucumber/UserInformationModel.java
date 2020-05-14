package com.prolian.test.models.cucumber;

public class UserInformationModel {


    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String country;
    private String addressLine;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String password;
    private String marketingPreference;

     public UserInformationModel(String title,String firstName,String lastName,String email,String password,
                                 String addressLine1,String addressLine2, String city,String postCode,
                                 String mobile,String country,String marketingPreference) {

            this.title=title;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.addressLine =addressLine;
            this.addressLine1 = addressLine1;
            this.addressLine2 =addressLine2;
            this.city = city;
            this.postCode= postCode;
            this.mobile= mobile;
            this.country= country;
            this.marketingPreference= marketingPreference;

     }


}
