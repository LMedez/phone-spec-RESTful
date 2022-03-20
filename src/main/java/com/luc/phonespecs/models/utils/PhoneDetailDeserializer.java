package com.luc.phonespecs.models.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.gson.Gson;
import com.luc.phonespecs.models.phone.*;

import java.io.IOException;

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

        if (productNode.get("data").get("product").isArray()) {
            for (final JsonNode objNode : productNode.get("data").get("product")) {

                phoneDetails.setId(objNode.get("_id").textValue());
                phoneDetails.setBackCamera(gson.fromJson(objNode.get("Camera").get("Back Camera").toString(), Camera.class));
                phoneDetails.setFrontCamera(gson.fromJson(objNode.get("Camera").get("Front Camera").toString(), Camera.class));

                phoneDetails.setBrand(objNode.get("Product").get("Brand").textValue());
                phoneDetails.setModel(objNode.get("Product").get("Model").textValue());
                phoneDetails.setVersion(objNode.get("Product").get("Version").textValue());
                phoneDetails.setReleased(objNode.get("Time").get("Released").textValue());

                phoneDetails.setSoftware(gson.fromJson(objNode.get("Inside").get("Software").toString(), Software.class));
                Ram ram = gson.fromJson(objNode.get("Inside").get("RAM").toString(), Ram.class);
                Processor processor = gson.fromJson(objNode.get("Inside").get("Processor").toString(), Processor.class);
                Battery battery = gson.fromJson(objNode.get("Inside").get("Battery").toString(), Battery.class);
                Storage storage = gson.fromJson(objNode.get("Inside").get("Storage").toString(), Storage.class);
                Wireless wireless = gson.fromJson(objNode.get("Inside").get("Storage").toString(), Wireless.class);
                phoneDetails.setHardware(new Hardware(ram, processor, battery, storage, wireless));

                phoneDetails.setImage(gson.fromJson(objNode.get("Camera").get("Front Camera").toString(), Image.class));

            }
        }

        return phoneDetails;
    }
}
