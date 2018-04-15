package com.greenfoxacademy.spaceship.repository;

import com.greenfoxacademy.spaceship.model.Spaceship;
import org.springframework.data.repository.CrudRepository;

public interface SpaceshipRepo extends CrudRepository<Spaceship,Long> {
}
