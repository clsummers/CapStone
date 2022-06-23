package testcases;

import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TestAddToCart {

    WebDriver driver;
    MainPage mainPage;
    AccountPage accountPage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    ClearancePage clearancePage;
    ItemDescriptionPage itemDescriptionPage;
    CartPage cartPage;



    @BeforeTest
    public void browserLauncher()    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    //Verify the prices must show up for products on the product page
    @Test(priority = 1)
    public void verify_product_display_price_test(){
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //Add assertion: Verify the prices must show up for products on the product page
    }

        //Add Product to the cart and verify if product Is added to cart page
    @Test(priority = 2)
    public void verify_product_is_added_to_cart_test(){
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();

        //add assertions: Selected products should be added to the cart.

    }

    //Refresh the page and verify if items are still present in the cart
    @Test(priority = 3)
    public void refresh_page_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();

        Thread.sleep(2000);
        driver.navigate().refresh();
        //add Assertion: Selected products should be added to the cart.

    }

    //Increase the quantity of the product and verify if it is showing up in cart
    @Test(priority = 4)
    public void increase_quantity_test(){
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clearQuantity();
        itemDescriptionPage.changeQuantity("10");
        itemDescriptionPage.clickAddToCart();
        //add assertion: Selected products should be added to the cart with new quantity

    }

    //Verify Quantity of the products matches with amount displayed in cart
    @Test(priority = 5)
    public void verify_correct_amount_in_cart_test(){
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        //add assertion to show products and cart match up


    }

    //Remove Product from cart: Verify that the Product should be removed from the cart and the Cart icon should show 0 items.
    @Test(priority = 6)
    public void remove_product_from_cart_test(){
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartPage = new CartPage(driver);
        cartPage.clearCartQuantity();
        cartPage.clickUpdateCartButton();
        //add assertion
        String expected = "You don't have any items in your cart yet.";
        String actual = cartPage.cartWarningMessage();
        Assert.assertEquals(expected, actual);

    }



}
