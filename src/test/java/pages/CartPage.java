package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "updates[]")
    WebElement cartQuantity;

    @FindBy(css = ".remove")
    WebElement clearButton;

    @FindBy(css = "input[value='Update Cart']")
    WebElement updateCartButton;

    @FindBy(className = "empty")
    WebElement emptyCartMessage;

    @FindBy(css = "button[name='checkout'] span")
    WebElement checkoutButton;

    @FindBy(css = "p[class='empty']")
    WebElement emptyCartWarning;


    public String cartWarning(){
        return emptyCartWarning.getText();
    }

    public void clearCartQuantity(){
        clearButton.click();
    }

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
