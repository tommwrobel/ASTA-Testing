package com.tom.page.object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

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

    public WebElement getDownloadLink() {
        return downloadLink;
    }

    public boolean isDownloadedFileProper(String pathToFile, int waitTime) {

        File file = new File(pathToFile);

        for (int i = 0; i < waitTime; i++) {
            if (file.exists()) {
                return true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
