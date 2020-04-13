package com.tom.page.object;

import org.openqa.selenium.By;

public class Excercise09Page extends BasePage {

    public final By CONTENT_TITLE_LOCATOR = By.cssSelector(".content-container > h1");
    public final By NODES_LOCATOR = By.className("jstree-anchor");
    public final By NODE_ARROW_LOCATOR = By.className("jstree-icon");

}
