package com.ith.msscjackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BeerDtoTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testKebab() throws JsonProcessingException {
        BeerDto dto=super.getDto();
        String json=objectMapper.writeValueAsString(dto);
        System.out.println(json);
        //{"id":"d3a4e61a-cdf5-4d64-8ff6-47f1a64e00ad","beer-name":"LEO","beer-style":"ALE","upc":1234512345,"price":12.99,"created-date":"2021-07-27T09:56:58.248217+07:00","last-updated-date":"2021-07-27T09:56:58.248275+07:00"}
    }
}
