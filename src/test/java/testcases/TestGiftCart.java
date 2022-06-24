package testcases;

import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TestGiftCart {

    WebDriver driver;
    MainPage mainPage;
    ClearancePage clearancePage;
    ItemDescriptionPage itemDescriptionPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;


    @BeforeTest
    public void browserLauncher()    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.alexandnova.com/");
    }


    //verify that user can apply for a discount code at checkout page
    @Test(priority = 1)
    public void apply_discount_code_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        Thread.sleep(3000);
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        Thread.sleep(3000);
        itemDescriptionPage.goToCart();

        cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        Thread.sleep(3000);
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCouponCode("MASK15");
        Thread.sleep(3000);
        checkoutPage.clickOnApplyButton();

        String expectedResult = "Discount";
        String actualResult = checkoutPage.verifyDiscount();
        Assert.assertEquals(expectedResult, actualResult);



    }
}
