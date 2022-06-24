package testcases;

import library.Screenshots;
import library.SelectBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SignUpPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestUserRegistration {

    WebDriver driver;
    MainPage mainPage;
    AccountPage accountPage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    Screenshots screenshots;



    @BeforeTest
    public void browserLauncher()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.alexandnova.com/");
    }

   //
    @Test(priority = 1)
    public void new_user_registration_test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
       mainPage.clickOnAccountLink();
       accountPage = new AccountPage(driver);
       accountPage.clickOnRegisterButton();
       signUpPage = new SignUpPage(driver);
       String expected = "Sign up";
       String actual = signUpPage.getTextOfTitle();
        Assert.assertEquals(actual, expected);


    }

    @Test(priority = 2)
    public void verify_register_new_user() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("testABC@perscholas.com");
        signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(10000);
    }


   //Check the Email text field that has an Email address without @ symbol.
    @Test(priority = 3)
    public void email_validation_no_at_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("testABCperscholas.com");
        signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(20000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }

    //Check the Email text field that has an Email address without @ symbol.
    @Test(priority = 4)
    public void email_validation_random_string_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("emailemailemail");
        signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }


    // Check the Email text field that has @ symbol written in words
    @Test(priority = 5)
    public void email_validation_written_at_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("testABCatperscholas.com");
        signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }


    //Check the Email text field that has a missing dot in the email address.
    @Test(priority = 6)
    public void email_validation_missing_period_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("testABC@perscholascom");
        signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }


   //Negative testing for Mandatory fields
    @Test(priority = 7)
    public void leave_out_mandatory_fields_test() throws InterruptedException, IOException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        //signUpPage.inputFirstName("Fink");
        //signUpPage.inputLastName("John");
        //signUpPage.inputEmail("testABC@perscholascom");
        //signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
//        // take screenshot
        //File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("C:\\Users\\colli\\Summers_Collin_Capstone_CaseStudy\\Summers_Collin_Capstone_CaseStudy\\src\\test\\resources\\screenshots"));

    }


    //Negative testing for password
    @Test(priority = 8)
    public void invalid_password_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("testABC@perscholascom");
        signUpPage.inputPassword("passw");
        signUpPage.clickRegisterButton();
        //check to see if captcha comes up and add thread sleep
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }

    @AfterMethod
    public void takeScreenShot() {
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("C:\\Users\\colli\\Summers_Collin_Capstone_CaseStudy\\Summers_Collin_Capstone_CaseStudy\\src\\test\\resources\\screenshots"));
            System.out.println("Taking screenshot");
        } catch (Exception e)
        {
            System.out.println("Could not save screenshot. Hey there mom.");
        }
    }



}
