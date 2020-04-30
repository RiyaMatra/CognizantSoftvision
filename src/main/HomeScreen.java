package main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomeScreen {
    private final static String productToBeSearched = "65 inch tv";
    private AppiumDriver<MobileElement> driver ;
    public HomeScreen(AppiumDriver<MobileElement>AppiumDriver) {
        this.driver= this.driver;
    }

    @AndroidFindBy(id = "rs_search_src_text")
    private MobileElement searchTextbox;

    @AndroidFindBy(id = "chrome_action_bar_home_logo")
    private MobileElement amazonLogo;

    @AndroidFindBy(id = "rs_results_image")
    private List<MobileElement> searchResults;

    public boolean verifyAmazonLogo() {
        return (amazonLogo.isDisplayed());
    }

    public boolean verifySearchTextbox() {
        return searchTextbox.isDisplayed() && searchTextbox.getText().equals("Search");
    }

    public void inputProductSearch() {
    searchTextbox.clear();
    searchTextbox.sendKeys(productToBeSearched);
    }

    public double getProductSearchCount() {
        double productSearchCount = searchResults.size();;
        return productSearchCount;
    }


    public ProductPage selectRandomProduct(){
       if (searchResults.get(1).isDisplayed())
           searchResults.get(1).click();
       return new ProductPage(driver);
    }

}
