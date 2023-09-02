package com.vwo.pages.web;

import com.vwo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    // Keep the All the Element which you need that are Present at the Login Page.

    // 0. Driver available in your constructors
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    // 1. Page Locators ( Web elements)
    // email, password, submit button
    By username = By.id("login-username");
    By password = By.id("login-password" );
    By signButton = By.id("js-login-btn" );


    By errorMessage = By.id("js-notification-box-msg" );




   // Page Actions
    // 2. Enter an input into the email, enter a input into the password, click on the submit button
    public void inputUsername(String email){
        writeText(username,email);
    }

    public void inputPassword(String pass){
        writeText(password,pass);
    }

    public void clickSubmit(){
        click(signButton);
    }

    public LoginPage loginToVWO(String email, String password){
        inputUsername(email);
        inputPassword(password);
        clickSubmit();
        return this;
    }

    public DashboardPage afterSuccessfullLogin(){
        return new DashboardPage(driver);
    }

    public String failLogin(String email, String wrongpass){
        loginToVWO(email,wrongpass);
        waitForElementToAppear(errorMessage);
        return readText(errorMessage);
    }





}
