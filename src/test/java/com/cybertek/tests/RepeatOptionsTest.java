package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatOptionsTest extends TestBase{
    /*
    Verify radio buttons
    Open browser
    Login as a driver
    Go to Activities --> Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat everyday is checked
    Verify that repeat weekday is not checked

     */

    @Test
    public void radioRepeatEveryRadioButtonsTest(){
        LoginPage loginPage=new LoginPage();
        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //Click on the Create Calendar Events
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        //This line is waiting until the page load completes
        calendarEventsPage.waitUntilLoaderScreenDisappear(); //--> without doing this we cannot get rid of loader screen
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createcalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createcalendarEventsPage.repeat.click();

        // Verify that repeat everyday is checked
        Assert.assertTrue(createcalendarEventsPage.days.isSelected(), "Repeat Every Day(s) was supposed to be selected...");

        // Verify that repeat weekday is not checked
        Assert.assertFalse(createcalendarEventsPage.weekday.isSelected(), "Repeat Week Day(s) was not supposed to be selected...");

    }


}
