package com.jackson.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonUnwrappedTest {

    CustomerDto customerDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        customerDto = CustomerDto.builder()
                            .id(122l)
                            .name("Jatin")
                            .address(CustomerDto.Address.builder().city("LA")
                                    .country("US").state("NY").zipCode(12345).build())
                            .build();
    }

    @Test
    void testJsonUnwrapping() throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(customerDto);
        System.out.println(jsonString);
    }
}
