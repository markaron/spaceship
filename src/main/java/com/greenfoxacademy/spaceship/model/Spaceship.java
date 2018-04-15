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
  private int maxCapacity = 60;
  private String planet;
  private Long utilization;

  public Spaceship() {
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public void setMaxCapacity(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public String getPlanet() {
    return planet;
  }

  public void setPlanet(String planet) {
    this.planet = planet;
  }

  public Long getUtilization() {
    return utilization;
  }

  public void setUtilization(Long utilization) {
    this.utilization = utilization;
  }

  public void increaseUtil(Long num) {
    this.utilization += num;
  }

  public void decreaseUtil(Long num) {
    this.utilization -= num;
  }
}
