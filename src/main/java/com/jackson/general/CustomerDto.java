package com.jackson.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private String name;
    private Long id;

    @JsonUnwrapped
    private Address address;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Address {
        private String city;
        private String street;
        private String state;
        private String country;
        private Integer zipCode;
    }
}
