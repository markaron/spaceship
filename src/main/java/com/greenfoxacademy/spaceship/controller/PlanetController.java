package com.greenfoxacademy.spaceship.controller;

import com.greenfoxacademy.spaceship.repository.PlanetRepo;
import com.greenfoxacademy.spaceship.repository.SpaceshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanetController {

  @Autowired
  PlanetRepo planetRepo;

  @Autowired
  SpaceshipRepo spaceship;

  @GetMapping(value = "/")
  public String listPlanets(Model model) {
    model.addAttribute("planetList", planetRepo.findAll());
    model.addAttribute("spaceship", spaceship.findById(1L).get());
    return "main";
  }

}
