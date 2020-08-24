package com.jackson.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;

    @JsonIgnoreType
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Address {
        private String streetName;
        private String state;
        private String city;
    }

    private Address address;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
