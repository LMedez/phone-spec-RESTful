package com.luc.phonespecs.models.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.luc.phonespecs.models.phone.development.*;

import java.io.IOException;
import java.util.ArrayList;

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
        Battery battery = new Battery();
        Camera backCamera = new Camera();
        Camera frontCamera = new Camera();
        Wireless wireless = new Wireless();
        Audio audio = new Audio();

        memory.setInternal(productNode.get("data").get("storage").asText());
        if (productNode.get("data").get("thumbnail") != null)
            phoneDetails.setThumbnail(productNode.get("data").get("thumbnail").textValue());

        ArrayList<String> array = new ArrayList<>();
        productNode.get("data").get("phone_images").forEach(jsonNode2 -> {
            array.add(jsonNode2.textValue());
        });
        phoneDetails.setPhoneImages(array);

        phoneDetails.setBrand(productNode.get("data").get("brand").textValue());
        phoneDetails.setName(productNode.get("data").get("phone_name").textValue());

        productNode.get("data").get("specifications").forEach(jsonNode -> {
            jsonNode.get("specs").forEach(jsonNode1 -> {
                if (jsonNode1.get("key").textValue().equals("Announced")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setReleased(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Type")) {
                    if (jsonNode.get("title").textValue().equals("Display")) {
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

                /////////////////////////////////////////////////////////////

                if (jsonNode1.get("key").textValue().equals("Type")) {
                    if (jsonNode.get("title").textValue().equals("Battery")) {
                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            battery.setType(jsonNode2.asText());
                        });
                    }
                }

                if (jsonNode1.get("key").textValue().equals("Charging")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        battery.setChargingPower(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Battery life")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        battery.setLife(jsonNode2.asText());
                    });
                }

                /////////////////////////////////////////////////////////////

                if (jsonNode1.get("key").textValue().equals("Video")) {
                    if (jsonNode.get("title").textValue().equals("Main Camera")) {

                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            backCamera.setVideo(jsonNode2.asText());
                        });
                    }
                }

                if (jsonNode1.get("key").textValue().equals("Features")) {
                    if (jsonNode.get("title").textValue().equals("Main Camera")) {

                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            backCamera.setFeatures(jsonNode2.asText());
                        });
                    }
                }

                if (jsonNode1.get("key").textValue().equals("Quad")) {
                    if (jsonNode.get("title").textValue().equals("Main Camera")) {

                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            backCamera.setMp(jsonNode2.asText());
                        });
                    }
                }
                if (jsonNode1.get("key").textValue().equals("Single")) {
                    if (jsonNode.get("title").textValue().equals("Main Camera")) {

                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            backCamera.setMp(jsonNode2.asText());
                        });
                    }
                }
                /////////////////////////////////////////////////////////////

                if (jsonNode1.get("key").textValue().equals("Single")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        frontCamera.setMp(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Features")) {
                    if (jsonNode.get("title").textValue().equals("Selfie camera")) {
                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            frontCamera.setFeatures(jsonNode2.asText());
                        });
                    }
                }

                if (jsonNode1.get("key").textValue().equals("Video")) {
                    if (jsonNode.get("title").textValue().equals("Selfie camera")) {
                        jsonNode1.get("val").forEach(jsonNode2 -> {
                            frontCamera.setVideo(jsonNode2.asText());
                        });
                    }
                }
                /////////////////////////////////////////////////////////////

                if (jsonNode1.get("key").textValue().equals("WLAN")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        wireless.setWifi(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("USB")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        wireless.setUsb(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Bluetooth")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        wireless.setBluetooth(jsonNode2.asText());
                    });
                }

                /////////////////////////////////////////////////////////////

                if (jsonNode1.get("key").textValue().equals("3.5mm jack")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        audio.setHasOutput(jsonNode2.asText());
                    });
                }


                if (jsonNode1.get("key").textValue().equals("Price")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setPrice(jsonNode2.asText());
                    });
                }


                if (jsonNode1.get("key").textValue().equals("Models")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setModels(jsonNode2.asText());
                    });
                }


                if (jsonNode1.get("key").textValue().equals("Dimensions")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setDimension(jsonNode2.asText());
                    });
                }

                if (jsonNode1.get("key").textValue().equals("Weight")) {
                    jsonNode1.get("val").forEach(jsonNode2 -> {
                        phoneDetails.setWeight(jsonNode2.asText());
                    });
                }

            });
        });
        hardware.setProcessor(processor);
        hardware.setMemory(memory);
        hardware.setBattery(battery);
        phoneDetails.setSoftware(software);
        phoneDetails.setWireless(wireless);
        phoneDetails.setAudio(audio);
        phoneDetails.setDisplay(display);
        phoneDetails.setBackCamera(backCamera);
        phoneDetails.setFrontCamera(frontCamera);
        phoneDetails.setHardware(hardware);
        return phoneDetails;
    }

}
