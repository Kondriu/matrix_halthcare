package org.ge_halthcare.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchFieldInput;
    @FindBy(xpath = "//div[@class='lJ9FBc']//input[@name='btnK']")
    WebElement searchButton;


    public SearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public SearchPage pageOpen() {
        visitPage(propertiesReader.getValue("ui.base.url"));
        return this;
    }

    public SearchPage typeTextForSearch(String searchString) {
        waitFor(visibilityOf(searchFieldInput));
        searchFieldInput.clear();
        searchFieldInput.click();
        searchFieldInput.sendKeys(searchString);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        waitFor(visibilityOf(searchButton));
        searchButton.click();
        return new SearchResultsPage();
    }


}
