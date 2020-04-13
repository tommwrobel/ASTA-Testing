package com.tom.test.excercise08;

import com.github.javafaker.Faker;
import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise08Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.tom.navigation.PageURLs.EXCERCISE_08_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentFormTest extends TestBase {

    @ParameterizedTest(name = "#{index} Card type: {0}, card regex pattern: {1}")
    @DisplayName("Trying to pay using proper data")
    @CsvSource({
            "American Express, [0-9]{15}",
            "American Express Corporate, [0-9]{15}",
            "Australian BankCard, [0-9]{16}",
            "Discover, [0-9]{16}",
            "JCB, [0-9]{16}",
            "MasterCard, [0-9]{16}",
            "Visa, [0-9]{16}",
            "Visa, [0-9]{13}",
            "Dankort (PBS), [0-9]{11}",
            "Dankort (PBS), [0-9]{16}",
            "Switch/Solo (Paymentech), [0-9]{16}"
    })
    void tryingToPayWithCorrectData(String cardType, String cardNumberPattern) {

        //given
        Excercise08Page page = new Excercise08Page();
        DriverUtils.navigateToPage(EXCERCISE_08_URL);
        Faker faker = new Faker();
        String cardNumber = faker.regexify(cardNumberPattern);
        String name = faker.name().fullName();
        String cardCcvNumber = faker.regexify("[0-9]{3}");

        //when
        boolean isSuccessAlertDisplayed = page.
                fillForm(cardType, name, cardNumber, cardCcvNumber, 1, 2)
                .submitForm()
                .isElementDisplayed(page.ALERT_SUCCESS_LOCATOR, 10);

        //when
        assertTrue(isSuccessAlertDisplayed);
    }
}
