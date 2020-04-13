package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Excercise08Page extends BasePage {

    @FindBy(name = "task8_form[cardType]")
    private WebElement cardTypeElement;
    private Select cardTypeSelect;

    @FindBy(name = "task8_form[name]")
    private WebElement nameField;

    @FindBy(name = "task8_form[cardNumber]")
    private WebElement cardNumberField;

    @FindBy(name = "task8_form[cardCvv]")
    private WebElement cardCvvNumberField;

    @FindBy(name = "task8_form[cardInfo][month]")
    private WebElement monthSelectElement;
    private Select monthSelect;

    @FindBy(name = "task8_form[cardInfo][year]")
    private WebElement yearSelectElement;
    private Select yearSelect;

    @FindBy(css = ".form-group button[type='submit'")
    private WebElement submitButton;

    @FindBy(className = "glyphicon-info-sign")
    private WebElement ccvInfo;

    public final By CCV_INFO_TOOLTIP_LOCATOR = By.className("tooltip");
    public final By ALERT_SUCCESS_LOCATOR = By.className("alert-success");

    public Excercise08Page fillForm(String cardType, String name, String cardNumber, String cardCcvNumber, int monthIndex, int yearIndex) {

        cardTypeSelect = new Select(cardTypeElement);
        monthSelect = new Select(monthSelectElement);
        yearSelect = new Select(yearSelectElement);

        cardTypeSelect.selectByVisibleText(cardType);
        nameField.sendKeys(name);
        cardNumberField.sendKeys(cardNumber);
        cardCvvNumberField.sendKeys(String.valueOf(cardCcvNumber));
        monthSelect.selectByIndex(monthIndex);
        yearSelect.selectByIndex(yearIndex);
        return this;
    }

    public Excercise08Page submitForm() {
        submitButton.click();
        return this;
    }

    public Excercise08Page moveMouseToCcvInfo() {
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(ccvInfo).perform();
        return this;
    }
}
