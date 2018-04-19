package com.greenfoxacademy.spaceship.repository;

import com.greenfoxacademy.spaceship.model.Planet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanetRepo extends CrudRepository<Planet, Long> {
  Optional<Planet> findById(Long id);
}
