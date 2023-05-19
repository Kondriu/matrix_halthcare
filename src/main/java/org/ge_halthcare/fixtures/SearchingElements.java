package org.ge_halthcare.fixtures;

import java.util.Iterator;
import java.util.stream.Stream;

public class SearchingElements {

    public static Iterator<String> getSearchingArguments() {
        return Stream.of(
                        new String("Java")
                )
                .iterator();
    }
}
