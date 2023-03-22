package org.example.task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SeleniumStart {
//        General
//        Setup ChromeDriver using driver file and properties.
//                Setup ChromeDriver using DriverManager.
//                My first UI test:
//        go to the page from your variant
//        choose any 5 different elements;
//        Use different WebElement methods to communicate with those elements. (one element - at least one interaction)
//        Make a testNG test case to check visibility of your elements.

    public static void main(String[] args) throws InterruptedException {
//        Setup ChromeDriver using driver file and properties.
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

//      Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoblaze.com");

        //1
        WebElement contactLink = driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a"));
        contactLink.click();

        //2
        WebElement contactNameInput = driver.findElement(By.xpath("//*[@id=\"exampleModalLabel\"]"));
        System.out.println(contactNameInput.getCssValue("color"));
        System.out.println(contactNameInput.getTagName());
        Thread.sleep(500);

        //3
        WebElement nameInput = driver.findElement(By.id("recipient-name"));
        nameInput.sendKeys("Name!");

        //4
        WebElement messageInput = driver.findElement(By.cssSelector("#message-text"));
        messageInput.sendKeys("Hello!");

        //5
        WebElement contactEmailInput = driver.findElement(By.xpath("//*[@id=\"recipient-email\"]"));
        contactEmailInput.sendKeys("contact_re@mail.com");

        //6
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form"));
        submitButton.submit();

        driver.close();
        driver.quit();
    }
}
