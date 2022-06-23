package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDescriptionPage {

    WebDriver driver;

    public ItemDescriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "label[for='val450286895109300']")
    WebElement sizeAdult;

    @FindBy(css = "label[for='val45028689510931-0']")
    WebElement colorWhite;

    @FindBy(className = "add-to-cart")
    WebElement addToCart;

    @FindBy(className = "product-option-quantity")
    WebElement itemQuantity;

    @FindBy(className = "cart-count-text")
    WebElement cartButton;


    public void selectSize(){
        sizeAdult.click();
    }

    public void selectColor(){
        colorWhite.click();
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

    public void goToCart(){
        cartButton.click();
    }




}
