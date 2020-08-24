package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Map<String, Object> properties;

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }
}
