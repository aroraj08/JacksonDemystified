package com.jackson.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonCreatorTest {

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testJsonCreatorOnImmutableClass() throws JsonProcessingException {
        String serObj = "{\"first-name\": \"Aman\", \"last-name\" : \"Chopra\", \"id\": 1}";
        EmployeeDto employeeDto = objectMapper.readValue(serObj, EmployeeDto.class);
        assertEquals("Aman", employeeDto.getFirstName());
    }
}
