package com.greenfoxacademy.spaceship.repository;

import com.greenfoxacademy.spaceship.model.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepo extends CrudRepository<Planet, Long> {
}
