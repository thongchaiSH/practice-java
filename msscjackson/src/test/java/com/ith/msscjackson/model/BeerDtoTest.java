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
        String json="{\"beerName\":\"LEO\",\"beerStyle\":\"ALE\",\"upc\":1234512345,\"price\":12.99,\"createdDate\":\"2021-07-27T11:00:20.59714+07:00\",\"lastUpdatedDate\":\"2021-07-27T11:00:20.597183+07:00\",\"myLocalDate\":\"20210727\",\"beerId\":\"2c85586e-fedf-4b0c-aada-baef9a270e3c\"}";

        BeerDto dto=objectMapper.readValue(json,BeerDto.class);

        System.out.println(dto);
    }
}