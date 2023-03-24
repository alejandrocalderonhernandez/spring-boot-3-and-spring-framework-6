package com.debuggeando_ideas.best_travel.infraestructure.abstract_services;

public interface SimpleCrudService<RQ, RS, ID> {

    RS create(RQ request);

    RS read(ID id);

    void delete(ID id);
}
