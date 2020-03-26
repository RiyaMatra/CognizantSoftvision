package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationScreen {
    private WebDriver driver;
    public AccountCreationScreen(WebDriver driver) {
        driver = new ChromeDriver();
    }

    WebElement gender = driver.findElement(By.id("id_gender2"));
  WebElement FirstName = driver.findElement(By.id("customer_firstname"));
 WebElement LastName = driver.findElement(By.id("customer_lastname"));
  WebElement password = driver.findElement(By.id("passwd"));
  WebElement DOB_DD = driver.findElement(By.id("days"));
    WebElement DOB_MM = driver.findElement(By.id("months"));
    WebElement DOB_YY = driver.findElement(By.id("years"));
    WebElement address = driver.findElement(By.id("address1"));
    WebElement city = driver.findElement(By.id("city"));
    WebElement state = driver.findElement(By.id("id_state"));
    WebElement postalCode = driver.findElement(By.id("postcode"));
    WebElement mobileNumber = driver.findElement(By.id("phone_mobile"));
    WebElement secondAddress = driver.findElement(By.id("alias"));
    WebElement register = driver.findElement(By.id("submitAccount"));

    public void selectGender() {
        gender.click();
    }

    public void enterName() {
        FirstName.clear();
        FirstName.sendKeys("Riya");
        LastName.clear();
        LastName.sendKeys("Matra");

    }

    public void enterPassword() {
        password.sendKeys("Abc@123");
    }

    public void enterDOB() {
        Select sc = new Select(DOB_DD);
        sc.selectByVisibleText("23");

        Select MM = new Select(DOB_MM);
        MM.selectByVisibleText("December");

        Select YY = new Select(DOB_YY);
        YY.selectByVisibleText("1993");
    }

    public void enterAddress() {
        address.sendKeys("12, Lane");
        city.sendKeys("Edison");
        Select State = new Select(state);
        State.selectByVisibleText("New Jersey");
        postalCode.sendKeys("08837");
    }

    public void enterMobileNumber() {
        mobileNumber.sendKeys("9123456780");
    }

    public void enterAlternateAddress() {
        secondAddress.clear();
        secondAddress.sendKeys("123Abc, New York");
    }

    public void registerAccount() {
        register.click();
    }
}
