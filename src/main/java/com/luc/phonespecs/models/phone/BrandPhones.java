package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandPhones {
    @JsonProperty("brand")
    private String brandName;
    @JsonProperty("phone_name")
    private String phoneName;
    @JsonProperty("image")
    private String image;
}
