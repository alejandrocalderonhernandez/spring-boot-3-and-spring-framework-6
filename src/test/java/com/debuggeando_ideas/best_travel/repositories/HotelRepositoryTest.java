package com.debuggeando_ideas.best_travel.repositories;

import com.debuggeando_ideas.best_travel.DummyData;
import com.debuggeando_ideas.best_travel.domain.repositories.jpa.HotelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    @DisplayName("findByPriceLessThan should works")
    void findByPriceLessThan() {
        var price = BigDecimal.valueOf(100);
        var target = this.hotelRepository.findByPriceLessThan(price);
        assertEquals(12, target.size());

        price = BigDecimal.valueOf(1);
        target = this.hotelRepository.findByPriceLessThan(price);
        assertTrue(target.isEmpty());
    }

    @Test
    @DisplayName("findByPriceIsBetween should works")
    void findByPriceIsBetween() {
        var min = BigDecimal.valueOf(100);
        var max = BigDecimal.valueOf(1000);
        var target = this.hotelRepository.findByPriceIsBetween(min, max);
        assertEquals(6, target.size());

        min = BigDecimal.valueOf(1000000);
        max = BigDecimal.valueOf(2000000);
        target = this.hotelRepository.findByPriceIsBetween(min, max);
        assertTrue(target.isEmpty());
    }

    @Test
    @DisplayName("findByRatingGreaterThan should works")
    void findByRatingGreaterThan() {
        var rating = 4;
        var target = this.hotelRepository.findByRatingGreaterThan(rating);
        assertEquals(8, target.size());
    }


    @Test
    @DisplayName("save should works")
    void save() {
        var hotelEntity = DummyData.HOTEL_1;
        var target = this.hotelRepository.save(hotelEntity);
        assertNotNull(target.getId());

        Assertions.assertThat(hotelEntity)
                .usingRecursiveComparison()
                .isEqualTo(target);

        assertThrows(InvalidDataAccessApiUsageException.class, () -> this.hotelRepository.save(null));
    }

    @Test
    @DisplayName("delete should works")
    void delete() {
       assertDoesNotThrow(() ->   this.hotelRepository.deleteById(1L));
       assertThrows(InvalidDataAccessApiUsageException.class, () ->   this.hotelRepository.deleteById(null));
    }

    @Test
    @DisplayName("findById should works")
    void findById() {
        var target = this.hotelRepository.findById(3L).orElseThrow();
        assertEquals("La Odisea", target.getName());
        assertEquals("Grecia 99", target.getAddress());
        assertEquals(5, target.getRating());
    }


}
