package org.ge_halthcare.pages;

import org.ge_halthcare.models.SearchResultsItemText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.ge_halthcare.pages.BasePage.getDriver;

public class SearchResultsPage {
    @FindBy(xpath = "//div[@id='rso']/div[@class='MjjYud' or @class='hlcw0c']")
    private List<WebElement> searchResult;
    //div[@id='rso']/div[@class='MjjYud' or @class='hlcw0c']/div[@jscontroller='Da4hkd']
    public SearchResultsPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public List<SearchResultsItemText> getSearchResultList() {

        List<SearchResultsItemText> itemTexts = new ArrayList<>();

        for (WebElement item : searchResult) {

            SearchResultsItemText resultsItemText = new SearchResultsItemText();

            String head = item.findElement(By.xpath(".//h3")).getText();
            String link = item.findElement(By.xpath(".//cite")).getText().split(" ")[0];

            resultsItemText.setDescription(head);
            resultsItemText.setUrl(link);
            itemTexts.add(resultsItemText);
        }
        itemTexts.remove(2);
        return itemTexts;
    }



}
