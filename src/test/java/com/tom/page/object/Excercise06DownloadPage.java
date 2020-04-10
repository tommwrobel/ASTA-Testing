package com.tom.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Excercise06DownloadPage extends BasePage {

    @FindBy(css = ".task div:last-child a")
    private WebElement downloadLink;

    @FindBy(id = "logout")
    private WebElement logoutButton;

    public Excercise06DownloadPage downloadFile() {
        downloadLink.click();
        return this;
    }

    public Excercise06DownloadPage logout() {
        logoutButton.click();
        return this;
    }

    public boolean isDownloadLinkDisplayed() {
        return isElementDisplayed(downloadLink, 10);
    }
}
