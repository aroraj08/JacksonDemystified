package com.jackson.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JsonIgnoreTypeTest {

    CustomerDto customerDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        customerDto = CustomerDto.builder()
                .firstName("Jatin")
                .lastName("Arora")
                .id(123l)
                .build();

        CustomerDto.Address address = new CustomerDto.Address("211", "CA", "LA");
        customerDto.setAddress(address);

        objectMapper = new ObjectMapper();
    }

    @Test
    void testSerialization() throws JsonProcessingException {

        String serializedObject = objectMapper.writeValueAsString(customerDto);
        System.out.println(serializedObject);

        assertThat(serializedObject, not(containsString("CA")));
    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        String deserializedObject = "{\"firstName\":\"Jatin\",\"lastName\":\"Arora\",\"address\":{\"streetName\":\"211\",\"state\":\"CA\",\"city\":\"LA\"}}";
        CustomerDto parsedCustomerDto = objectMapper.readValue(deserializedObject, CustomerDto.class);
        assertNull(parsedCustomerDto.getAddress());

    }
}
