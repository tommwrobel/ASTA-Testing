package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Excercise02Page extends BasePage {

    @FindBy(css = ".js-category-select option:not(:first-child)")
    List<WebElement> categoryOptions;

    @FindBy(className = "select2")
    private WebElement selectCategories;

    public Excercise02Page typeIntoSearchCategoryField(String text) {
        if (DriverManager.getWebDriver().findElements(By.className("select2-search__field")).size() == 0) {
            selectCategories.click();
        }

        String searchText = text.substring(0, 3).toUpperCase();

        WebElement searchCategoryField = DriverManager.getWebDriver().findElement(By.className("select2-search__field"));
        searchCategoryField.sendKeys(searchText);
        return this;
    }

    public Excercise02Page submitSearchField() {
        DriverManager.getWebDriver().findElement(By.cssSelector(".select2-results__option")).click();
        return this;
    }

    public List<String> getResults() {
        List<WebElement> searchResults = DriverManager.getWebDriver().findElements(By.cssSelector(".caption p>strong"));
        List<String> results = new ArrayList<>();

        for (WebElement serchResult : searchResults) {
            results.add(serchResult.getText());
        }

        return results;
    }

    public String getCategoryText(int categoryIndex) {
        return categoryOptions.get(categoryIndex).getText();
    }
}
