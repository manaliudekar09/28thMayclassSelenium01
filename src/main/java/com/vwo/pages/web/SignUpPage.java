package com.vwo.pages.web;

import com.vwo.base.BasePage;
import org.openqa.selenium.WebDriver;

public class SignUpPage  extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    // go to the vwo.com/freetail
    public void goToFreeTrial() {
        goToUrl("https://vwo.com/free-trial/");
    }
}
