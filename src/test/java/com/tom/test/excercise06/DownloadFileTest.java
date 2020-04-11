package com.tom.test.excercise06;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise06DownloadPage;
import com.tom.page.object.Excercise06LoginPage;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tom.navigation.PageURLs.EXCERCISE_06_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadFileTest extends TestBase {
    @Test
    @DisplayName("Download file test")
    void asLoggedUserTryToDownloadFile() {
        //given
        Excercise06LoginPage loginPage = new Excercise06LoginPage();
        DriverUtils.navigateToPage(EXCERCISE_06_URL);
        loginPage.login("tester", "123-xyz");
        Excercise06DownloadPage downloadPage = new Excercise06DownloadPage();
        String downloadedFileName = "pgs_cv.jpg";

        //when
        boolean isdownloadedFileProper = downloadPage
                .downloadFile()
                .isDownloadedFileProper("C:\\Users\\Tomek\\IdeaProjects\\tmp\\pgs_cv.jpg", 1200000, 10);

        //then
        assertTrue(isdownloadedFileProper);
    }
}
