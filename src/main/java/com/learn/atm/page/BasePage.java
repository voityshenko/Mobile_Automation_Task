package com.learn.atm.page;

import com.learn.atm.driver.DriverManager;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }
}
