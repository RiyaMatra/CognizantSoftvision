package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartScreen {
    private WebDriver driver;
    public CartScreen(WebDriver driver) {
        driver = new ChromeDriver
                ();
    }

    WebElement billingAddressVerification = driver.findElement(By.className("address_firstname address_lastname"));
    String shippingAmountVerify = driver.findElement(By.className("delivery_option_price")).getText();
    WebElement termsAndCondnCheckbox = driver.findElement(By.id("cgv"));
    String finalBillPayment = driver.findElement(By.id("total_price")).getText();
    WebElement paymentmodeCheque = driver.findElement(By.linkText("Pay by check"));
    String paymentamountCheque = driver.findElement(By.id("amount")).getText();
    WebElement confirmOrder = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
    String orderSuccess = driver.findElement(By.className("alert alert-success")).getText();
    String paymentModeText=paymentmodeCheque.getText();

    public String verifyBillingAddress(){
        String billingAddressOnCheckout = billingAddressVerification.getText();
        return billingAddressOnCheckout;
    }

    public String getShippingAmountVerified(){
        System.out.println("Total shipping amount while checkout = "+shippingAmountVerify);
        return shippingAmountVerify;
    }

    public void clickTermsAndCondns(){
        if (termsAndCondnCheckbox.isDisplayed())
        termsAndCondnCheckbox.click();
    }

    public String getTextFinalBillPayment(){
        return finalBillPayment;
    }

    public void selectPaymentMode(){
        paymentmodeCheque.click();
    }

    public String getTextPaymentMode(){
        return paymentModeText;
    }

    public String getTextPaymentAmountCheque(){
        return paymentamountCheque;
    }


    public void clickConfirmOrder(){
        confirmOrder.click();
    }

    public String verifyIfOrderSuccessful(){
        System.out.print(orderSuccess);
        return orderSuccess;
    }
}
