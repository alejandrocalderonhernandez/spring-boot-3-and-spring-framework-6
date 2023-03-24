package com.debuggeando_ideas.best_travel.domain.repositories.jpa;

import com.debuggeando_ideas.best_travel.domain.entities.jpa.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReservationRepository extends CrudRepository<ReservationEntity, UUID> {

}
