package org.ge_halthcare.dto;

import lombok.Data;

import java.util.List;

@Data
public class PublicApisDto {
    private Integer count;
    private List<Entry> entries;


}
