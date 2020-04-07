package com.tom.test.excercise04;

import com.github.javafaker.Faker;
import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise04Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.tom.navigation.PageURLs.EXCERCISE_04_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobApplicationTest {

    @Test
    @DisplayName("Applicate to Job using proper data")
    void applicateToJobUsingProperData() {

        //given
        Excercise04Page page = new Excercise04Page();
        DriverUtils.navigateToPage(EXCERCISE_04_URL);
        DriverUtils.setInitialConfiguration();

        Faker faker = new Faker(new Locale("pl"));
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phone = faker.numerify("###-###-###");//phoneNumber().phoneNumber();

        //when
        boolean applicationResult = page
                .openFormWindow()
                .fillForm(name, email, phone)
                .submitForm()
                .isElementDisplayed(page.getFinalMessageLocator(), 10);

        //then
        assertTrue(applicationResult);
    }

}
