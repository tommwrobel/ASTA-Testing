package com.tom.test.excercise08;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise08Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tom.navigation.PageURLs.EXCERCISE_08_URL;

class PaymentFormTest extends TestBase {

    @Test
    @DisplayName("testing regex pattern")
    void testing() {
        Excercise08Page page = new Excercise08Page();
        DriverUtils.navigateToPage(EXCERCISE_08_URL);

        System.out.println(page.getCardNumberPattern(2));

    }




}
