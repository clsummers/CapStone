package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPaymentPage {

    WebDriver driver;

    public CheckoutPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Credit Card (Visa/Master)
    @FindBy(css = ".radio-wrapper.content-box__row[data-gateway-group='direct'][data-gateway-name='credit_card']")
    WebElement paymentCreditCard;

    @FindBy(css = ".radio-wrapper.content-box__row[data-gateway-group='direct'][data-gateway-name='shopify_installments']")
    WebElement paymentShopPay;

    @FindBy(css = ".radio-wrapper.content-box__row[data-gateway-group='express']")
    WebElement paymentPayPal;



    @FindBy(className = "card-fields-iframe")
    WebElement cardNumberFrame;
    @FindBy(id = "number")
    WebElement cardNumber;
    @FindBy(xpath = "*//iframe[contains(@id,'card-fields-name')]")
    WebElement nameFrame;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(xpath = "*//iframe[contains(@id,'card-fields-expiry')]")
    WebElement dateFrame;
    @FindBy(id = "expiry")
    WebElement expiry;
    @FindBy(xpath = "*//iframe[contains(@id,'card-fields-verification_value')]")
    WebElement codeFrame;
    @FindBy(id = "verification_value")
    WebElement securityCode;
    @FindBy(id = "continue_button")
    WebElement payNowButton;
    @FindBy(css = "div[class='notice notice--error default-background'] p[class='notice__text']")
    WebElement paymentError;

    @FindBy(className = "btn__content")
    WebElement finalPayNowButton;

    public List<WebElement> verifyFinalPayNowButton(){
        return driver.findElements((By) finalPayNowButton);
    }

    public String verifyCreditCardOption(){
        return paymentCreditCard.getText();
    }

    public String verifyShopPayOption(){
        return paymentPayPal.getText();
    }

    public String verifyPayPalOption(){
        return paymentPayPal.getText();
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
    public void switchToCardNumberFrame() {
        driver.switchTo().frame(cardNumberFrame);
    }
    public void enterCardNumber(String number) {
        cardNumber.sendKeys(number);
    }
    public void switchToNameFrame() {
        driver.switchTo().frame(nameFrame);
    }
    public void enterName(String fullName) {
        name.sendKeys(fullName);
    }
    public void switchToDateFrame() {
        driver.switchTo().frame(dateFrame);
    }
    public void enterExpirationDate(String date) {
        expiry.sendKeys(date);
    }
    public void switchToCodeFrame() {
        driver.switchTo().frame(codeFrame);
    }
    public void enterSecurityCode(String code) {
        securityCode.sendKeys(code);
    }
    public void clickPayNow() {
        payNowButton.click();
    }
    public String showPaymentError() {
        return paymentError.getText();
    }


}
