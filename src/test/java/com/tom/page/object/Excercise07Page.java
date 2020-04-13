package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Excercise07Page extends BasePage {

    @FindBy(css = ".caption > h4")
    private List<WebElement> itemName;

    @FindBy(className = "ui-draggable-handle")
    private List<WebElement> itemHandle;

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

    @FindBy(className = "panel-heading")
    private WebElement cartTitle;

    public Excercise07Page addItemToCart(int itemIndex, int numberOfItems) {
        inputNumberOfItems.get(itemIndex).clear();
        inputNumberOfItems.get(itemIndex).sendKeys(String.valueOf(numberOfItems));

        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.clickAndHold(itemHandle.get(itemIndex))
                .moveToElement(cartTitle, 0, 80)
                .release()
                .build().perform();

        return this;
    }

    public Excercise07Page removeItemFromCart(int itemIndex) {
        DriverManager.getWebDriver()
                .findElement(By.cssSelector(".basket-list button[data-product-name='" + itemName.get(itemIndex).getText() + "']"))
                .click();
        return this;
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
