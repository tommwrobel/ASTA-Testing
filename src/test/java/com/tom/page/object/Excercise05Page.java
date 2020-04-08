package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import com.tom.driver.manager.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Excercise05Page extends BasePage {
    @FindBy(css = "input[type='file']")
    WebElement loadFileButton;

    private final By LOADED_ROWS_LOCATOR;

    public By getLOADED_ROWS_LOCATOR() {
        return LOADED_ROWS_LOCATOR;
    }

    public Excercise05Page() {
        super();
        LOADED_ROWS_LOCATOR = By.cssSelector(".table > tbody > tr");
    }

    public Excercise05Page loadFile(String path) {
        loadFileButton.sendKeys(path);
        return this;
    }

    public int getNumberOfLoadedRows() {
        if (isElementDisplayed(LOADED_ROWS_LOCATOR, 4)) {
            return DriverManager.getWebDriver().findElements(LOADED_ROWS_LOCATOR).size();
        } else {
            return 0;
        }
    }

    public boolean isAlertPresent() {
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 10 /*timeout in seconds*/);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
            DriverManager.getWebDriver().switchTo().alert().accept();
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }
}
