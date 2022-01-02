package com.learn.atm.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class InitialViewPage extends BasePage {
    @AndroidFindBy(id = "com.unify.ngtc:id/nav_host_container")
    private MobileElement initialView;

    public boolean isViewDisplayed() {
        return initialView.isDisplayed();
    }
}
