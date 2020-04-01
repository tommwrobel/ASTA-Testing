package com.tom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Excercise01Test {

    WebDriver driver;

    @BeforeEach
    public void beforeEachTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void afterEachTest() {
        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Adding one item to shopping cart test")
    public void addingOneItemToShoppingCartTest() {
        driver.navigate().to("https://testingcup.pgs-soft.com/task_1");
        driver.manage().window().maximize();

        //given
        WebElement numberOfItemsInput = driver.findElement(By.cssSelector(".input-group > input.form-control"));
        numberOfItemsInput.clear();
        numberOfItemsInput.sendKeys("10");

        //when
        WebElement buttonAddProduct = driver.findElement(By.cssSelector(".input-group-btn button"));
        buttonAddProduct.click();

        //then
        WebElement summaryQuantity = driver.findElement(By.className("summary-quantity"));
        String actualText = summaryQuantity.getText();
        String expectedText = "10";

        assertEquals(expectedText, actualText);
    }

}
