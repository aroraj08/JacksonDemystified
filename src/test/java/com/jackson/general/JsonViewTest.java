package com.jackson.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.general.views.Views;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class JsonViewTest {

    ViewDemoBean bean;
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        bean = ViewDemoBean.builder()
                    .gender("Male")
                    .name("Kapil")
                    .id(122l).build();
    }

    @Test
    void testWithPublicView() throws JsonProcessingException {
        String jsonString = objectMapper.writerWithView(Views.Public.class)
                .writeValueAsString(bean);
        assertThat(jsonString, containsString("Kapil"));
        assertThat(jsonString, not(containsString("gender")));
    }

    @Test
    void testWithInternalView() throws JsonProcessingException {
        String jsonString = objectMapper.writerWithView(Views.Internal.class)
                .writeValueAsString(bean);
        assertThat(jsonString, containsString("Kapil"));
        assertThat(jsonString, containsString("gender"));
    }

}
