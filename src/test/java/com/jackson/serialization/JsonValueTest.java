package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.common.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonValueTest {

    ObjectMapper objectMapper;
    OrderDto orderDto;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        orderDto = OrderDto.builder()
                    .id(2l)
                    .price(new BigDecimal(100.0))
                    .qty(2)
                    .orderStatus(OrderStatus.NEW)
                    .build();
    }

    @Test
    void testSerializationWithJsonValue() throws JsonProcessingException {
        String serObj = objectMapper.writeValueAsString(orderDto);
        System.out.println(serObj);
    }

}
