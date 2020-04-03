package com.tom.test.excercise01;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise01Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest extends TestBase {

    @Test
    @DisplayName("Adding and removing items from cart.")
    public void addingToCartAndRemovingFromCartItemsTest() {
        //given
        Excercise01Page page = new Excercise01Page();
        int actualItemsInCart;
        final int EXPECTED_ITEMS_IN_CART = 25;
        BigDecimal actualPriceOfItemsInCart;
        BigDecimal expectedPriceOfItemsInCart;
        String pageUrl = "https://testingcup.pgs-soft.com/task_1";

        //when
        LOGGER.info("Navigating to page {}", pageUrl);
        DriverUtils.navigateToPage(pageUrl);

        //and
        LOGGER.info("Expeted summary price calculations");
        expectedPriceOfItemsInCart = new BigDecimal(0);
        expectedPriceOfItemsInCart = expectedPriceOfItemsInCart.add(page.getPriceOfItem(2).multiply(BigDecimal.valueOf(15))).stripTrailingZeros();
        expectedPriceOfItemsInCart = expectedPriceOfItemsInCart.add(page.getPriceOfItem(3).multiply(BigDecimal.valueOf(10))).stripTrailingZeros();

        //and
        LOGGER.info("Adding items to cart and removing first item from cart.");
        actualItemsInCart = page.addItemToCart(1, 29)
                .addItemToCart(2, 15)
                .addItemToCart(3, 10)
                .removeFirstAddedItemFromCart()
                .getNumberOfItemsInCart();

        //and
        LOGGER.info("Getting actual summary price of items in cart.");
        actualPriceOfItemsInCart = page.getPriceOfItemsInCart();

        //then
        LOGGER.info("Asserting that number of expected items in cart is equal to actual number of it.");
        assertEquals(EXPECTED_ITEMS_IN_CART, actualItemsInCart);

        LOGGER.info("Asserting that expected summary price of items in cart is equal to actual price of it.");
        assertEquals(expectedPriceOfItemsInCart, actualPriceOfItemsInCart);
    }
}
