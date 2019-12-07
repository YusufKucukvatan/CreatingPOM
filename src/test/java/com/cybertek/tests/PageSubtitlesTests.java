package com.cybertek.tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitlesTests extends TestBase {
    @Test
    public void verifySubTitleTest(){
        LoginPage loginPage=new LoginPage();
        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");
        loginPage.login(username, password);

        //get the page subtitle
        DashboardPage dashboardPage=new DashboardPage();
        String actual = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actual, "Quick Launchpad");

        //changing pages
        dashboardPage.navigateToModule("Activities", "Calendar Events");


        //get the new page's subtitle
        actual = dashboardPage.getPageSubTitle();
        Assert.assertEquals(actual, "Calendar Events");
    }
}
