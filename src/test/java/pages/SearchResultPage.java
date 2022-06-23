package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

    WebDriver driver;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(partialLinkText = "baby shoes")
    WebElement searchResult;

    public String getSearchResult(){
        return searchResult.getText();
    }
}
