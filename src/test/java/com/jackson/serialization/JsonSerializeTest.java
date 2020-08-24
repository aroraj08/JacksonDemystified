package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonSerializeTest {

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
    void testJsonCustomSerialization() throws JsonProcessingException {
        String paymentObj = objectMapper.writeValueAsString(paymentDto);
        System.out.println(paymentObj);
    }

}
