package testcases;

import library.SelectBrowser;
import org.openqa.selenium.By;
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

    /*===============================================================================================
     * browserLauncher starts up the browser at the beginning of each test and adds an implicit wait.
     *================================================================================================
     * */

    @BeforeTest
    public void browserLauncher()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }



    /*==================================================================================================================================================
    * tc0008_search_results_test tests that correct search results should show up for different types such as product name, brand name, or fuzzy search.
    * ===================================================================================================================================================
    *
    * */
    @Test(priority = 8)
    public void tc0008_search_results_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.inputSearch("baby shoes");
        mainPage.clickSearchButton();
        searchResultPage = new SearchResultPage(driver);
        Thread.sleep(20000);
//        String expectedResult = "baby shoes";
//        String actualResult = searchResultPage.getSearchResult();
//        Assert.assertEquals(expectedResult, actualResult);
        if(driver.findElement(By.className("isp_title_search_term")).isDisplayed()) {
            System.out.println("Search results are verified");
        }else {
            System.out.println("Incorrect search results");
        }

    }


    /*=================================================================================================================
    * tc0009_empty_search_input_test tests that without entering anything in the search box click on the Search button.
    * =================================================================================================================
    *
    * */
    @Test(priority = 9)
    public void tc0009_empty_search_input_test() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickSearchButton();
        searchResultPage = new SearchResultPage(driver);
        Thread.sleep(20000);
        //Add assertion: "No results found. Showing top popular products you might want to consider..."
        if(driver.findElement(By.xpath("//li[@class='isp_no_results_title']")).isDisplayed()) {
            System.out.println("Displayed: 'No results found. Showing top popular products you might want to consider...' ");
        }else {
            System.out.println("Incorrect message displayed");
        }


    }


}
