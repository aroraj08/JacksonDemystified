package com.jackson.deserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public final class EmployeeDto {

    private final String firstName;
    private final String lastName;
    private final Long id;

    @JsonCreator
    public EmployeeDto(@JsonProperty("first-name") String firstName,
                       @JsonProperty("last-name") String lastName,
                       @JsonProperty("id") Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
