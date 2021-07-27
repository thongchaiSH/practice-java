package com.ith.msscjackson.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    BeerDto getDto(){
        return  BeerDto.builder()
                .beerName("LEO")
                .beerStyle("ALE")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(1234512345L)
                .myLocalDate(LocalDate.now())
                .build();
    }
}
