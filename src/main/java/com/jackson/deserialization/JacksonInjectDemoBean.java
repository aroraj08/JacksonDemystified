package com.jackson.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JacksonInjectDemoBean {

    @JacksonInject
    private Long id = 0l;
    private String name;

    @JacksonInject
    private Double salary = 0.0;
}
