package org.de_halthcare.api_tests;

import org.de_halthcare.BaseApiTest;
import org.ge_halthcare.dto.Entry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PublicApiTest extends BaseApiTest {

    @Test
    public void countObjectsTest() {
        List<Entry> authenticationAndAuthorization = webService.getAuthenticationAndAuthorization();

        authenticationAndAuthorization.stream().forEach(System.out::println);
        Assert.assertEquals(authenticationAndAuthorization.size(), 7, "unexpected number of objects");
    }
}
