package com.ith.msscjackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BeerDtoTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto dto=super.getDto();
        String json=objectMapper.writeValueAsString(dto);
        System.out.println(json);
        //{"id":"207837fc-cf66-4232-8e44-bb9be83e117f","beer_name":"LEO","beer_style":"ALE","upc":1234512345,"price":12.99,"created_date":"2021-07-27T09:47:11.610002+07:00","last_updated_date":"2021-07-27T09:47:11.610088+07:00"}
    }
}
