package testcases;

import library.SelectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;


/*
* ==========================================================================================
* TestAddToCart tests will make sure that items can be added and removed from the users cart
* ==========================================================================================
*
* */
public class TestAddToCart extends Base  {

    WebDriver driver;
    MainPage mainPage;
    ClearancePage clearancePage;
    ItemDescriptionPage itemDescriptionPage;
    CartPage cartPage;


/*===============================================================================================
* browserLauncher starts up the browser at the beginning of each test and adds an implicit wait.
*================================================================================================
* */
    @BeforeTest
    public void browserLauncher()    {
        driver = SelectBrowser.StartBrowser("EdgeExplore");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }


    /*===============================================================================================================
    * tc0010_verify_product_display_price_test will verify that the prices show up for products on the product page.
    * ===============================================================================================================
    * */
    @Test(priority = 1)
    public void tc0010_verify_product_display_price_test(){
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        //Add assertion: Verify the prices must show up for products on the product page
        if(driver.findElement(By.cssSelector(".product-price-minimum.money.notranslate")).isDisplayed()) {
            System.out.println("The product price is displayed");
        }else {
            System.out.println("The product price is not visible..");
        }
    }


    /*==================================================================================================
    * tc0011_verify_product_is_added_to_cart_test verifies that the add product function works properly.
    * ==================================================================================================
    * */
    @Test(priority = 11)
    public void tc0011_verify_product_is_added_to_cart_test(){
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
        if(driver.findElement(By.cssSelector("a[class='cart-count navigable'] span[class='cart-count-number']")).isDisplayed()) {
            System.out.println("Product has been added to the cart page!");
        }else {
            System.out.println("The item has not been added..");
        }

    }


    /*=============================================================================================================
    * tc0012_refresh_page_test tests that when the refresh page is clicked the items in the cart are still present.
    * =============================================================================================================
    * */
    @Test(priority = 12)
    public void tc0012_refresh_page_test() throws InterruptedException {
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

    /*======================================================================================
    * tc0013_increase_quantity_test tests that increasing the quantity shows up in the cart.
    * ======================================================================================
    * */
    @Test(priority = 13)
    public void tc0013_increase_quantity_test(){
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

    /*=======================================================================================================
    * tc0014_verify_correct_amount_in_cart_test verifies that the quantity of the product and the cart match.
    * =======================================================================================================
    * */
    @Test(priority = 14)
    public void tc0014_verify_correct_amount_in_cart_test(){
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
        //itemDescriptionPage.goToCart();
        //add assertion to show products and cart match up
        if(driver.findElement(By.className("product-option-quantity")).equals(By.className("cart-count-number"))) {
            System.out.println("Products and the cart matches up!");
        }else {
            System.out.println("The products and cart do not match up...");
        }


    }


    /*====================================================================
    * tc0015_remove_product_from_cart_test tests removing items from cart.
    * ====================================================================
    * */
    @Test(priority = 15) //Not yet working
    public void tc0015_remove_product_from_cart_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickClearanceButton();
        clearancePage = new ClearancePage(driver);
        clearancePage.selectItem();
        itemDescriptionPage = new ItemDescriptionPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        itemDescriptionPage.selectSize();
        itemDescriptionPage.selectColor();
        itemDescriptionPage.clickAddToCart();
        itemDescriptionPage.goToCart();
        Thread.sleep(3000);
        cartPage = new CartPage(driver);
        cartPage.clearCartQuantity();
        cartPage.changeQuantity("0");
        cartPage.clickUpdateCartButton();
        Thread.sleep(3000);
        String expected = "You don't have any items in your cart yet. Continue shopping .";
        String actual = cartPage.cartWarning();
        Assert.assertEquals(expected, actual);
    }

}
