package com.tom.page.object;

import com.tom.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excercise02Page extends BasePage {

    @FindBy(css = ".js-category-select option:not(:first-child)")
    private List<WebElement> categoryOptions;

    @FindBy(className = "select2")
    private WebElement selectCategories;

    public Excercise02Page typeIntoSearchCategoryField(String text) {
        if (DriverManager.getWebDriver().findElements(By.className("select2-search__field")).size() == 0) {
            selectCategories.click();
        }

        String searchText = text.substring(0, 3).toUpperCase();

        DriverManager
                .getWebDriver()
                .findElement(By.className("select2-search__field"))
                .sendKeys(searchText);

        return this;
    }

    public Excercise02Page submitSearchField() {
        DriverManager.getWebDriver().findElement(By.cssSelector(".select2-results__option")).click();
        return this;
    }

    public List<String> getResults() {
        return DriverManager.getWebDriver().findElements(By.cssSelector(".caption p>strong")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getCategoryText(int categoryIndex) {
        return categoryOptions.get(categoryIndex).getText();
    }
}
