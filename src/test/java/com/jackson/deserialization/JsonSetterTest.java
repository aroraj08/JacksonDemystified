package com.jackson.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonSetterTest {

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        String customerJson = "{\"paymentId\" : 123, \"firstName\": \"Jatin\", \"lastName\" : \"Arora\"}";
        CustomerDto customerDto = objectMapper.readValue(customerJson, CustomerDto.class);
        assertNotNull(customerDto.getId());
    }
}
