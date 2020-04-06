package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Excercise03Page extends BasePage {

    @FindBy(className = "dropdown-toggle")
    WebElement dropDownMenu;

    @FindBy(css="#menu1 >  li:first-child > a")
    WebElement subMenuOption;

    @FindBy(id="start-edit")
    WebElement startEditMenuOption;

    @FindBy(id="in-name")
    WebElement nameField;

    @FindBy(id="in-surname")
    WebElement surnameField;

    @FindBy(id="in-notes")
    WebElement noteField;

    @FindBy(id="in-phone")
    WebElement phoneField;

    @FindBy(id="in-file")
    WebElement fileField;

    @FindBy(id="save-btn")
    WebElement saveButton;

    public Excercise03Page chooseStartEditOptionFromMenu() {
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(dropDownMenu).perform();
        action.moveToElement(subMenuOption).perform();
        startEditMenuOption.click();
        sleep(2);
        return  this;
    }

    public Excercise03Page fillFormWithData(String name, String surname, String note, String phone, String filePath) {
        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        noteField.sendKeys(note);
        phoneField.sendKeys(phone);
        fileField.sendKeys(filePath);
        return this;
    }

    public Excercise03Page submitForm() {
        saveButton.click();
        return this;
    }

    public boolean isSaveDataMessageDisplayed() {

        sleep(1);
        return DriverManager.getWebDriver().findElements(By.cssSelector("span[data-notify-text]")).size() > 0;
    }

    public boolean isWholeFormEnabled() {
        if(nameField.isEnabled()
                && surnameField.isEnabled()
                && noteField.isEnabled()
                && phoneField.isEnabled()
                && fileField.isEnabled()
                && saveButton.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }


    private void sleep(int s) {
        try {
            Thread.sleep(s*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
