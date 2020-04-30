package main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login {
    private AppiumDriver<MobileElement> driver ;
    public Login(AppiumDriver<MobileElement> driver) {
        this.driver=driver;
    }

    @AndroidFindBy(id = "skip_sign_in_button")
    private MobileElement skipSignIn;

    public boolean verifySkipSignInExists(){
        return skipSignIn.isDisplayed() && skipSignIn.getText().equals("Skip sign in");
    }

    public HomeScreen clickSkipSignIn() {
        skipSignIn.click();
        return new HomeScreen(driver);
    }

}




