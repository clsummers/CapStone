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


    @FindBy(id = "checkout_reduction_code")
    WebElement coupon;

    @FindBy(css = "tbody tr[class='total-line total-line--reduction '] th[class='total-line__name'] span:nth-child(1)")
    WebElement discount;


    @FindBy(id = "checkout_shipping_address_first_name")
    WebElement firstName;

    @FindBy(id = "checkout_shipping_address_last_name")
    WebElement lastName;

    @FindBy(id = "checkout_email")
    WebElement email;

    @FindBy(name = "checkout")
    WebElement checkOutBtn;

    public void clickCheckOutBtn(){
        checkOutBtn.click();
    }

    public void enterEmail(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastName.sendKeys(lName);
    }

    public void enterCouponCode(String code){
        coupon.sendKeys(code);
    }

    public String verifyDiscount(){
        return discount.getText();
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
