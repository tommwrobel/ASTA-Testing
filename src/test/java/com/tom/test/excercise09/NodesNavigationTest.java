package com.tom.test.excercise09;

import com.tom.driver.manager.DriverManager;
import com.tom.driver.manager.DriverUtils;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.tom.page.object.Excercise09Page;
import org.openqa.selenium.WebElement;

import static com.tom.navigation.PageURLs.EXCERCISE_09_URL;

public class NodesNavigationTest extends TestBase {

    @Test
    @DisplayName("Node test navigation")
    void nodesNavigationTest() {
        Excercise09Page page = new Excercise09Page();
        DriverUtils.navigateToPage(EXCERCISE_09_URL);

        DriverManager.getWebDriver().findElement(page.NODES_LOCATOR).click();
        DriverManager.getWebDriver().findElement(page.NODE_ARROW_LOCATOR).click();

    }

}
