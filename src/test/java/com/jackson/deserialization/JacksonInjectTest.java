package com.jackson.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class JacksonInjectTest {

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testDeSerializingWithJacksonInject() throws JsonProcessingException {
        String jsonString = "{\"name\": \"Mary Parker\"}";
        InjectableValues injectableValues = new InjectableValues.Std()
                                            .addValue(Long.class, 211l)
                                            .addValue(Double.class, 200_000.0);
        JacksonInjectDemoBean bean =
                objectMapper.reader(injectableValues).forType(JacksonInjectDemoBean.class)
                                    .readValue(jsonString);

        assertThat(bean.getId(), is(equalTo(211l)));
        assertThat(bean.getName(), is(equalTo("Mary Parker")));
        assertThat(bean.getSalary(), is(equalTo(200_000.0)));
    }
}
