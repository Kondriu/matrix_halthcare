package org.ge_halthcare.webservice;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.ge_halthcare.dto.Entry;
import org.ge_halthcare.dto.PublicApisDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.ge_halthcare.pages.BasePage.propertiesReader;

public class PublicApisWebService {

    public static final String GET_All_API_URL = "entries";

    public PublicApisWebService() {
        RestAssured.baseURI = propertiesReader.getValue("api.base.url");
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    public Response getPublicApis() {
        Response response = RestAssured.given()
                .log().all()
                .header("accept", "*/*")
                .header("Content-Type", "application/json")
                .get(GET_All_API_URL)
                .andReturn();
        return response;
    }

    public PublicApisDto getPublicApisAsDto(Response response) {
        return response.as(PublicApisDto.class);
    }

    public List<Entry> getAuthenticationAndAuthorization() {
        return getPublicApisAsDto(getPublicApis()).getEntries()
                .stream()
                .filter(x -> x.getCategory().equals("Authentication & Authorization"))
                .collect(Collectors.toList());
    }

}
