package com.learn.atm;

import com.learn.atm.page.InitialViewPage;
import com.learn.atm.page.UnifyPhoneLoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UserSignInTest extends BaseTest {

    @Test
    public void checkSignInErrorForInvalidCredentials() {
        InitialViewPage initialViewPage = new UnifyPhoneLoginPage()
                .longTapSignInButton()
                .enterEmail("Lorem")
                .enterPassword("Ipsum")
                .tapSignInButton();
        assertTrue(initialViewPage.isViewDisplayed());
    }
}