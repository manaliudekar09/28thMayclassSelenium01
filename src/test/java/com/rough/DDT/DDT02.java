package com.rough.DDT;

import com.rough.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DDT02 {


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(dataProvider = "getData")
    public void testLoginExcelFile(String email, String password, String expectedResult) {
        // Navigate to URL
        // Email and Passw -> enter
        // Click - if ( valid -> Dashboard will be shown
        // If (In valid -> ERROR message)
        System.out.println(email + password + expectedResult);
        driver.get("https://app.vwo.com");
        WebElement emailElement = driver.findElement(By.id("login-username"));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        if (expectedResult.equalsIgnoreCase("InValid")) {
            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(error_message));
            Assert.assertTrue(error_message.isDisplayed());
            Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        }

        if (expectedResult.equalsIgnoreCase("Valid")) {
            WebElement dashboard = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(dashboard));
            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
            System.out.println(text);
            Assert.assertEquals(text, "Wingify");
        }


    }


    @DataProvider(name = "getData")
    public Object[][] getMeDataForLogin() throws IOException {
        //
        String filepath  = "src/test/resources/TestData.xlsx";
        ExcelReader excelReader = new ExcelReader(filepath);
        String [][] data = excelReader.getDataFromSheet(filepath,"LoginData");
        return data;
    }


    @AfterClass
    public void teardoWN() {
        driver.quit();
    }


}
