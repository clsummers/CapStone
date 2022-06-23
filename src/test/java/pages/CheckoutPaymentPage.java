package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPaymentPage {

    WebDriver driver;

    public CheckoutPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Credit Card (Visa/Master)
    // By tryAgainAlert = By.cssSelector("error-message banner");
    By visa = By.className("payment-icon payment-icon--visa");


    By masterCard = By.className("payment-icon payment-icon--master");


    //Debit Card (Visa/MasterCard/Maestro)

    //Paid by Paypal
    By payPal =By.partialLinkText("PayPal");


    //Paid by shop pay
    By shopPay = By.partialLinkText("Shop Pay");


    //Paid by zip


    /*public String getAlertText(){
        return driver.findElement(tryAgainAlert).getText();
    }*/

    public String checkForVisa(){
        return driver.findElement(visa).getText();
    }

    public String checkForMasterCard(){
        return driver.findElement(masterCard).getText();
    }

    public String checkForPayPal(){
        return driver.findElement(payPal).getText();
    }

    public String checkForShopPay(){
        return driver.findElement(shopPay).getText();
    }
}
