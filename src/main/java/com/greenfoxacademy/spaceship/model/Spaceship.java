package com.greenfoxacademy.spaceship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spaceship {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;
  private int max_capacity = 60;
  private String planet;
  private int utilization;

  public Spaceship() {
  }

  public int getMax_capacity() {
    return max_capacity;
  }

  public void setMax_capacity(int max_capacity) {
    this.max_capacity = max_capacity;
  }

  public String getPlanet() {
    return planet;
  }

  public void setPlanet(String planet) {
    this.planet = planet;
  }

  public int getUtilization() {
    return utilization;
  }

  public void setUtilization(int utilization) {
    this.utilization = utilization;
  }
}
