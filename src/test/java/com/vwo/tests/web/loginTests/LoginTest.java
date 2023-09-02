package com.vwo.tests.web.loginTests;

import com.vwo.base.TestBase;
import com.vwo.pages.web.DashboardPage;
import com.vwo.pages.web.LoginPage;
import com.vwo.utils.PropertyReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    public LoginTest() {
        super();
    }


    @Test
    @Description("Enter the Email and Wrong Password and Click on Submit and Verify that the Dashboard is Not visible and Error Message")
    public void testWithInValidScenario(){
        //  Enter the Email and Password and Click on Submit and Verify that the Dashboard is visible
        // Call the Page Object classes here.
        // Assertions here of TestNG
        LoginPage loginPage = new LoginPage(driver);
        String expectUserName =loginPage.failLogin(PropertyReader.readItem("username"),"Wingify@1233");
        Assert.assertEquals(expectUserName,"Your email, password, IP address or location did not match");

    }

    @Test
    @Description("Enter the Email and Password and Click on Submit and Verify that the Dashboard is visible")
    public void testWithValidScenario2(){
        //  Enter the Email and Password and Click on Submit and Verify that the Dashboard is visible
        // Call the Page Object classes here.
        // Assertions here of TestNG
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage
                .loginToVWO(PropertyReader.readItem("username"),PropertyReader.readItem("password"))
                .afterSuccessfullLogin();
        String expectUserName = dashboardPage.loggedInUserName();
        Assert.assertEquals(expectUserName,PropertyReader.readItem("expectedusername"));

    }


}
