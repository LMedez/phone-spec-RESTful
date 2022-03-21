package com.luc.phonespecs.models.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.gson.Gson;
import com.luc.phonespecs.models.phone.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class PhoneDetailDeserializer extends StdDeserializer<PhoneDetails> {

    public PhoneDetailDeserializer() {
        this(null);
    }

    public PhoneDetailDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PhoneDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

        JsonNode productNode = jp.getCodec().readTree(jp);
        PhoneDetails phoneDetails = new PhoneDetails();
        Gson gson = new Gson();

        productNode.get("data").get("specifications").forEach(jsonNode -> {
            jsonNode.get("specs").forEach(jsonNode1 -> {
                if (jsonNode1.get("key").textValue().equals("Announced")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setReleased(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Announced")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setReleased(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Announced")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setReleased(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Announced")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setReleased(jsonNode2.asText());
                    });
                }

            });
        });
        return phoneDetails;
    }

}
