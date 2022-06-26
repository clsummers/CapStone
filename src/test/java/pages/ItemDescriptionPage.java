package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDescriptionPage {

    WebDriver driver;

    public ItemDescriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[text()='US 4.5']")
    WebElement size;


    @FindBy(xpath = "//*[@id=\"bcpo-select-option-1\"]/div[1]/label")
    WebElement colorBlack;

    @FindBy(css= "input[value='Add to cart']")
    WebElement addToCart;

    @FindBy(className = "product-option-quantity")
    WebElement itemQuantity;

    @FindBy(css = "a[class='cart-count navigable'] span[class='cart-count-text']")
    WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[2]/a/span[2]")
    WebElement cartCountNumber;

    @FindBy(css = ".checkout-link.navigable")
    WebElement checkoutNavButton;

    public void clickCheckoutNavButton(){
        checkoutNavButton.click();
    }

    public String getCartCountNumber(){
        return driver.findElement((By) cartCountNumber).getText();
    }


    public void selectSize(){
        size.click();
    }

    public void selectColor(){
        colorBlack.click();
    }

    public void goToCart(){
        cartButton.click();
    }

    public void clickAddToCart(){
        addToCart.click();
    }

    public void clearQuantity(){
        itemQuantity.clear();
    }

    public void changeQuantity(String quantity){
        itemQuantity.sendKeys(quantity);
    }






}
