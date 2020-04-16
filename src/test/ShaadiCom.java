package test;

import com.sun.org.glassfish.gmbal.Description;
import main.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ShaadiCom {
    private Login login;
    private StartScreen startscreen;
    private HomeScreen homeScreen;
    private SoftAssert softAssert;

    private AppiumDriver<MobileElement> driver ;
    private final static String APP_PACKAGE_NAME = "com.shaadi.android";
    private final static String APP_ACTIVITY_NAME = "com.shaadi.android.ui.main.MainActivity";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "320080d5d4da8661");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);

        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.launchApp();
        softAssert = new SoftAssert();
    }


    @Test
    @Description("When guest on board and WiFi turn off then guest should be able to view WiFi turn off screen")
    public void testSample() throws Exception {
        startscreen = new StartScreen(driver);
        startscreen.verifyLogoExists();
        login = startscreen.loginToApp();
        Assert.assertTrue(login.verifyUsernameExists());
        login.inputUsername();
        login.inputPassword();
        homeScreen = login.clickLogin();
        homeScreen.skipLockdownPage();
        homeScreen.selectMyShaadiTab();
        Assert.assertTrue(homeScreen.verifyMyShaadiTabTitle());

        softAssert.assertTrue(homeScreen.verifyPremiumMatch());
        homeScreen.selectPremiumMatch();

        softAssert.assertTrue(homeScreen.verifyNewMatch());
        homeScreen.selectNewMatch();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
