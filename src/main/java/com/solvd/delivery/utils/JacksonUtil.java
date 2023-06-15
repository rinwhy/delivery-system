package com.solvd.delivery.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonUtil {

    private static final Logger LOGGER = LogManager.getLogger(JacksonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void serializeObject(Object object, File file) {
        try {
            objectMapper.writeValue(file, object);
            System.out.println(objectMapper.writeValueAsString(object));
        } catch (IOException e) {
            LOGGER.warn("Error writing the value, IOException" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T> T deserializeToObject(Class<T> object, File file) {
        try {
            return objectMapper.readValue(file, object);
        } catch (IOException e) {
            LOGGER.warn("Error processing JSON" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
