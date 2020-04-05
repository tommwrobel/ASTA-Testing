package com.tom.test.excercise02;

import com.tom.driver.manager.DriverUtils;
import com.tom.page.object.Excercise02Page;
import com.tom.test.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tom.navigation.PageURLs.EXCERCISE_02_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchCategoryTest extends TestBase {

    @Test
    @DisplayName("Checking if search category field return expected results")
    void checkingIfSearchCategoryFieldReturnsExpectedResults() {
        //given
        Excercise02Page page = new Excercise02Page();
        String categoryText = page.getCategoryText(1);

        page.log().info("Navigating to page {}.", EXCERCISE_02_URL);
        DriverUtils.navigateToPage(EXCERCISE_02_URL);

        //when
        page.log().info("Typing category text first 3 letters in uppercase, submitting and getting results.");
        List<String> searchResults = page.typeIntoSearchCategoryField(categoryText).submitSearchField().getResults();

        //then
        page.log().info("Asserting that results items have chosen category.");
        boolean allEqual = searchResults.isEmpty() || searchResults.stream().allMatch(categoryText::equals);
        assertTrue(allEqual);
    }
}
