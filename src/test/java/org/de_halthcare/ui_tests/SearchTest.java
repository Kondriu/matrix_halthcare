package org.de_halthcare.ui_tests;

import org.assertj.core.api.SoftAssertions;
import org.de_halthcare.BaseUiTest;
import org.ge_halthcare.pages.SearchPage;
import org.ge_halthcare.pages.SearchResultsPage;
import org.ge_halthcare.models.SearchResultsItemText;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SearchTest extends BaseUiTest {

    @Test
    public void runTest(){
        final String testSearchString = "Java";

        SearchPage searchPage = new SearchPage();

        SearchResultsPage resultsPage = searchPage
                .pageOpen()
                .typeTextForSearch(testSearchString)
                .clickSearchButton();

        List<SearchResultsItemText> searchResults = resultsPage.getSearchResultList();
        List<String> descriptions = searchResults.stream().map(x-> x.getDescription()).collect(Collectors.toList());
        /** Print only search result links: */
        searchResults.stream().map(x ->x.getUrl()).forEach(System.out::println);

        SoftAssertions.assertSoftly(softAssertions -> {
            customAssertions.assertResultsContains(descriptions, "Java");
            customAssertions.assertResultsNotContains(descriptions, "Interview");
        });

    }
}
