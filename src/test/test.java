package test;

import main.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class test {
    private WebDriver driver;
    private  HomeScreen homeScreen;
    private AccountCreationScreen accountCreationScreen;
    private ProductSelectionScreen productSelectionScreen;
    private BillingScreen billingScreen;
    private CartScreen cartScreen;
    private OrderHistoryScreen orderHistoryScreen;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Riya\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }


    @Test
    public void crossAssyst() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        homeScreen = new HomeScreen(driver);
        homeScreen.clickSignIn();
        homeScreen.createANewAccount();
        homeScreen.createNewEmailId();

        accountCreationScreen = new AccountCreationScreen(driver);
        accountCreationScreen.selectGender();
        accountCreationScreen.enterName();
        accountCreationScreen.enterPassword();
        accountCreationScreen.enterDOB();
        accountCreationScreen.enterAddress();
        accountCreationScreen.enterMobileNumber();
        accountCreationScreen.enterAlternateAddress();
        accountCreationScreen.registerAccount();

        productSelectionScreen = new ProductSelectionScreen(driver);
        productSelectionScreen.selectWomenSection();
        productSelectionScreen.selectQuickViewForProduct();
        productSelectionScreen.selectQuantity();
        productSelectionScreen.addToCart();

        billingScreen = new BillingScreen(driver);
        billingScreen.getTotalBillBeforeShipping();
        billingScreen.getTotalBillVerify();
        softAssert.assertEquals(billingScreen.getTotalBillVerify(),
                billingScreen.getTotalBillBeforeShipping(),
                "Checking Total Bill Before Shipping at two different places");
        billingScreen.getTotalBillAfterShipping();
        billingScreen.clickCheckout();

        cartScreen = new CartScreen(driver);
        String totalCartAmount = driver.findElement(By.id("total_price")).getText();
        System.out.println("Total bill while checkout = " + totalCartAmount);
        Assert.assertEquals("Verifying total Bill AFTER Shipping at two different places",
                billingScreen.getTotalBillAfterShipping(),
                totalCartAmount);

        billingScreen.clickCheckout();
        softAssert.assertEquals(cartScreen.verifyBillingAddress(),
                "Riya" + " " + "Matra",
                "Checking translation for - 50%");
        cartScreen.getShippingAmountVerified();
        cartScreen.clickTermsAndCondns();
        billingScreen.clickCheckout();
        cartScreen.getTextFinalBillPayment();

        softAssert.assertEquals(cartScreen.getTextFinalBillPayment(),
                billingScreen.getTotalBillAfterShipping(),
                "Checking text for Final BillPayment");
        cartScreen.selectPaymentMode();
        cartScreen.getTextPaymentAmountCheque();

        softAssert.assertEquals(cartScreen.getTextPaymentAmountCheque(),
                billingScreen.getTotalBillAfterShipping(),
                "Checking text for Payment Amount on Cheque");
        cartScreen.clickConfirmOrder();
        cartScreen.verifyIfOrderSuccessful();
        Assert.assertEquals("Order is successful",
                cartScreen.verifyIfOrderSuccessful());

        homeScreen.selectProfile();
        orderHistoryScreen = new OrderHistoryScreen(driver);
        orderHistoryScreen.navigateToOrderHistory();
        billingScreen.clickCheckout();
        orderHistoryScreen.getOrderHistoryAmount();
        Assert.assertEquals("Order amount in the order history details must match with Payment amount",
                billingScreen.getTotalBillAfterShipping(),
                orderHistoryScreen.getOrderHistoryAmount());


        orderHistoryScreen.verifyOrderHistoryPayment();
        Assert.assertEquals("Order payment mode in the order history details must match with Payment Mode",
                cartScreen.getTextPaymentMode(),
                orderHistoryScreen.verifyOrderHistoryPayment());

        Assert.assertEquals("Order amount in the order history details must match with Payment amount",
                billingScreen.getTotalBillAfterShipping(),
                orderHistoryScreen.getOrderHistoryAmount());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

