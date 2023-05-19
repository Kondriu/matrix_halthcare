package org.ge_halthcare.utils;

import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class CustomAssertions {

    public void assertResultsContains(List<String> results, String checkToContains) {

        SoftAssertions.assertSoftly(softAssertions -> {
            for (String resultItem : results) {
                softAssertions.assertThat(resultItem)
                        .as("Result doesnt contains searched item")
                        .contains(checkToContains);
            }
        });
    }

    public void assertResultsNotContains(List<String> results, String checkToContains) {

        SoftAssertions.assertSoftly(softAssertions -> {
            for (String resultItem : results) {
                softAssertions.assertThat(resultItem)
                        .as("Result doesnt contains searched item")
                        .doesNotContain(checkToContains);
            }
        });
    }


}
