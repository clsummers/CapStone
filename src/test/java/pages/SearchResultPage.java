package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver driver;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "baby shoes")
    WebElement searchResult;

    //Add assertion: "No results found. Showing top popular products you might want to consider..."
    @FindBy(css = ".isp_no_results_title")
    WebElement noResultsFoundMessage;

    public String getSearchResult(){
        return searchResult.getText();
    }

    public String getNoResultsFoundMessage(){
        return driver.findElement((By) noResultsFoundMessage).getText();
    }
}
