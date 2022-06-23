package testcases;

import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SignUpPage;

import java.time.Duration;

public class TestUserLogin {

    WebDriver driver;
    MainPage mainPage;
    AccountPage accountPage;
    SignUpPage signUpPage;
    LoginPage loginPage;



  @BeforeTest
    public void browserLauncher()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }


   // Positive testing for login
    @Test(priority = 1)
    public void verify_login_user_page() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        //check to see if captcha comes up and add thread sleep
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(10000);

        //Add assertion: Verify that the User Dashboard Page is displayed.

    }

    //Verify when passing incorrect Email and correct password to Login page
    @Test(priority = 2)
    public void invalid_email_login_test() throws InterruptedException {
      mainPage = new MainPage(driver);
      mainPage.clickOnAccountLink();
      loginPage = new LoginPage(driver);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      loginPage.inputEmail("test@testmail.com");
      loginPage.inputPassword("P@ssword");
      loginPage.clickLoginButton();
      //Thread sleep to allow time for captcha submission
      Thread.sleep(20000);
      String expected = "Sorry! Please try that again.";
      String actual = loginPage.getAlertText();
      Assert.assertEquals(expected, actual);
    }
}
