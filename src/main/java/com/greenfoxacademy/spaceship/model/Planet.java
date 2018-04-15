package com.greenfoxacademy.spaceship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;
  private String name;
  private Long population;

  public Planet() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  public void increasePop(Long pop) {
    this.population += pop;
  }

  public void decreasePop(Long pop) {
    this.population -= pop;
  }
}
