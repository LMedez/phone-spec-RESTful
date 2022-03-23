package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneBrand {
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("brand_slug")
    private String brandSlug;
    @JsonProperty("device_count")
    private int phoneCount;


}
