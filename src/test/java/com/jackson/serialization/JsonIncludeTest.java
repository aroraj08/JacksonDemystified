package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class JsonIncludeTest {

    CustomerDto customerDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testWithEmptyValue() throws JsonProcessingException {

        customerDto = CustomerDto.builder()
                        .id(2l)
                        .build();

        String serObj = objectMapper.writeValueAsString(customerDto);
        System.out.println(serObj);
        assertThat(serObj, not(containsString("firstName")));
    }

    @Test
    void testWithNonEmptyValue() throws JsonProcessingException {
        customerDto = CustomerDto.builder()
                        .id(2l)
                        .firstName("Jatin")
                        .build();
        String serObj = objectMapper.writeValueAsString(customerDto);
        assertThat(serObj, containsString("first-name"));
    }
}
