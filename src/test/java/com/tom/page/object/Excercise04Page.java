package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Excercise04Page extends BasePage {

    private final By APPLICATE_BUTTON_LOCATOR;
    private final By IMAGE_LOCATOR;
    private final By NAME_FIELD_LOCATOR;
    private final By EMAIL_FIELD_LOCATOR;
    private final By PHONE_FIELD_LOCATOR;
    private final By SUBMIT_BUTTON_LOCATOR;

    private final By EMAIL_ERROR_LOCATOR;
    private final By PHONE_ERROR_LOCATOR;
    private By finalMessageLocator;

    public Excercise04Page() {
        super();
        APPLICATE_BUTTON_LOCATOR = By.className("js-open-window");
        IMAGE_LOCATOR = By.className("preview-photo");
        NAME_FIELD_LOCATOR = By.name("name");
        EMAIL_FIELD_LOCATOR = By.name("email");
        PHONE_FIELD_LOCATOR = By.name("phone");
        SUBMIT_BUTTON_LOCATOR = By.id("save-btn");
        EMAIL_ERROR_LOCATOR = By.cssSelector("input[name=\"email\"] ~ .error");
        PHONE_ERROR_LOCATOR = By.cssSelector("input[name=\"phone\"] ~ .error");;
        finalMessageLocator = By.tagName("H1");
    }

    public Excercise04Page openFormWindow() {
        waitUntilElementIsDisplayed(IMAGE_LOCATOR, 10);
        WebElement applicateButton = waitUntilElementToBeClickable(APPLICATE_BUTTON_LOCATOR, 10);

        applicateButton.click();

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

    public By getFINAL_MESSAGE_LOCATOR() {
        return finalMessageLocator;
    }

    public By getEMAIL_ERROR_LOCATOR() {
        return EMAIL_ERROR_LOCATOR;
    }

    public By getPHONE_ERROR_LOCATOR() {
        return PHONE_ERROR_LOCATOR;
    }
}
