package com.tom.test.excercise06;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise06DownloadPage;
import com.tom.page.object.Excercise06LoginPage;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tom.navigation.PageURLs.EXCERCISE_06_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends TestBase {

    @Test
    @DisplayName("Failed login test")
    void tryToLoginUsingIncorrectData() {

        //given
        Excercise06LoginPage loginPage = new Excercise06LoginPage();
        DriverUtils.navigateToPage(EXCERCISE_06_URL);

        //when
        boolean isErrorMessageDisplated = loginPage
                .login("asdf", "qeqwe")
                .isElementDisplayed(loginPage.ERROR_MESSAGE_LOCATOR, 10);

        //then
        assertTrue(isErrorMessageDisplated);
    }

    @Test
    @DisplayName("Positive login test")
    void tryToLoginUsingCorrectData() {

        //given
        Excercise06LoginPage loginPage = new Excercise06LoginPage();
        DriverUtils.navigateToPage(EXCERCISE_06_URL);

        //when
        loginPage.login("tester", "123-xyz");
        Excercise06DownloadPage downloadPage = new Excercise06DownloadPage();
        boolean isDownloadLinkDisplayed = downloadPage.isElementDisplayed(downloadPage.getDownloadLink(), 10);

        //then
        assertTrue(isDownloadLinkDisplayed);
    }

}
