package com.tom.test.excercise07;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise07Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.tom.navigation.PageURLs.EXCERCISE_07_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropShoppingCartTest extends TestBase {

    @Test
    @DisplayName("Adding by drag and drop and removing items from cart.")
    void addingToCartAndRemovingFromCartItemsTest() {
        //given
        Excercise07Page page = new Excercise07Page();
        DriverUtils.navigateToPage(EXCERCISE_07_URL);
        final int EXPECTED_ITEMS_IN_CART = 25;

        //when
        page.log().info("Expected summary price calculations.");
        BigDecimal expectedPriceOfItemsInCart = new BigDecimal(0);
        expectedPriceOfItemsInCart = expectedPriceOfItemsInCart
                .add(page.getPriceOfItem(2).multiply(BigDecimal.valueOf(15)))
                .stripTrailingZeros();
        expectedPriceOfItemsInCart = expectedPriceOfItemsInCart
                .add(page.getPriceOfItem(3).multiply(BigDecimal.valueOf(10)))
                .stripTrailingZeros();

        //and
        page.log().info("Adding items to cart and removing first item from cart.");
        int actuaNumberOflItemsInCart = page
                .addItemToCart(1, 29)
                .addItemToCart(2, 15)
                .addItemToCart(3, 10)
                .removeItemFromCart(1)
                .getNumberOfItemsInCart();

        //and
        page.log().info("Getting actual summary price of items in cart.");
        BigDecimal actualPriceOfItemsInCart = page.getPriceOfItemsInCart();

        //then
        page.log().info("Asserting that number of expected items in cart is equal to actual number of it.");
        assertThat(EXPECTED_ITEMS_IN_CART).isEqualTo(actuaNumberOflItemsInCart);

        page.log().info("Asserting that expected summary price of items in cart is equal to actual price of it.");
        assertThat(expectedPriceOfItemsInCart).isEqualTo(actualPriceOfItemsInCart);
    }


}
