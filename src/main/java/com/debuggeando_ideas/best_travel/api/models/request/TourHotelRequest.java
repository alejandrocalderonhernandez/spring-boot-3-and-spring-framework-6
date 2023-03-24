package com.debuggeando_ideas.best_travel.api.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TourHotelRequest implements Serializable {

    @Positive
    @NotNull(message = "Id hotel is mandatory")
    public Long id;
    @Positive
    @NotNull(message = "Total days is mandatory")
    private Integer totalDays;
}
