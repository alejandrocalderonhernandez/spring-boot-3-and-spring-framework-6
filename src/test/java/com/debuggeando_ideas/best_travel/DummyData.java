package com.debuggeando_ideas.best_travel;

import com.debuggeando_ideas.best_travel.domain.entities.jpa.HotelEntity;

import java.math.BigDecimal;
import java.util.List;

public class DummyData {

    public static final HotelEntity HOTEL_1 =HotelEntity.builder()
            .address("Test address 1")
                .name("Test name 1")
                .rating(5)
                .price(BigDecimal.valueOf(12.48))
            .build();

    public static final HotelEntity HOTEL_2 =HotelEntity.builder()
            .address("Test address 2")
                .name("Test name 2")
                .rating(4)
                .price(BigDecimal.valueOf(22.48))
            .build();

    public static final HotelEntity HOTEL_3 =HotelEntity.builder()
            .address("Test address 3")
                .name("Test name 3")
                .rating(3)
                .price(BigDecimal.valueOf(32.48))
            .build();


    public static final  List<HotelEntity> HOTEL_ENTITIES = List.of(HOTEL_1, HOTEL_2, HOTEL_3);
}
