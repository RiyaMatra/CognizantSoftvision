package main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartScreen {

    private AppiumDriver<MobileElement> driver ;
    public StartScreen(AppiumDriver<MobileElement> driver) {
        this.driver=driver;
    }

        @AndroidFindBy(id = "btn_morph_login")
        private MobileElement login;

    @AndroidFindBy(id = "ivLogo")
    private MobileElement logo;


    public Login loginToApp() {
        login.click();
        return new Login(driver);
    }

    public boolean verifyLogoExists(){
        return logo.isDisplayed();
    }
}
