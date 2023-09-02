package com.vwo.base;

import com.vwo.utils.DriverManger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBase extends DriverManger {
    // Driver
    // Util for the Test
    public WebDriver driver;

    protected TestBase(){
        this.driver = super.getDriver();
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        goToUrl("https://app.vwo.com");
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    public void goToUrl(String url){
        driver.get(url);
    }



}
