package com.debuggeando_ideas.best_travel.infraestructure.abstract_services;

import com.debuggeando_ideas.best_travel.api.models.responses.FlyResponse;

import java.util.Set;

public interface IFlyService extends CatalogService<FlyResponse> {

    Set<FlyResponse> readByOriginDestiny(String origen, String destiny);
}
