package com.tom.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Excercise06LoginPage extends BasePage {

    @FindBy(name = "LoginForm[_username]")
    private WebElement usernameField;

    @FindBy(name = "LoginForm[_password]")
    private WebElement passwordField;

    @FindBy(name = "LoginForm[save]")
    private WebElement submitButton;

    public final By ERROR_MESSAGE_LOCATOR = By.className("alert-danger");

    public Excercise06LoginPage login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return this;
    }
}
