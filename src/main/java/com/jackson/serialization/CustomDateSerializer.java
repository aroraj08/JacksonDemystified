package com.jackson.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializer extends StdSerializer<LocalDateTime> {

    private final String format = "dd-MM-yyyy HH:mm:ss";

    public CustomDateSerializer() {
        this(null);
    }

    public CustomDateSerializer(Class<LocalDateTime> t) {
        super(t);
    }

   @Override
    public void serialize(LocalDateTime date, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        jsonGenerator.writeString(date.format(formatter));
    }
}
