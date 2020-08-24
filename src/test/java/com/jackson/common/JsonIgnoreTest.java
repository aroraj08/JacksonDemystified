package com.jackson.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test to see the working of @JsonIgnore property on a field.
 */
class JsonIgnoreTest {

    CustomerDto customerDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        customerDto = CustomerDto.builder()
                        .firstName("Jatin")
                        .lastName("Arora")
                        .id(123l)
                        .build();

        objectMapper = new ObjectMapper();
    }

    @Test
    void testSerialization() throws JsonProcessingException {

        String serializedObject = objectMapper.writeValueAsString(customerDto);
        System.out.println(serializedObject);
        assertThat(serializedObject, containsString("Jatin"));
        //assertThat(serializedObject, containsString("123"));

        assertFalse(serializedObject.contains("123"));
    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        String serializedObj = "{\"id\":123,\"firstName\":\"Jatin\",\"lastName\":\"Arora\"}";
        CustomerDto parsedCustomer = objectMapper.readValue(serializedObj, CustomerDto.class);

        assertEquals(parsedCustomer.getFirstName(), customerDto.getFirstName());
        assertNull(parsedCustomer.getId());
    }

    @AfterEach
    void tearDown() {
        objectMapper = null;
    }
}