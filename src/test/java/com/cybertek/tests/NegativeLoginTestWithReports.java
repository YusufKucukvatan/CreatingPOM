package com.cybertek.tests;

import com.cybertek.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReports extends TestBase{
    @Test
    public void wrongPasswordTestWithReports(){
        extentLogger = report.createTest("TC001 - Wrong password test");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter username: salesmanager101");
        loginPage.userName.sendKeys("salesmanager101");
        extentLogger.info("Enter password:greatpassword");
        loginPage.password.sendKeys("greatpassword");
        extentLogger.info("Click submit");
        loginPage.submit.click();
        extentLogger.info("Verify page url");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        extentLogger.info("PASS: Wrong password test");

    }

    @Test
    public void wrongUsernameTestWithReports(){
        // if we don't have the first line in test case, we will not be able to take any report...
        extentLogger = report.createTest("TC002 - Wrong username test");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter username: salesmanager101");
        loginPage.userName.sendKeys("salesmanager101");
        extentLogger.info("Enter password:greatpassword");
        loginPage.password.sendKeys("greatpassword");
        extentLogger.info("Click submit");
        loginPage.submit.click();
        extentLogger.info("Verify page url");

        Assert.assertEquals(driver.getCurrentUrl(), "https://google.com");
        extentLogger.info("FAIL: Wrong username test");

    }
}
