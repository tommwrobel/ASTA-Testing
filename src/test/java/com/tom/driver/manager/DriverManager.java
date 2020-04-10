package com.tom.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static WebDriver driver;
    public static String DOWNLOAD_FILE_FOLDER = "C:\\Users\\Tomek\\IdeaProjects\\tmp";
    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
            driver = new ChromeDriver(setupDownloadFolder(DOWNLOAD_FILE_FOLDER));
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

    public static ChromeOptions setupDownloadFolder(String path) {
        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("download.default_directory", path);

        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", prefsMap);
        option.addArguments("--test-type");
        option.addArguments("--disable-extensions");

        return option;
    }
}
