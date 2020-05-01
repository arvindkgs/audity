package com.akgs.application.audity.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class URLDecode extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String value = parser.getValueAsString();
        System.out.println("todecode = " + value);
        String decodedValue = java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        System.out.println("decodedValue = " + decodedValue);
        return decodedValue;
    }
}
