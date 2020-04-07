package com.tom.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Excercise05Page extends BasePage {
    @FindBy(css = "input[type='file']")
    WebElement loadFileButton;

    public Excercise05Page loadFile(String path) {
        loadFileButton.sendKeys(path);
    }
}
