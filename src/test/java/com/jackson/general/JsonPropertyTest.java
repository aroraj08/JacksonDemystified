package com.jackson.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonPropertyTest {

    ObjectMapper objectMapper;
    ProductDto productDto;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        productDto = ProductDto.builder()
                .id(123l)
                .name("Bread")
                .price(1.5)
                .build();
    }

    @Test
    void testSerialization() throws JsonProcessingException {
        String serializedObj = objectMapper.writeValueAsString(productDto);
        System.out.println(serializedObj);
        assertThat(serializedObj, containsString("product_name"));
    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        String json = "{\"category\":null,\"productId\":123,\"price\":1.5,\"product_name\":\"Bread\"}";
        ProductDto productDto = objectMapper.readValue(json, ProductDto.class);
        assertEquals("Bread" , productDto.getName());
    }

}
