package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "ispbxii_1")
    WebElement email;

    @FindBy(name = "customer[password]")
    WebElement password;

    @FindBy(css = "input[value='Login']")
    WebElement loginButton;

    @FindBy(id = "navigation-clearance")
    WebElement clearance;

    @FindBy(xpath = "//h1[normalize-space()='Welcome, john']")
    WebElement welcomeMessage;

    By tryAgainAlert = By.cssSelector(".error-message.banner");

    public String getAlertText(){
        return driver.findElement(tryAgainAlert).getText();
    }

    public String getWelcomeMessage(){
        return driver.findElement((By) welcomeMessage).getText();
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
