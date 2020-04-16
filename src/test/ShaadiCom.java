package test;

import com.rccl.excalibur.automation.sample.tests.base_test_configs.MobileBaseSuiteDBEnabled;
import com.rccl.mobile.shaadi.HomeScreen;
import com.rccl.mobile.shaadi.Login;
import com.rccl.mobile.shaadi.StartScreen;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShaadiCom extends MobileBaseSuiteDBEnabled {
    private Login login;
    private StartScreen startscreen;
    private HomeScreen homeScreen;

    @BeforeEach
    public void setUp() {
        super.setUp();
        session.getExtendedAppiumClient().uninstall("com.rccl.royalcaribbean.excalibur");
        session.getExtendedAppiumClient().install((String) session.getSessionConfiguration().getCapabilities().get("app"), true, false);
        session.getIosDriver().launchApp();
    }


    @Test
    @Description("When guest on board and WiFi turn off then guest should be able to view WiFi turn off screen")
    public void testSample() throws Exception {
        startscreen = new StartScreen(session);

        startscreen.verifyLogoExists();

        login = startscreen.loginToApp();

        login.verifyUsernameExists();

        login.inputUsername();
        login.inputPassword();

        homeScreen = login.clickLogin();
        homeScreen.skipLockdownPage();
        homeScreen.selectMyShaadiTab();

        homeScreen.verifyMyShaadiTabTitle();

        homeScreen.verifyPremiumMatch();
        homeScreen.selectPremiumMatch();

        homeScreen.verifyNewMatch();
        homeScreen.selectNewMatch();
    }

}
