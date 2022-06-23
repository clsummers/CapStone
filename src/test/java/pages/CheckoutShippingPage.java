package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutShippingPage {

    WebDriver driver;

    public CheckoutShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "continue_button")
    WebElement continueToPaymentButton;


    public void clickOnContinueToPaymentButton(){
        continueToPaymentButton.click();
    }

}
