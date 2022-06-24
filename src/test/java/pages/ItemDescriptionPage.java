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

    @FindBy(css = "label[for='val232536788178500']")
    WebElement size;


    @FindBy(css = "label[for='val23253678817851-0']")
    WebElement colorBlack;

    @FindBy(css= "input[value='Add to cart']")
    WebElement addToCart;

    @FindBy(className = "product-option-quantity")
    WebElement itemQuantity;

    @FindBy(css = "a[class='cart-count navigable'] span[class='cart-count-text']")
    WebElement cartButton;

    @FindBy(xpath = "1")
    WebElement cartCountNumber;

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
