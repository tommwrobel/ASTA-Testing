package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Excercise04Page extends BasePage {

    private final By APPLICATE_BUTTON_LOCATOR = By.className("js-open-window");
    private final By IMAGE_LOCATOR = By.className("preview-photo");
    private final By NAME_FIELD_LOCATOR = By.name("name");
    private final By EMAIL_FIELD_LOCATOR = By.name("email");
    private final By PHONE_FIELD_LOCATOR = By.name("phone");
    private final By SUBMIT_BUTTON_LOCATOR = By.id("save-btn");

    public final By EMAIL_ERROR_LOCATOR = By.cssSelector("input[name=\"email\"] ~ .error");
    public final By PHONE_ERROR_LOCATOR = By.cssSelector("input[name=\"phone\"] ~ .error");
    public By FINAL_MESSAGE_LOCATOR = By.tagName("H1");

    public Excercise04Page openFormWindow() {
        waitUntilElementIsDisplayed(IMAGE_LOCATOR, 10);
        waitUntilElementIsClickable(APPLICATE_BUTTON_LOCATOR, 10).click();;

        Set<String> windowHandles = DriverManager.getWebDriver().getWindowHandles();
        windowHandles.remove(DriverManager.getWebDriver().getWindowHandle());
        DriverManager.getWebDriver().switchTo().window(String.join("", windowHandles));
        DriverManager.getWebDriver().switchTo().frame(0);

        return this;
    }

    public Excercise04Page fillForm(String name, String email, String phone) {
        DriverManager.getWebDriver().findElement(NAME_FIELD_LOCATOR).sendKeys(name);
        DriverManager.getWebDriver().findElement(EMAIL_FIELD_LOCATOR).sendKeys(email);
        DriverManager.getWebDriver().findElement(PHONE_FIELD_LOCATOR).sendKeys(phone);
        return this;
    }

    public Excercise04Page submitForm() {
        DriverManager.getWebDriver().findElement(SUBMIT_BUTTON_LOCATOR).click();
        return this;
    }
}
