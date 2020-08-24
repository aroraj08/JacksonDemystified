package com.jackson.deserialization;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;

    private Map<String, Object> properties = new HashMap<>();

    @JsonSetter("paymentId")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonAnySetter
    public void setProperties(String key, Object value) {
        properties.put(key, value);
    }
}
