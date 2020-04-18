package com.tom.test.excercise08;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise08Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tom.navigation.PageURLs.EXCERCISE_08_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class TooltipTest extends TestBase {

    @Test
    @DisplayName("Checking if tooltip is showing up after mouseover")
    void checkingIfTooltipIsShowingUp() {
        //given
        Excercise08Page page = new Excercise08Page();
        DriverUtils.navigateToPage(EXCERCISE_08_URL);

        //when
        boolean isTooltipDisplayed = page
                .moveMouseToCcvInfo()
                .isElementDisplayed(page.CCV_INFO_TOOLTIP_LOCATOR, 10);

        //then
        assertThat(isTooltipDisplayed).isTrue();
    }

}
