package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JsonRootNameTest {

    ObjectMapper objectMapper;
    PaymentDto paymentDto;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        paymentDto = PaymentDto.builder()
                        .id(123l)
                        .mode("CASH")
                        .build();
    }

    @Test
    void testRootElementExists() throws JsonProcessingException {

        String paymentDtoAsString = objectMapper
                        .enable(SerializationFeature.WRAP_ROOT_VALUE)
                        .writeValueAsString(paymentDto);

        System.out.println(paymentDtoAsString);
        assertThat(paymentDtoAsString, containsString("payment\":{"));
    }
}
