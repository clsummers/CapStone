package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearancePage {

    WebDriver driver;

    public ClearancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "article[id='product-list-item-2325367881785'] div[class='product-list-item-details'] a[class='navigable']")
    WebElement meshShoes;

    @FindBy(css = ".product-price")
    WebElement priceOfItem;


    public String verifyPrice(){
        return driver.findElement((By) priceOfItem).getText();
    }

    public void selectItem(){
        meshShoes.click();
    }







}
