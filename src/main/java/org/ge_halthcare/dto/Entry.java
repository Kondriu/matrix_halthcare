package org.ge_halthcare.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Entry {

    @JsonProperty("API")
    public String api;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Auth")
    public String auth;
    @JsonProperty("HTTPS")
    public Boolean https;
    @JsonProperty("Cors")
    public String cors;
    @JsonProperty("Link")
    public String link;
    @JsonProperty("Category")
    public String category;

//    @JsonProperty("API")
//    private String api;
//    @JsonProperty("Description")
//    private String description;
//    @JsonProperty("Auth")
//    private String auth;
//    @JsonProperty("HTTPS")
//    private Boolean https;
//    @JsonProperty("Cors")
//    private String cors;
//    @JsonProperty("Link")
//    private String link;
//    @JsonProperty("Category")
//    private String category;

    @Override
    public String toString() {
        return  "api=\t\t'" + api + '\'' + ",\n" +
                "Description='" +  description + '\'' + ",\n" +
                "auth=\t\t'" + auth + '\'' + ",\n" +
                "https=\t\t'" + https + "',\n" +
                "cors=\t\t'" + cors + '\'' + ",\n" +
                "link=\t\t'" + link + '\'' + ",\n" +
                "category=\t'" + category + '\'' + "\n"
                ;
    }
}
