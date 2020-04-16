package main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login {
    private AppiumDriver<MobileElement> driver ;
    private final static String un = "riyamatra@gmail.com";
    private final static String pw = "Onsite@2020";
    public Login(AppiumDriver<MobileElement> driver) {
        this.driver=driver;
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
        username.sendKeys(un);
    }

    public void inputPassword() {
        password.clear();
        password.sendKeys(pw);
    }

    public HomeScreen clickLogin() {
        login.click();
        return new HomeScreen(driver);
    }

}




