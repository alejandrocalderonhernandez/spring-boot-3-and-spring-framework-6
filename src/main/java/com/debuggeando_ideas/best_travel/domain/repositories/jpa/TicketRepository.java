package com.debuggeando_ideas.best_travel.domain.repositories.jpa;

import com.debuggeando_ideas.best_travel.domain.entities.jpa.TicketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends CrudRepository<TicketEntity, UUID> {

    Optional<TicketEntity> findByTourId(Long id);
}
