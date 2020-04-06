package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public final Logger LOGGER = LogManager.getRootLogger();

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public Logger log() {
        return LOGGER;
    }

    public boolean isElementDisplayed(By elementLocator, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), timeout);
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element.isDisplayed();
    }
}
