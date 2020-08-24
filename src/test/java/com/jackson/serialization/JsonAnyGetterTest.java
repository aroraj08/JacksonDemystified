package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JsonAnyGetterTest {

    EmployeeDto employeeDto;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        Map<String, Object> properties =
                new HashMap<>();

        properties.put("designation", "SE");
        properties.put("experienceInYears", 5.5);

        employeeDto = EmployeeDto.builder()
                        .firstName("Preeti")
                        .lastName("M")
                        .properties(properties)
                        .build();
    }

    @Test
    void testJsonKeyForProperties() throws JsonProcessingException {

        String serObj = objectMapper.writeValueAsString(employeeDto);
        System.out.println(serObj);
        assertThat(serObj, containsString("designation"));
    }
}
