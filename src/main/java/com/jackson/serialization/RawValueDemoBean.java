package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RawValueDemoBean {

    private Long id;
    private String name;

    @JsonRawValue
    private String address;


}
