package com.jackson.general;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonFilter("customFilter")
public class FilterDemoBean {

    private Long id;
    private String name;
    private String gender;
}
