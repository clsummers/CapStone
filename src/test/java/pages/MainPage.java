package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_login_link")
    WebElement accountButton;

    @FindBy(name = "q")
    WebElement searchBar;

    @FindBy(className = "header-search-button")
    WebElement searchButton;

    @FindBy(id = "navigation-clearance")
    WebElement clearance;

    public void clickOnAccountLink() {
        WebElement accountButton = driver.findElements(By.xpath("//a[@id='customer_login_link']")).get(0);
        (accountButton).click();
    }
    public void inputSearch(String search){
        searchBar.sendKeys(search);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public  void clickClearanceButton(){
        clearance.click();
    }

}
