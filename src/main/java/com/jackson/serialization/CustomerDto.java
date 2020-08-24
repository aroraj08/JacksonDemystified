package com.jackson.serialization;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY) //only include non-empty value in serialization
@JsonPropertyOrder({"firstName", "lastName", "id"})
public class CustomerDto {

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

    @JsonGetter(value="first-name")
    public String getFirstName() {
        return firstName;
    }
}
