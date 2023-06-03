package com.debuggeando_ideas.best_travel.services;

import com.debuggeando_ideas.best_travel.DummyData;
import com.debuggeando_ideas.best_travel.api.models.responses.HotelResponse;
import com.debuggeando_ideas.best_travel.domain.entities.jpa.HotelEntity;
import com.debuggeando_ideas.best_travel.domain.repositories.jpa.HotelRepository;
import com.debuggeando_ideas.best_travel.infraestructure.services.HotelService;
import com.debuggeando_ideas.best_travel.spec.ServiceSpec;
import com.debuggeando_ideas.best_travel.util.enums.SortType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HotelServiceTest extends ServiceSpec {

    @MockBean
    private HotelRepository hotelRepositoryMock;

    @Autowired
    private HotelService hotelService;

    @Test
    @DisplayName("realAll should work")
    void realAll() {
        var page= new PageImpl<>(DummyData.HOTEL_ENTITIES);
        when(hotelRepositoryMock.findAll(isA(Pageable.class))).thenReturn(page);
        var target = this.hotelService.realAll(0, 5, SortType.NONE);
        assertEquals(3, target.getTotalElements());
        target.stream()
                        .forEach(t -> {
                            assertEquals(HotelResponse.class.getSimpleName(), t.getClass().getSimpleName());
                        });
        verify(hotelRepositoryMock, times(1)).findAll(any(Pageable.class));
    }

    @Test
    @DisplayName("readLessPrice should work")
    void readLessPrice() {
        var price = BigDecimal.valueOf(15);
        var hotelsResponse = Set.of(DummyData.HOTEL_1);
        when(hotelRepositoryMock.findByPriceLessThan(price)).thenReturn(hotelsResponse);
        var target = this.hotelService.readLessPrice(price);

        assertEquals(1, target.size());
        hotelsResponse.forEach(hotel -> {
            var response = this.entityToResponse(hotel);
            var expected = this.entityToResponse(DummyData.HOTEL_1);
            assertEquals(expected, response);
        });
        verify(hotelRepositoryMock, times(1)).findByPriceLessThan(price);
    }

    private HotelResponse entityToResponse(HotelEntity entity) {
        HotelResponse response = new HotelResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
