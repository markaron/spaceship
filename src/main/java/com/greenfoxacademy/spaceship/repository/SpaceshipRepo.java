package com.greenfoxacademy.spaceship.repository;

import com.greenfoxacademy.spaceship.model.Spaceship;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpaceshipRepo extends CrudRepository<Spaceship,Long> {
  Optional<Spaceship> findById(Long id);
}
