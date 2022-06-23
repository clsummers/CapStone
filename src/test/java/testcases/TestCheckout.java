package testcases;

import library.SelectBrowser;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TestCheckout {

    WebDriver driver;
    MainPage mainPage;
    ClearancePage clearancePage;
    ItemDescriptionPage itemDescriptionPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;
    CheckoutShippingPage checkoutShippingPage;
    CheckoutPaymentPage checkoutPaymentPage;


    @BeforeTest
    public void browserLauncher() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    //Credit Card (Visa/Master)
    //Debit Card (Visa/MasterCard/Maestro)
    //Paid by Paypal
    //Paid by shop pay
    //Paid by zip
    @Test(priority = 1)
    public void master_card_payment_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(20000);
        // build login.clearance
        loginPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        Thread.sleep(20000);
        itemDescriptionPage = new ItemDescriptionPage(driver);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputAddress("123 address road");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        //add assertion: Master Card
        Thread.sleep(20000);
        String expected = "Master Card";
        String actual = checkoutPaymentPage.checkForMasterCard();
        Assert.assertEquals(expected, actual);


    }

    @Test(priority = 2)
    public void visa_card_payment_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(20000);
        // build login.clearance
        loginPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        Thread.sleep(20000);
        itemDescriptionPage = new ItemDescriptionPage(driver);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputAddress("123 address road");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        //add assertion: Master Card
        Thread.sleep(20000);
        String expected = "Visa";
        String actual = checkoutPaymentPage.checkForVisa();
        Assert.assertEquals(expected, actual);
    }

    @Test(priority = 3)
    public void paypal_payment_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(20000);
        // build login.clearance
        loginPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        Thread.sleep(20000);
        itemDescriptionPage = new ItemDescriptionPage(driver);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputAddress("123 address road");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        //add assertion: Master Card
        Thread.sleep(20000);
        String expected = "PayPal";
        String actual = checkoutPaymentPage.checkForPayPal();
        Assert.assertEquals(expected, actual);
    }

    @Test(priority = 4)
    public void shop_pay_payment_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnAccountLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("P@ssword");
        loginPage.clickLoginButton();
        Thread.sleep(20000);
        // build login.clearance
        loginPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        Thread.sleep(20000);
        itemDescriptionPage = new ItemDescriptionPage(driver);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputAddress("123 address road");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        //add assertion: Master Card
        Thread.sleep(20000);
        String expected = "Shop Pay";
        String actual = checkoutPaymentPage.checkForShopPay();
        Assert.assertEquals(expected, actual);
    }
}