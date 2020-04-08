package com.tom.test.excercise05;

import com.tom.driver.manager.DriverManager;
import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise05Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.tom.navigation.PageURLs.EXCERCISE_05_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadDataFileTest extends TestBase {

    @Test
    @DisplayName("Loading correct data file")
    void loadingCorrectDataFileTest() {
        //given
        Excercise05Page page = new Excercise05Page();
        DriverUtils.navigateToPage(EXCERCISE_05_URL);
        String properFildeDataPath = new File("src/test/resources/excercise05data/correctDataFile.csv").getAbsolutePath();

        //when
        int actualNumberOfLoadedRows = page
                .loadFile(properFildeDataPath)
                .getNumberOfLoadedRows();

        //then
        int expectedNumberOfLoadedRows = 10;
        assertEquals(expectedNumberOfLoadedRows, actualNumberOfLoadedRows);
    }

    @Test
    @DisplayName("Loading incorrect data file")
    void loadingIncorrectDataFileTest() {
        //given
        Excercise05Page page = new Excercise05Page();
        DriverUtils.navigateToPage(EXCERCISE_05_URL);
        String unproperFildeDataPath = new File("src/test/resources/excercise05data/uncorrectDataFile.csv").getAbsolutePath();

        //when
        boolean isAlertPresent = page
                .loadFile(unproperFildeDataPath)
                .isAlertPresent();

        int actualNumberOfLoadedRows = page.getNumberOfLoadedRows();

        //then
        assertTrue(isAlertPresent );
        assertEquals(0, actualNumberOfLoadedRows);
    }


}
