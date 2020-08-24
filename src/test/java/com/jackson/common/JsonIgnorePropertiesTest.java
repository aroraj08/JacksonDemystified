package com.jackson.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;

class JsonIgnorePropertiesTest {

    ObjectMapper objectMapper;
    OrderDto orderDto;

    @BeforeEach
    void setUp() {

        orderDto = OrderDto.builder()
                    .id(1l)
                    .qty(2)
                    .price(new BigDecimal("100.3"))
                    .orderStatus(OrderStatus.NEW)
                    .build();

        objectMapper = new ObjectMapper();
    }

    @Test
    void testSerialization() throws JsonProcessingException {
        String serialObj = objectMapper.writeValueAsString(orderDto);
        System.out.println(serialObj);
        assertThat(serialObj, not(containsString("100.3")));
        assertThat(serialObj, containsString("NEW"));
    }

    @Test
    void testDeserialization() throws JsonProcessingException {
        String serialObject = "{\"id\":1,\"price\":100.3,\"qty\":2,\"orderStatus\":\"NEW\"}";
        OrderDto parsedOrderDto = objectMapper.readValue(serialObject, OrderDto.class);

        assertNull(parsedOrderDto.getId());
        assertNull(parsedOrderDto.getPrice());
        assertEquals(orderDto.getOrderStatus(), parsedOrderDto.getOrderStatus());
    }

    @AfterEach
    void tearDown() {

        objectMapper = null;
    }
}