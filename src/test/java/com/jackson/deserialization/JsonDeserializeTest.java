package com.jackson.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.serialization.PaymentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonDeserializeTest {

    ObjectMapper objectMapper;
    PaymentDto paymentDto;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        paymentDto = PaymentDto.builder()
                .id(123l)
                .mode("CASH")
                .paymentDate(LocalDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    @Test
    void testCustomDeserialization() throws JsonProcessingException {
        String paymentObj = objectMapper.writeValueAsString(paymentDto);
        System.out.println(paymentObj);

        PaymentDto paymentDto = objectMapper.readValue(paymentObj, PaymentDto.class);
        assertNotNull(paymentDto.getPaymentDate());
    }
}
