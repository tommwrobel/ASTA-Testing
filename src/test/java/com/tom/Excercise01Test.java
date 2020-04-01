package com.tom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Excercise01Test {

    WebDriver driver;

    @BeforeEach
    public void beforeEachTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://buggy-testingcup.pgs-soft.com/task_1");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEachTest() {
        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Adding one item to shopping cart")
    public void addingOneItemToShoppingCartTest() {
        //given
        final int NUMBER_OF_ELEMENTS = 10;

        //when
        WebElement numberOfItemsInput = driver.findElement(By.cssSelector(".input-group > input.form-control"));
        numberOfItemsInput.clear();
        numberOfItemsInput.sendKeys(String.valueOf(NUMBER_OF_ELEMENTS));

        //and
        WebElement buttonAddProduct = driver.findElement(By.cssSelector(".input-group-btn button"));
        buttonAddProduct.click();

        //and
        WebElement webElementPriceOfItem = driver.findElement(By.cssSelector(".caption p"));
        System.out.println(webElementPriceOfItem.getText().substring(6).replaceAll("[^1-9.]",""));
        BigDecimal priceOfItem = new BigDecimal(webElementPriceOfItem.getText().replaceAll("[^1-9.]",""));
        BigDecimal expectedPriceOfItems = priceOfItem.multiply(BigDecimal.valueOf(NUMBER_OF_ELEMENTS)).stripTrailingZeros();

        //then
        //checking number of items in shopping cart
        WebElement summaryQuantity = driver.findElement(By.className("summary-quantity"));
        String actualText = summaryQuantity.getText();
        String expectedText = String.valueOf(NUMBER_OF_ELEMENTS);
        assertEquals(expectedText, actualText);

        //checking summary price of items in basket
        WebElement webElementActualPriceOfItems = driver.findElement(By.className("summary-price"));
        BigDecimal actualPriceOfItems = new BigDecimal(webElementActualPriceOfItems.getText().replaceAll("[^1-9.]","")).stripTrailingZeros();
        assertTrue(expectedPriceOfItems.equals(actualPriceOfItems));
    }

    @Test
    @DisplayName("Adding maximum (100) number of items to shopping cart")
    public void addingMaxItemsToShoppingCartTest() {
        //given
        List<WebElement> inputsNumberOfItems = driver.findElements(By.cssSelector(".input-group > input.form-control"));
        List<WebElement> buttonsAddProduct = driver.findElements(By.cssSelector(".input-group-btn button"));

        //when
        inputsNumberOfItems.get(0).clear();
        inputsNumberOfItems.get(0).sendKeys("50");
        buttonsAddProduct.get(0).click();

        inputsNumberOfItems.get(1).clear();
        inputsNumberOfItems.get(1).sendKeys("40");
        buttonsAddProduct.get(1).click();

        inputsNumberOfItems.get(2).clear();
        inputsNumberOfItems.get(2).sendKeys("2");
        buttonsAddProduct.get(2).click();

        inputsNumberOfItems.get(3).clear();
        inputsNumberOfItems.get(3).sendKeys("8");
        buttonsAddProduct.get(3).click();

        //then
        WebElement summaryQuantity = driver.findElement(By.className("summary-quantity"));
        String actualText = summaryQuantity.getText();
        String expectedText = "100";

        assertEquals(expectedText, actualText);
    }

}
