package test;

import com.sun.org.glassfish.gmbal.Description;
import main.*;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CognizantSoftvision {
    private Login login;
    private ProductPage productPage;
    private HomeScreen homeScreen;
    private AppiumDriver<MobileElement> driver ;
    private final static String APP_PACKAGE_NAME = "com.amazon.mShop.android.shopping";
    private final static String APP_ACTIVITY_NAME = "com.amazon.mShop.home.HomeActivity";

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
    }

    @Test
    @Description("When guest on board and WiFi turn off then guest should be able to view WiFi turn off screen")
    public void testSample() throws Exception {
        login=new Login(driver);
        Assert.assertTrue(login.verifySkipSignInExists());
        homeScreen=login.clickSkipSignIn();
        Assert.assertTrue("Homescreen is not displayed after Login page", homeScreen.verifyAmazonLogo());
        Assert.assertTrue(homeScreen.verifySearchTextbox());
        homeScreen.inputProductSearch();
        System.out.println("The product serach list count found is: "+homeScreen.getProductSearchCount());
        productPage = homeScreen.selectRandomProduct();
        Assert.assertTrue("16 inches TV product is not viewed correctly", productPage.verifyProduct().contains("16 inches"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
