package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "updates[]")
    WebElement cartQuantity;

    @FindBy(className = "cart-update button secondary")
    WebElement updateCartButton;

    @FindBy(className = "empty")
    WebElement emptyCartMessage;

    @FindBy(className = "cart-checkout button navigable")
    WebElement checkoutButton;



    public void clearCartQuantity(){
        cartQuantity.clear();
    }

    //don't need this
    public void changeQuantity(String quantity){
        cartQuantity.sendKeys(quantity);
    }

    public void clickUpdateCartButton(){
        updateCartButton.click();
    }

    public String cartWarningMessage() {
        return emptyCartMessage.getText();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

}
