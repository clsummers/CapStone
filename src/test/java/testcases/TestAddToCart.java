package testcases;

import library.Screenshots;
import library.SelectBrowser;
import org.openqa.selenium.By;
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
    Screenshots screenshots;



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
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
//        String expectedResult = "$29.95 USD";
//        String actualResult = clearancePage.verifyPrice();
//        Assert.assertEquals(expectedResult, actualResult);
        //Add assertion: Verify the prices must show up for products on the product page
        if(driver.findElement(By.className("money")).isDisplayed()) {
            System.out.println("The product price is displayed");
        }else {
            System.out.println("The product price is not visible..");
        }

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
//        String actual = "1";
//        String expected = itemDescriptionPage.getCartCountNumber();
//        Assert.assertEquals(actual, expected);
        if(driver.findElement(By.cssSelector("a[class='cart-count navigable'] span[class='cart-count-number']")).isDisplayed()) {
            System.out.println("Product has been added to the cart page!");
        }else {
            System.out.println("The item has not been added..");
        }


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
        if(driver.findElement(By.cssSelector("a[class='cart-count navigable'] span[class='cart-count-number']")).isDisplayed()) {
            System.out.println("Product has been added to the cart page!");
        }else {
            System.out.println("The item has not been added..");
        }

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
        if(driver.findElement(By.cssSelector("a[class='cart-count navigable'] span[class='cart-count-number']")).isDisplayed()) {
            System.out.println("Product has been added to the cart page!");
        }else {
            System.out.println("The item has not been added..");
        }

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
    public void remove_product_from_cart_test() throws InterruptedException {
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


        if(driver.findElement(By.className("empty")).isDisplayed()) {
            System.out.println("Product has been added to the cart page!");
        }else {
            System.out.println("The item has not been added..");
        }


    }



}
