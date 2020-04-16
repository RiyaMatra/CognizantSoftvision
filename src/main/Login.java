package main.shaadi;

import com.rccl.mobile.MobileBaseScreen;
import com.rccl.unifiedframework.selenium.Session;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login extends MobileBaseScreen {


    public Login(Session session) {
        super(session);
    }

    @AndroidFindBy(id = "edt_username")
    private MobileElement username;

    @AndroidFindBy(id = "edt_password")
    private MobileElement password;

    @AndroidFindBy(id = "btn_login")
    private MobileElement login;

    public boolean verifyUsernameExists(){
        return username.isDisplayed();
    }

    public void inputUsername() {
        username.clear();
        username.sendKeys("riyamatra@gmail.com");
    }

    public void inputPassword() {
        password.clear();
        password.sendKeys("Onsite@2020");
    }

    public HomeScreen clickLogin() {
        login.click();
        return new HomeScreen(getSession());
    }

}




