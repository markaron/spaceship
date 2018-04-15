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
  private int population;

  public Planet() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }
}
