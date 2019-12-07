package com.cybertek.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report=new ExtentReports();

        // create report path
        // System.getProperty("user.dir") --> returns the location/path of my my project
        // "/test-output/report.html" --> report will be in test output folder, name --> report.html
        // It will create the "report.html" file under --> Users/yusufkucukvatan/IdeaProjects/VyTrackCreatingPOM/test-output
        String path = System.getProperty("user.dir") + "/test-output/report.html";

        //initialize the html report with report path
        htmlReporter =new ExtentHtmlReporter(path);

        // attach the html report to report object
        report.attachReporter(htmlReporter);

        //set the title of the report
        htmlReporter.config().setReportName("VyTrack smoke tests");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("browser", "chrome");
        report.setSystemInfo("my name", "yusuf"); // --> we can give more info as much as we want.
    }

    @Test
    public void test1(){
        // give name to current test case
        extentLogger=report.createTest("TC001 Login as driver test");
        // test steps
        extentLogger.info("Open chrome");
        extentLogger.info("go to url");
        extentLogger.info("enter driver login info");
        extentLogger.info("click submit");
        extentLogger.info("click verify logged in");
        extentLogger.pass("TC001 passed");
    }

    // mycase@ pffmycase@fairfaxcounty.com
    @AfterMethod
    public void close(){
        //this is when the report is actually created...
        report.flush();
    }

}
