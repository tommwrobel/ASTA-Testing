package com.tom.test.excercise03;

import com.github.javafaker.Faker;
import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise03Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;


import static com.tom.navigation.PageURLs.EXCERCISE_03_URL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EditFormTest extends TestBase {

    @Test
    @DisplayName("Editing and saving changes to form")
    void editAndSaveFormTest() {
       //given
        Excercise03Page page = new Excercise03Page();
        page.log().info("Navigating to page {}.", EXCERCISE_03_URL);
        DriverUtils.navigateToPage(EXCERCISE_03_URL);
        Faker dataFaker = new Faker(new Locale("pl"));
        String firstName = dataFaker.name().firstName();
        String lastName = dataFaker.name().lastName();
        String noteText = dataFaker.lorem().sentence();
        String phoneNumber = dataFaker.phoneNumber().cellPhone();
        String filePath = new File("src/test/resources/img/example.png").getAbsolutePath();

        //when
        boolean isSaveDataMessageDisplayed =  page
                .chooseStartEditOptionFromMenu()
                .fillFormWithData(firstName, lastName, noteText, phoneNumber, filePath)
                .submitForm()
                .isSaveDataMessageDisplayed();

        //then
        assertTrue(isSaveDataMessageDisplayed);
        assertFalse(page.isWholeFormEnabled());
    }
}
