package com.ith.msscjackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto=super.getDto();
        String jsonString=objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json="{\"id\":\"3eb3a957-0b87-4a10-bfe4-f2119d7bcec9\",\"beerName\":\"LEO\",\"beerStyle\":\"ALE\",\"upc\":1234512345,\"price\":12.99,\"createdDate\":\"2021-07-27T09:14:36.949542+07:00\",\"lastUpdatedDate\":\"2021-07-27T09:14:36.949582+07:00\"}";

        BeerDto dto=objectMapper.readValue(json,BeerDto.class);

        System.out.println(dto);
    }
}