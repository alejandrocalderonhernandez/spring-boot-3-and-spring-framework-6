package com.debuggeando_ideas.best_travel.services;

import com.debuggeando_ideas.best_travel.DummyData;
import com.debuggeando_ideas.best_travel.api.models.responses.HotelResponse;
import com.debuggeando_ideas.best_travel.domain.entities.jpa.HotelEntity;
import com.debuggeando_ideas.best_travel.domain.repositories.jpa.HotelRepository;
import com.debuggeando_ideas.best_travel.infraestructure.services.HotelService;
import com.debuggeando_ideas.best_travel.spec.ServiceSpec;
import com.debuggeando_ideas.best_travel.util.enums.SortType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HotelServiceTest extends ServiceSpec {

    @MockBean
    private HotelRepository hotelRepositoryMock;

    @Autowired
    private HotelService hotelService;



    @Test
    @DisplayName("realAll should work")
    void realAll() {
        var page= new PageImpl<HotelEntity>(DummyData.HOTEL_ENTITIES);
        when(hotelRepositoryMock.findAll(isA(Pageable.class))).thenReturn(page);
        var target = this.hotelService.realAll(0, 5, SortType.NONE);
        assertEquals(3, target.getTotalElements());
        target.stream()
                        .forEach(t -> {
                            assertEquals(HotelResponse.class.getSimpleName(), t.getClass().getSimpleName());
                        });
        verify(hotelRepositoryMock, times(1)).findAll(any(Pageable.class));
    }
}
