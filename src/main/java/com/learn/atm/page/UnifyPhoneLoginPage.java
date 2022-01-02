package com.learn.atm.page;

import com.learn.atm.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class UnifyPhoneLoginPage extends BasePage {

    @AndroidFindBy(id = "com.unify.ngtc:id/login_btn")
    private MobileElement signInButton;

    @AndroidFindBy(id = "com.unify.ngtc:id/email")
    private MobileElement eMailInput;

    @AndroidFindBy(id = "com.unify.ngtc:id/password")
    private MobileElement passwordInput;

    public UnifyPhoneLoginPage longTapSignInButton() {

        TouchAction action = new TouchAction(DriverManager.getDriver());

        action.press(element(signInButton))
                .waitAction(waitOptions(ofSeconds(3)))
                .release()
                .perform();
        return this;
    }

    public UnifyPhoneLoginPage enterEmail(String email) {
        eMailInput.sendKeys(email);
        return this;
    }

    public UnifyPhoneLoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public InitialViewPage tapSignInButton() {
        signInButton.click();
        return new InitialViewPage();
    }

}
