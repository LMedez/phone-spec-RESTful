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
        Display display = new Display();
        Software software = new Software();
        Hardware hardware = new Hardware();
        Processor processor = new Processor();
        Memory memory = new Memory();


        Gson gson = new Gson();
        memory.setInternal(productNode.get("data").get("storage").asText());
        productNode.get("data").get("specifications").forEach(jsonNode -> {
            jsonNode.get("specs").forEach(jsonNode1 -> {
                if (jsonNode1.get("key").textValue().equals("Announced")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setReleased(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Type")) {
                    if (jsonNode.get("title").textValue().equals("Display")){
                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            display.setType(jsonNode2.asText());
                            display.setHz(jsonNode2.asText());
                        });
                    }
                }

                if (jsonNode1.get("key").textValue().equals("Resolution")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        display.setAspectRatio(jsonNode2.asText());
                        display.setPpi(jsonNode2.asText());
                        display.setResolution(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Size")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        display.setInch(jsonNode2.asText());
                    });
                }

                /////////////////////////////////////////////////////////////

                if (jsonNode1.get("key").textValue().equals("OS")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        software.setOS(jsonNode2.asText());
                        software.setOsVersion(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Chipset")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        processor.setChipset(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("CPU")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        processor.setCPU(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("GPU")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        processor.setGPU(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Card slot")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        memory.setCardSlot(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Internal")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        memory.setRam(jsonNode2.asText());
                    });
                }

            });
        });
        hardware.setProcessor(processor);
        hardware.setMemory(memory);
        phoneDetails.setDisplay(display);
        phoneDetails.setHardware(hardware);
        return phoneDetails;
    }

}
