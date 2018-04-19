package com.greenfoxacademy.spaceship.model;

public class SpaceShipException extends Exception {

  public SpaceShipException(String message) {
    super(message);
  }

  public SpaceShipException(String message, Throwable cause) {
    super(message, cause);
  }
}

