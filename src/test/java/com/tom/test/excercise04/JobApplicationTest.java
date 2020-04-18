package com.tom.test.excercise04;

import com.github.javafaker.Faker;
import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise04Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.tom.navigation.PageURLs.EXCERCISE_04_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobApplicationTest extends TestBase {

    @Test
    @DisplayName("Applicate to Job using correct data")
    void applicateToJobUsingCorrectData() {

        //given
        Excercise04Page page = new Excercise04Page();
        DriverUtils.navigateToPage(EXCERCISE_04_URL);

        Faker faker = new Faker(new Locale("pl"));
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phone = faker.numerify("###-###-###");//phoneNumber().phoneNumber();

        //when
        boolean applicationResult = page
                .openFormWindow()
                .fillForm(name, email, phone)
                .submitForm()
                .isElementDisplayed(page.FINAL_MESSAGE_LOCATOR, 10);

        //then
        assertTrue(applicationResult);
    }

    @Test
    @DisplayName("Applicate to Job using incorrect data")
    void applicateToJobUsingIncorrectData() {
        //given
        Excercise04Page page = new Excercise04Page();
        DriverUtils.navigateToPage(EXCERCISE_04_URL);

        Faker faker = new Faker(new Locale("pl"));
        String name = faker.name().fullName();
        String wrongEmail = faker.name().firstName();
        String wrongPhone = faker.numerify("##-###-###");//phoneNumber().phoneNumber();

        //when
        page.openFormWindow()
                .fillForm(name, wrongEmail, wrongPhone)
                .submitForm();

        boolean areErrorMessagesDisplayed = page.isElementDisplayed(page.EMAIL_ERROR_LOCATOR, 10) && page.isElementDisplayed(page.PHONE_ERROR_LOCATOR, 10);

        //then
        assertThat(areErrorMessagesDisplayed).isTrue();
    }
}
