package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


/*==============================================================================================
* Incorporates creating html reports, taking and filing screenshots, and tearing down the tests.
* ==============================================================================================
* */

public class Base {

    WebDriver driver;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extentReports;

/*=============
* HTML reports
* =============*/
    @BeforeSuite
    public void buildReport(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/HTMLReport.html");
        extentReports = new ExtentReports();

        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Host Name", "Collin");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("User Name", "Collin Summers");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Alex and Nova Test Automation Report");
        htmlReporter.config().setReportName("Alex and Nova Test Automation Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    /*===============================================================
    * Creates the name of the reports to correspond with the methods.
    * ===============================================================
    * */
    @BeforeMethod
    public void setupReports(Method method) throws IOException {
        String name = method.getName();
        test =  extentReports.createTest(name);
        test.addScreenCaptureFromPath(name + ".png");
    }

    /*================================================
    * Reports on each test and logs if they pass/fail.
    * ================================================
    * */
    @AfterMethod
    public void recordResults(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File("test-output/xml/" + result.getName() + ".png"));
            test.log(Status.FAIL, result.getThrowable());
            driver.quit();
        }

        else if (result.getStatus() == ITestResult.SUCCESS) {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File("test-output/xml/" + result.getName() + ".png"));
            test.log(Status.PASS, result.getTestName());
            driver.quit();
        }

        else {
            test.log(Status.SKIP, result.getTestName());
            driver.quit();
        }
    }

    /*======================
    * Closes down each test.
    * ======================
    * */
    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }
}
