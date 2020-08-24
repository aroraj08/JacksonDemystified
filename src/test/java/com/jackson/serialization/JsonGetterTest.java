package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JsonGetterTest {

    CustomerDto customerDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        customerDto = CustomerDto.builder()
                        .firstName("Jatin")
                        .lastName("Arora")
                        .build();
    }

    @Test
    void testJsonKey() throws JsonProcessingException {
        String serObj = objectMapper.writeValueAsString(customerDto);
        assertThat(serObj, containsString("first-name"));
    }
}
