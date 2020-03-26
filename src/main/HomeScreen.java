package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomeScreen {

    private WebDriver driver;
    public HomeScreen(WebDriver driver) {
        driver = new ChromeDriver();
    }

    WebElement signIn = driver.findElement(By.linkText("Sign in"));
    WebElement emailCreate = driver.findElement(By.id("email_create"));
    WebElement createAnAccount = driver.findElement(By.xpath("//span[text()='Create an account']"));
    WebElement profile = driver.findElement(By.className("header_user_info"));

    public void clickSignIn() {
        if (signIn.isDisplayed())
            signIn.click();
    }

    public void createNewEmailId() {

        emailCreate.sendKeys("abc@gmail.com");
    }

    public void createANewAccount() {
        if (createAnAccount.isDisplayed())
        createAnAccount.click();
    }

    public boolean selectProfile() {
        if (profile.isDisplayed()) {
            profile.click();
            return true;
        }
        else
            return false;

    }
}
