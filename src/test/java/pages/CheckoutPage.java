package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(id = "checkout_reduction_code")
//    WebElement discountCode;

    @FindBy(id = "checkout_submit")
    WebElement applyButton;

    @FindBy(css = "#checkout_shipping_address_address1")
    WebElement addressColumn;

    @FindBy(id = "checkout_shipping_address_city")
    WebElement cityColumn;

    @FindBy(id = "checkout_shipping_address_zip")
    WebElement zipColumn;

    @FindBy(id = "continue_button")
    WebElement continueToShippingButton;

    @FindBy(partialLinkText = "Gift card or discount code")
    WebElement discountCode;

    @FindBy(id = "checkout_reduction_code")
    WebElement coupon;

    @FindBy(css = "tbody tr[class='total-line total-line--reduction '] th[class='total-line__name'] span:nth-child(1)")
    WebElement discount;

    @FindBy(xpath = "//*[@id=\"checkout_submit\"]/span[2]")
    WebElement applyCouponCodeButton;

    public void enterCouponCode(String code){
        coupon.sendKeys(code);
    }

    public String verifyDiscount(){
        return discount.getText();
    }

    public void clickApplyCouponCode(){
        applyCouponCodeButton.click();
    }


    public String verifyDiscountCode(){
        return driver.findElement((By) discountCode).getText();
    }


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
