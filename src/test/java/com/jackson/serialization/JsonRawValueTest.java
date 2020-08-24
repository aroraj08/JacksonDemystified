package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonRawValueTest {

    ObjectMapper objectMapper;
    RawValueDemoBean demoBean;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        demoBean = RawValueDemoBean.builder()
                        .id(2l)
                        .name("Jatin")
                        .address("{\"doorNumber\": 1234, \"street\": \"phase-1\", " +
                                "\"city\": \"New York\"}")
                        .build();
    }

    @Test
    void testJsonRawValue() throws JsonProcessingException {

        String serObject = objectMapper.writeValueAsString(demoBean);
        System.out.println(serObject);
    }
}
