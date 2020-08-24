package com.jackson.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonFormatForDateTest {

    ObjectMapper objectMapper;
    ProductDto productDto;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        productDto = ProductDto.builder()
                .id(123l)
                .name("Bread")
                .price(1.5)
                .creationDateTime(LocalDateTime.of(2020, 12, 01,
                        13, 11, 11))
                .build();
    }

    @Test
    void testSerialization() throws JsonProcessingException {
        String serializedObj = objectMapper.writeValueAsString(productDto);
        System.out.println(serializedObj);
        // yyyy-MM-dd'T'HH:mm:ssZ
        assertThat(serializedObj, containsString("01-12-2020 13:11:11"));
    }

}
