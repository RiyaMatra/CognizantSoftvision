package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingScreen {
    private WebDriver driver;
    public BillingScreen(WebDriver driver) {
        driver = new ChromeDriver();
    }
    WebElement checkout = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
    String totalBillBeforeShipping = driver.findElement(By.id("layer_cart_product_price")).getText();
    String totalBillVerify = driver.findElement(By.id("ajax_block_products_total")).getText();
    String totalBillAfterShipping = driver.findElement(By.id("ajax_block_cart_total")).getText();

    public String getTotalBillBeforeShipping(){
        System.out.println("Total bill = " + totalBillBeforeShipping);
        return totalBillBeforeShipping;
    }

    public String getTotalBillVerify(){
        System.out.println("Total bill = " + totalBillVerify);
        return totalBillVerify;
    }

    public String getTotalBillAfterShipping(){
        System.out.println("Total bill after shipping = " + totalBillAfterShipping);
        return totalBillAfterShipping;
    }

    public void clickCheckout(){
        checkout.click();
    }



}
