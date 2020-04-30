package main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ProductPage {

    private AppiumDriver<MobileElement> driver ;
    public ProductPage(AppiumDriver<MobileElement> driver) {
        this.driver=driver;
    }

    @AndroidFindBy(className = "android.view.View")
    private List<MobileElement> productDetails;


    public String verifyProduct() {
        String verifyProductDetails = productDetails.get(12).getText();
        return verifyProductDetails;
    }

}
