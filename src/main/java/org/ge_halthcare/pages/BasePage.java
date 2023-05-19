package org.ge_halthcare.pages;

import org.ge_halthcare.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static PropertiesReader propertiesReader = PropertiesReader.getPropertiesReader();

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void waitFor(ExpectedCondition<?> condition) {
        Duration duration = Duration.ofMillis(Long.parseLong(propertiesReader.getValue("default.timeout")));
        (new WebDriverWait(getDriver(), duration)).until(condition);
    }

    public void visitPage(String uri) {
        getDriver().get(uri);
    }

}
