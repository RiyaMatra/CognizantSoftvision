package main.shaadi;

import com.rccl.mobile.MobileBaseScreen;
import com.rccl.unifiedframework.selenium.Session;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartScreen extends MobileBaseScreen {


    public StartScreen(Session session) {
        super(session);
    }

        @AndroidFindBy(id = "btn_morph_login")
        private MobileElement login;

    @AndroidFindBy(id = "ivLogo")
    private MobileElement logo;


    public Login loginToApp() {
        login.click();
        return new Login(getSession());
    }

    public boolean verifyLogoExists(){
        return logo.isDisplayed();
    }
}
