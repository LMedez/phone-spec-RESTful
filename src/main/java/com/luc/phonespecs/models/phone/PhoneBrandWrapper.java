package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class PhoneBrandWrapper {
    @JsonProperty("data")
    private List<PhoneBrand> phoneBrands;

    public PhoneBrandWrapper() {}
}
