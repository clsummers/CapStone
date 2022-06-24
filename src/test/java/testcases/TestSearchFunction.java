package testcases;

import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultPage;

import java.time.Duration;

public class TestSearchFunction {

    WebDriver driver;
    MainPage mainPage;
    SearchResultPage searchResultPage;



    @BeforeTest
    public void browserLauncher()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }


    //Correct search results should show up for different types such as product name, brand name, or fuzzy search.
    @Test(priority = 1)
    public void search_results_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.inputSearch("baby shoes");
        mainPage.clickSearchButton();
        searchResultPage = new SearchResultPage(driver);
        Thread.sleep(20000);
        String expectedResult = "baby shoes";
        String actualResult = searchResultPage.getSearchResult();
        Assert.assertEquals(expectedResult, actualResult);

    }

   // Without entering anything in the search box click on the Search button.
    @Test(priority = 2)
    public void empty_search_input_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickSearchButton();
        searchResultPage = new SearchResultPage(driver);
        Thread.sleep(20000);

        //Add assertion: "No results found. Showing top popular products you might want to consider..."
        String expectedResult = "No results found. Showing top popular products you might want to consider...";
        String actualResult = searchResultPage.getNoResultsFoundMessage();
        Assert.assertEquals(expectedResult, actualResult);


    }


}
