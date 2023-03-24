package com.debuggeando_ideas.best_travel.domain.repositories.mongo;

import com.debuggeando_ideas.best_travel.domain.entities.documents.AppUserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserRepository extends MongoRepository<AppUserDocument, String> {

    Optional<AppUserDocument> findByUsername(String username);
}
