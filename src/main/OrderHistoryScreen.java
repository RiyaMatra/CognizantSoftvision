package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderHistoryScreen {
    private WebDriver driver;
    public OrderHistoryScreen(WebDriver driver) {
        driver = new ChromeDriver();
    }

    WebElement orderHistory = driver.findElement(By.xpath("//span[text()='Order history and details']"));
    String orderHistoryAmount = driver.findElement(By.xpath("//span[@class='price']")).getText();
    String orderHistoryPaymentVerify = driver.findElement(By.className("history_method")).getText();

    public void navigateToOrderHistory(){
        if (orderHistory.isDisplayed())
        orderHistory.click();
    }

    public String getOrderHistoryAmount(){
         System.out.print(orderHistoryAmount);
        return orderHistoryAmount;
    }

    public String verifyOrderHistoryPayment(){
        System.out.print(orderHistoryPaymentVerify);
        return orderHistoryPaymentVerify;
    }

}
