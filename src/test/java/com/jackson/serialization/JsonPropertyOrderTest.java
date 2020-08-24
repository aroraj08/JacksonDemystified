package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JsonPropertyOrderTest {

    CustomerDto customerDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        customerDto = customerDto.builder()
                .firstName("Kapil")
                .lastName("Arora")
                .id(5l)
                .build();
    }

    @Test
    void testPropertyOrder() throws JsonProcessingException {

        String serObj = objectMapper.writeValueAsString(customerDto);
        System.out.println(serObj);
        assertThat(serObj, containsString("\"first-name\":\"Kapil\",\"lastName\":\"Arora\",\"id\":5"));
    }

}
