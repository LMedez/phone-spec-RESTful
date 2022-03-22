package com.luc.phonespecs.models.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.luc.phonespecs.models.phone.PhoneBrand;
import com.luc.phonespecs.models.phone.phonedetail.*;

import java.io.IOException;
import java.util.ArrayList;

public class PhoneBrandDeserializer extends StdDeserializer<PhoneBrand> {

    public PhoneBrandDeserializer() {
        this(null);
    }

    public PhoneBrandDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PhoneBrand deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

        JsonNode productNode = jp.getCodec().readTree(jp);
        PhoneBrand phoneBrand = new PhoneBrand();
        productNode.get("data").forEach(jsonNode -> {
            phoneBrand.setBrandName(jsonNode.get("brand_name").textValue());
            phoneBrand.setPhoneCount(jsonNode.get("device_count").intValue());
        });


        return phoneBrand;
    }

}
