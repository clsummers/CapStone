package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "checkout_reduction_code")
    WebElement discountCode;

    @FindBy(id = "checkout_submit")
    WebElement applyButton;

    @FindBy(className = "field field--required field--show-floating-label")
    WebElement addressColumn;

    @FindBy(id = "checkout_shipping_address_city")
    WebElement cityColumn;

    @FindBy(id = "checkout_shipping_address_zip")
    WebElement zipColumn;

    @FindBy(id = "continue_button")
    WebElement continueToShippingButton;


    public void enterDiscountCode(String code){
        discountCode.sendKeys(code);
    }

    public void clickOnApplyButton(){
        applyButton.click();

    }

    public void inputAddress(String streetAddress) {
        addressColumn.sendKeys(streetAddress);
    }

    public void inputCity(String addressCity) {
        cityColumn.sendKeys(addressCity);
    }

    public void inputZip(String addressZip) {
        zipColumn.sendKeys(addressZip);
    }

    public void clickContinueToShipping() {
        continueToShippingButton.click();
    }

}
