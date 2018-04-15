package com.greenfoxacademy.spaceship.controller;

import com.greenfoxacademy.spaceship.model.Planet;
import com.greenfoxacademy.spaceship.model.Spaceship;
import com.greenfoxacademy.spaceship.repository.PlanetRepo;
import com.greenfoxacademy.spaceship.repository.SpaceshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlanetController {

  @Autowired
  PlanetRepo planetRepo;

  @Autowired
  SpaceshipRepo spaceshipRepo;

  @GetMapping(value = "/")
  public String listPlanets(Model model) {
    model.addAttribute("planetList", planetRepo.findAll());
    model.addAttribute("spaceship", spaceshipRepo.findById(1L).get());
    return "main";
  }

  @GetMapping(value = "/movehere/{id}")
  public String moveHere(@PathVariable(name = "id") Long id){
    Spaceship newShip = spaceshipRepo.findById(1L).get();
    newShip.setPlanet(planetRepo.findById(id).get().getName());
    spaceshipRepo.save(newShip);
    return "redirect:/";
  }

  @GetMapping(value = "/toplanet/{id}")
  public String addToPlanet(@PathVariable(name = "id") Long id){
    Planet newPlanet = planetRepo.findById(id).get();
    newPlanet.increasePop(spaceshipRepo.findById(1L).get().getUtilization());
    planetRepo.save(newPlanet);
    return "redirect:/";
  }

}
