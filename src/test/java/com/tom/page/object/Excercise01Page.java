package com.tom.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Excercise01Page {

    @FindBy(css = ".input-group > input.form-control")
    private List<WebElement> inputNumberOfItems;

    @FindBy(css = ".input-group-btn > button")
    private List<WebElement> buttonAddItemToCart;

    @FindBy(css = ".caption p:nth-child(2)")
    private List<WebElement> priceOfOneItem;

    @FindBy(className = "summary-quantity")
    private WebElement summaryNumberOfItemsInCart;

    @FindBy(className = "summary-price")
    private WebElement summaryPriceOfItemsInCart;

    private WebDriver driver;

    public Excercise01Page(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemToCart(int itemIndex, int numberOfItems) {
        inputNumberOfItems.get(itemIndex).clear();
        inputNumberOfItems.get(itemIndex).sendKeys(String.valueOf(numberOfItems));
        buttonAddItemToCart.get(itemIndex).click();
    }

    public int getNumberOfItemsInCart() {
        return parseInt(summaryNumberOfItemsInCart.getText());
    }

    public BigDecimal getPriceOfItem(int itemIndex) {
        return new BigDecimal(priceOfOneItem.get(itemIndex).getText().replaceAll("[^1-9.]", "")).stripTrailingZeros();
    }

    public BigDecimal getPriceOfItemsInCart() {
        return new BigDecimal(summaryPriceOfItemsInCart.getText().replaceAll("[^1-9.]", "")).stripTrailingZeros();
    }

}
