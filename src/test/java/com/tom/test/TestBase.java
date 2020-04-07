package com.tom.test;

import com.tom.driver.manager.DriverManager;
import com.tom.driver.manager.DriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    public void beforeEachTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
    }

    @AfterEach
    public void afterEachTest() {
        DriverManager.disposeDriver();
    }
}
