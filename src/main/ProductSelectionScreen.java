package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductSelectionScreen {
    private WebDriver driver;
    public ProductSelectionScreen(WebDriver driver) {
        driver = new ChromeDriver();
    }
    WebElement women = driver.findElement(By.linkText("Women"));
    List<WebElement> quickView = driver.findElements(By.xpath("//span[text()='Quick view']"));
    WebElement quantity = driver.findElement(By.name("qty"));
    WebElement cart = driver.findElement(By.id("add_to_cart"));

    public boolean selectWomenSection() {
        if(women.isDisplayed()) {
            women.click();
            return true;
        }
        else
            return false;
    }

    public void selectQuickViewForProduct() {
        System.out.println(quickView.size());
        quickView.get(0).click();
    }

    ////new window pop-up////

    public void selectQuantity() {
        if (quantity.isDisplayed())
        quantity.clear();
        quantity.sendKeys("2");
    }

    public void addToCart() {
        cart.click();
    }
}
