package com.tom.test.excercise01;

import com.tom.page.object.Excercise01Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddingItemsToShoppingCartTest extends TestBase {
    @Test
    @DisplayName("Adding one item to shopping cart")
    public void addingOneItemToShoppingCartTest() {
        driver.navigate().to("https://testingcup.pgs-soft.com/task_1");
        final int NUMBER_OF_ITEMS = 3;

        LOGGER.info("Initializing page object and web elements.");
        Excercise01Page page = new Excercise01Page(driver);
        PageFactory.initElements(driver, page);

        LOGGER.info("Adding {} items to cart", NUMBER_OF_ITEMS);
        page.addItemToCart(0, NUMBER_OF_ITEMS);

        LOGGER.info("Checking if number of items in cart is proper.");
        int expectedNumberOfItemsInCart = NUMBER_OF_ITEMS;
        int actualNumberOfItemsInCart = page.getNumberOfItemsInCart();
        assertEquals(expectedNumberOfItemsInCart, actualNumberOfItemsInCart);

        LOGGER.info("Checking if summart price od items in cart is proper.");
        BigDecimal expectedSummaryPriceOfItemsInCart = page.getPriceOfItem(0).multiply(BigDecimal.valueOf(NUMBER_OF_ITEMS));
        BigDecimal actualSymmaryPriceOfItemsInCart = page.getPriceOfItemsInCart();
        assertEquals(expectedSummaryPriceOfItemsInCart, actualSymmaryPriceOfItemsInCart);
    }
}
