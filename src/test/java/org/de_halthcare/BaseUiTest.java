package org.de_halthcare;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.ge_halthcare.utils.CustomAssertions;
import org.ge_halthcare.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static org.ge_halthcare.pages.BasePage.getDriver;
import static org.ge_halthcare.pages.BasePage.setDriver;

public class BaseUiTest {

    public static PropertiesReader propertiesReader = PropertiesReader.getPropertiesReader();

    public CustomAssertions customAssertions = new CustomAssertions();

    @BeforeSuite
    public static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        setDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public static void acceptCookies(){
        getDriver().get(propertiesReader.getValue("ui.base.url"));
        try {
            if (getDriver().findElement(By.xpath("//div[@class = 'QS5gu sy4vM' and contains(text(), 'Accept all')]")).isDisplayed()) {
                getDriver().findElement(By.xpath("//div[@class = 'QS5gu sy4vM' and contains(text(), 'Accept all')]")).click();
            }
        } catch (NullPointerException npe){}

    }

    @AfterSuite
    public static void tearDown() {
        getDriver().quit();
    }
}
