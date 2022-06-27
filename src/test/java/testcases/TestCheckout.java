package testcases;

import library.SelectBrowser;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

/*============================================================================================
* TestCheckout tests out different payment methods and instances of valid/invalid credit cards.
* ============================================================================================
* */

public class TestCheckout {

    WebDriver driver;
    MainPage mainPage;
    ClearancePage clearancePage;
    ItemDescriptionPage itemDescriptionPage;
    CheckoutPage checkoutPage;
    CheckoutShippingPage checkoutShippingPage;
    CheckoutPaymentPage checkoutPaymentPage;


    /*==============================================================================================
     * browserLauncher starts up the browser at the beginning of each test and adds an implicit wait.
     *==============================================================================================
     * */
    @BeforeTest
    public void browserLauncher() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }


    /*=======================================================================================================================================
    * tc0017_different_payment_mode_test tests that different forms of payment (i.e. credit card, PayPal, Shop Pay) are available at checkout.
    * =======================================================================================================================================
    * */
    @Test(priority = 17)
    public void tc0017_different_payment_mode_test() throws InterruptedException {

        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        Thread.sleep(3000);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        Thread.sleep(3000);
        itemDescriptionPage.clickCheckoutNavButton();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterEmail("test@gmail.com");
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Fink");
        Thread.sleep(3000);
        checkoutPage.inputAddress("123 Street");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        Thread.sleep(3000);
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        Thread.sleep(3000);
        //credit card assertion
        String creditActual = "Credit card";
        String creditExpected = checkoutPaymentPage.verifyCreditCardOption();
        Assert.assertTrue(creditExpected.contains(creditActual));
        //Shop pay assertion
        String shopActual = "Shop Pay";
        String shopExpected = checkoutPaymentPage.verifyShopPayOption();
        Assert.assertEquals(shopActual, shopExpected);
        //PayPal assertion
        String payActual = "PayPal";
        String payExpected = checkoutPaymentPage.verifyPayPalOption();
        Assert.assertEquals(payActual, payExpected);


    }


    /*=======================================================================================================================================================================
    * tc0018_invalid_card_payment_test tests the check-out process by leaving any mandatory field blank in the creditcard payment information and shipping or billing address.
    * ========================================================================================================================================================================
    * */
    @Test(priority = 18)
    public void tc0018_invalid_card_payment_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        Thread.sleep(3000);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        Thread.sleep(3000);
        itemDescriptionPage.goToCart();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckOutBtn();
        checkoutPage.enterEmail("test@gmail.com");
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Fink");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkoutPage.inputAddress("123 Street");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        Thread.sleep(3000);
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        Thread.sleep(3000);
        checkoutPaymentPage.switchToCardNumberFrame();
        checkoutPaymentPage.enterCardNumber("12345678");
        checkoutPaymentPage.switchToParentFrame();
        checkoutPaymentPage.switchToNameFrame();
        checkoutPaymentPage.enterName("John Fink");
        checkoutPaymentPage.switchToParentFrame();
        checkoutPaymentPage.switchToDateFrame();
        checkoutPaymentPage.enterExpirationDate("06");
        checkoutPaymentPage.enterExpirationDate("2005");
        checkoutPaymentPage.switchToParentFrame();
        checkoutPaymentPage.clickPayNow();
        //Assertion
        String actual = "Your payment details couldn’t be verified. Check your card details and try again.";
        String expected = checkoutPaymentPage.showPaymentError();
        Assert.assertEquals(expected, actual);

    }


    /*======================================================================================
    * tc0019_payment_details_test tests that the payment button exists on the checkout page.
    * ======================================================================================
    * */
    @Test(priority = 19)
    public void tc0019_payment_details_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        Thread.sleep(3000);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        Thread.sleep(3000);
        itemDescriptionPage.goToCart();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckOutBtn();
        checkoutPage.enterEmail("test@gmail.com");
        checkoutPage.enterFirstName("John");
        checkoutPage.enterLastName("Fink");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkoutPage.inputAddress("123 Street");
        checkoutPage.inputCity("Austin");
        checkoutPage.inputZip("75781");
        checkoutPage.clickContinueToShipping();
        Thread.sleep(3000);
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.clickOnContinueToPaymentButton();
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        Thread.sleep(3000);
        if(driver.findElement(By.xpath("//*[@id=\\\"continue_button\\\"]/span")).isDisplayed()) {
            System.out.println("Payment button exists on checkout page!");
        }else {
            System.out.println("Payment button does not exist on checkout page..");
        }

    }

}