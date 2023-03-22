package org.example_test.task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleWebDriverTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        ChromeDriverManager.getInstance().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void simpleWBTest() throws InterruptedException {
        driver.get("https://demoblaze.com");

        //1
        WebElement contactLink = driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a"));
        Assert.assertTrue(contactLink.isDisplayed());
        contactLink.click();
        Thread.sleep(500);

        //2
        WebElement contactNameInput = driver.findElement(By.xpath("//*[@id=\"exampleModalLabel\"]"));
        Assert.assertTrue(contactNameInput.isDisplayed());

        //3
        WebElement nameInput = driver.findElement(By.id("recipient-name"));
        Assert.assertTrue(nameInput.isDisplayed());

        //4
        WebElement messageInput = driver.findElement(By.cssSelector("#message-text"));
        Assert.assertTrue(messageInput.isDisplayed());

        //5
        WebElement contactEmailInput = driver.findElement(By.xpath("//*[@id=\"recipient-email\"]"));
        Assert.assertTrue(contactEmailInput.isDisplayed());

        //6
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form"));
        Assert.assertTrue(submitButton.isDisplayed());

    }

    @AfterTest
    void end(){
        driver.close();
        driver.quit();
    }
}
