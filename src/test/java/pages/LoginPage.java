package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "ispbxii_1")
    WebElement email;

    @FindBy(name = "customer[password]")
    WebElement password;

    @FindBy(css = "input[value='submit']")
    WebElement loginButton;

    @FindBy(id = "navigation-clearance")
    WebElement clearance;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By tryAgainAlert = By.cssSelector("error-message banner");

    public String getAlertText(){
        return driver.findElement(tryAgainAlert).getText();
    }

    public void inputEmail(String emailInput){
        email.sendKeys(emailInput);
    }

    public void inputPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
    public  void clickClearanceButton(){
        clearance.click();
    }



}
