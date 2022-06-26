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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


/*
*========================================================================================================================================
* TestUserRegistration tests the user registration capabilities of the website to make sure that valid/invalid data is correctly working.
*========================================================================================================================================
*
*/
public class TestUserRegistration extends Base{

    WebDriver driver;
    MainPage mainPage;
    AccountPage accountPage;
    SignUpPage signUpPage;
    LoginPage loginPage;


    /*================================================================================================
     * browserLauncher starts up the browser at the beginning of each test and adds an implicit wait.
     *================================================================================================
     * */
    @BeforeTest
    public void browserLauncher()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.alexandnova.com/");
    }

   /*======================================================================================================
   *tc0001_new_user_registration_test verifies that sign up page opens when registration button is clicked.
   * ======================================================================================================
   * */
    @Test(priority = 1)
    public void tc0001_new_user_registration_test() throws InterruptedException {
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

    /*============================================================================
    * tc0002_verify_register_new_user makes sure that a new user can be registered.
    * ============================================================================
    * */
    @Test(priority = 2)
    public void tc0002_verify_register_new_user() throws InterruptedException {
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

        //Verify that a Welcome message is displayed to the user.
        if(driver.findElement(By.className("page-title")).isDisplayed()) {
            System.out.println("Welcome message is displayed!");
        }else {
            System.out.println("No welcome page is displayed.");
        }
    }




    /*==========================================================================================================
    * tc0003_email_validation_no_at_test checks the email text field that has an Email address without @ symbol.
    * ==========================================================================================================
    * */
    @Test(priority = 3)
    public void tc0003_email_validation_no_at_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.inputFirstName("Fink");
        signUpPage.inputLastName("John");
        signUpPage.inputEmail("testABCperscholas.com");
        signUpPage.inputPassword("P@ssword");
        signUpPage.clickRegisterButton();
        Thread.sleep(20000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }


    /*==================================================================================================================
    * tc0004_email_validation_random_string_test checks the email text field that has an Email address without @ symbol.
    * ==================================================================================================================
    * */
    @Test(priority = 3)
    public void tc0003_email_validation_random_string_test() throws InterruptedException {
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
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }



    /*=======================================================================================================
    * tc0005_email_validation_written_at_test checks the email text field that has @ symbol written in words.
    * =======================================================================================================
    * */
    @Test(priority = 3)
    public void tc0003_email_validation_written_at_test() throws InterruptedException {
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
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }



    /*====================================================================================================================
    * tc0006_email_validation_missing_period_test checks the email text field that has a missing dot in the email address.
    * ====================================================================================================================
    * */
    @Test(priority = 3)
    public void tc0003_email_validation_missing_period_test() throws InterruptedException {
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
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }



    /*====================================================================================
    * tc0007_leave_out_mandatory_fields_test checks negative testing for mandatory fields.
    * ====================================================================================
    * */
    @Test(priority = 4)
    public void tc0004_leave_out_mandatory_fields_test() throws InterruptedException, IOException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        accountPage.clickOnRegisterButton();
        signUpPage = new SignUpPage(driver);
        signUpPage.clickRegisterButton();
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);

    }



    /*==================================================================
    * tc0008_invalid_password_test checks negative testing for passwords.
    * ==================================================================
    * */
    @Test(priority = 5)
    public void tc0005_invalid_password_test() throws InterruptedException {
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
        Thread.sleep(10000);
        loginPage = new LoginPage(driver);
        String expected = "Sorry! Please try that again.";
        String actual = loginPage.getAlertText();
        Assert.assertEquals(expected, actual);
    }

}
