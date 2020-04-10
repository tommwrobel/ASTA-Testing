package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator)).isDisplayed();
        } catch (TimeoutException eTO) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), timeout);
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException eTO) {
            return false;
        }
    }

    public WebElement waitUntilElementIsDisplayed(By elementLocator, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), timeout);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public WebElement waitUntilElementIsClickable(By elementLocator, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), timeout);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }
}

