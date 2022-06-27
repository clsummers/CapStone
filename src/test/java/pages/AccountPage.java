package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

public class AccountPage {

    WebDriver driver;



    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }


    @FindBy(xpath = "//*[@id=\"keyboard-nav-3\"]/div[2]/div[3]/a")
    WebElement registerButton;

    @FindBy(id = "ispbxii_1")
    WebElement email;

    @FindBy(name = "customer[password]")
    WebElement password;

    @FindBy(css = "input[value='submit']")
    WebElement loginButton;


    public void clickOnRegisterButton() {
        registerButton.click();
    }


}
