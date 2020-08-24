package com.jackson.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonAnySetterTest {

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper= new ObjectMapper();
    }

    @Test
    void testJsonAnySetter() throws JsonProcessingException {

        String customerJson = "{\"paymentId\" : 123, \"firstName\": \"Jatin\", \"lastName\" : \"Arora\", \"active\": true}";
        CustomerDto customerDto = objectMapper.readValue(customerJson, CustomerDto.class);
        assertEquals(true, customerDto.getProperties().get("active"));
    }
}

