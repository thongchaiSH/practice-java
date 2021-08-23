package com.tutorial.feign.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;


@Slf4j
public final class JsonUtils
{
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectReader READER = MAPPER.readerFor(new TypeReference<Map<String, Object>>()
    {
    });

    private JsonUtils()
    {
        throw new AssertionError("Utility class cannot be initialize");
    }

    public static String toJson(Object object) throws JsonProcessingException
    {
        String jsonString = null;
        if(nonNull(object))
        {
            log.info("toJavaBean. Object {} converting to Json string", object.getClass().getName());
            jsonString = MAPPER.writeValueAsString(object);
        }

        return jsonString;
    }

    public static void toFile(Object object, String filename) throws IOException
    {
        if(nonNull(object))
        {
            log.info("toJavaBean. Object {} converting to file", object.getClass().getName());
            MAPPER.writeValue(new File(filename), object);
        }
    }

    public static Map<String, Object> toMap(String jsonString) throws JsonProcessingException, IOException
    {
        Map<String, Object> map = new LinkedHashMap<>();

        if(isNotBlank(jsonString))
        {
            log.info("toMap. jsonString converting to LinkedHashMap<String, Object>");
            map = READER.readValue(jsonString);
        }

        return map;
    }
    public static Object fromJson(String str) {
		Object obj = null;
		if (nonNull(str)) {
			try {
				obj = MAPPER.readValue(str, Object.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;

	}
    public static <T> T toJavaBean(String jsonString, Class<T> clazz) throws JsonProcessingException, IOException
    {
        T javaBean = null;

        if(isNotBlank(jsonString))
        {
            log.info("toJavaBean. jsonString converting to {}", clazz.getName());
            javaBean = MAPPER.readValue(jsonString, clazz);
        }
        else
        {
            log.info("toJavaBean. jsonString to convert is blank. class={}", clazz.getName());
        }
        return javaBean;
    }

    public static <T> T toJavaBeanIgnoreCase(String jsonString, Class<T> clazz) throws JsonProcessingException, IOException
    {
        T javaBean = null;

        if(isNotBlank(jsonString))
        {
            MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            log.info("toJavaBean. jsonString converting to {}", clazz.getName());
            javaBean = MAPPER.readValue(jsonString, clazz);
            MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
        }
        else
        {
            log.info("toJavaBean. jsonString to convert is blank. class={}", clazz.getName());
        }

        return javaBean;
    }
}
