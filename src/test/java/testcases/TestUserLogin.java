package testcases;

import library.SelectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SignUpPage;

import java.time.Duration;


/*
*=====================================================================================================
* TestUserLogin tests the login capabilities to make sure that valid/invalid data is working correctly.
* ====================================================================================================
* */
public class TestUserLogin {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

    /*===============================================================================================
     * browserLauncher starts up the browser at the beginning of each test and adds an implicit wait.
     *==============================================================================================
     * */
  @BeforeTest
    public void browserLauncher()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }



    /*===============================================================
    * tc0006_verify_login_user_page checks positive testing for login.
    * ===============================================================
    * */
    @Test(priority = 6)
    public void tc0006_verify_login_user_page() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("P@ssword");
        loginPage.clickLoginButton();
        if(driver.findElement(By.className("page-title")).isDisplayed()) {
            System.out.println("Login verified!");
        }else {
            System.out.println("Login is not verified..");
        }

    }


    /*========================================================================================================
    * tc0007_invalid_email_login_test verifies when passing incorrect Email and correct password to Login page.
    * ========================================================================================================
    *  */
    @Test(priority = 7)
    public void tc0007_invalid_email_login_test() throws InterruptedException {
      mainPage = new MainPage(driver);
      mainPage.clickOnAccountLink();
      loginPage = new LoginPage(driver);
      loginPage.inputEmail("test@testmail.com");
      loginPage.inputPassword("P@ssword");
      loginPage.clickLoginButton();
      //Thread sleep to allow time for captcha submission
      Thread.sleep(20000);
        //User should not be able to log in and The below error message should be displayed
        //"Sorry! Please try that again."
        if(driver.findElement(By.cssSelector(".error-message.banner")).isDisplayed()) {
            System.out.println("'Sorry! Please try that again' message was displayed");
        }else {
            System.out.println("Incorrect message was displayed..");
        }
    }
}
