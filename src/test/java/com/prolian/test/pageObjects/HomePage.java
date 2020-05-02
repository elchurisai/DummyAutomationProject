package com.prolian.test.pageObjects;

import com.prolian.test.framework.PageObject;

public class HomePage extends PageObject {


    public String getHomePageURL() {

        return getCurrentUrl();
    }

}
