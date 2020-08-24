package com.jackson.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class JsonFilterTest {

    ObjectMapper objectMapper;
    FilterDemoBean bean;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        bean = FilterDemoBean.builder()
                    .id(11l)
                    .gender("Male")
                    .name("Jatin")
                    .build();
    }

    @Test
    void testJsonFilter() throws JsonProcessingException {
        FilterProvider filterProvider = new SimpleFilterProvider().
                addFilter("customFilter",
                        SimpleBeanPropertyFilter.filterOutAllExcept("name"));
        String jsonString = objectMapper.writer(filterProvider).writeValueAsString(bean);
        assertThat(jsonString, containsString("Jatin"));
        assertThat(jsonString, not(containsString("11")));
    }
}
