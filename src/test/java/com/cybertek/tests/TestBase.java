package com.cybertek.tests;

        import com.aventstack.extentreports.ExtentReports;
        import com.aventstack.extentreports.ExtentTest;
        import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
        import com.cybertek.utilities.BrowserUtils;
        import com.cybertek.utilities.ConfigurationReader;
        import com.cybertek.utilities.Driver;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.testng.ITestResult;
        import org.testng.annotations.*;

        import java.io.IOException;
        import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    protected  String url;
    Actions action;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;


    @BeforeTest
    public  void  setUpTest(){
        //initialize the object
        report=new ExtentReports();

        // create report path
        // System.getProperty("user.dir") --> returns the location/path of my project (/Users/yusufkucukvatan/IdeaProjects/VyTrackCreatingPOM)
        // "/test-output/report.html" --> report will be in test-output folder, name --> report.html
        // It will create the "report.html" file under --> Users/yusufkucukvatan/IdeaProjects/VyTrackCreatingPOM/test-output
        String path = System.getProperty("user.dir") + "/test-output/report.html";

        //initialize the html report with report path
        htmlReporter =new ExtentHtmlReporter(path);

        // attach the html report to report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Regression tests");
        report.setSystemInfo("Environment ","QA");
        report.setSystemInfo("Browser ",ConfigurationReader.get("browser"));
        report.setSystemInfo("OS ",System.getProperty("os.name"));

    }

    @AfterTest
    public void tearDown(){
        report.flush();
    }
    @BeforeMethod
    public void setupMethod() {
        driver = Driver.get();
        url =  ConfigurationReader.get("url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();


    }

    @AfterMethod
    public void teardown(ITestResult result) throws InterruptedException, IOException {
        //IF TEST FAILED TAKE SCREENSHOT
        if(result.getStatus()==ITestResult.FAILURE){
            // Record the name of the failed test
            extentLogger.fail(result.getName());
            //take screenshot and return the location
            String screenshot= BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshot);
            //capture the exception
            extentLogger.fail(result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test Skipped: "+result.getName());
        }
        //Close browser
        Thread.sleep(1000);
        Driver.closeDriver();
    }

}