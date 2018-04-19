package com.greenfoxacademy.spaceship.controller;

import com.greenfoxacademy.spaceship.model.Planet;
import com.greenfoxacademy.spaceship.model.SpaceShipException;
import com.greenfoxacademy.spaceship.model.Spaceship;
import com.greenfoxacademy.spaceship.repository.PlanetRepo;
import com.greenfoxacademy.spaceship.repository.SpaceshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

  @PostMapping(value = "/movehere/{id}")
  public String moveHere(@PathVariable(name = "id") Long id) throws SpaceShipException{

    Optional<Spaceship> ship = spaceshipRepo.findById(1L);
    Optional<Planet> targetPlanet = planetRepo.findById(id);

    if (ship.isPresent() && targetPlanet.isPresent()) {
      ship.get().setPlanet(targetPlanet.get().getName());
      spaceshipRepo.save(ship.get());
    } else {
      throw new SpaceShipException("Ship is not found");
    }
    return "redirect:/";
  }

  @GetMapping(value = "/toplanet/{id}")
  public String addToPlanet(@PathVariable(name = "id") Long id){
    Planet newPlanet = planetRepo.findById(id).get();
    Spaceship newShip = spaceshipRepo.findById(1L).get();
    newPlanet.increasePop(spaceshipRepo.findById(1L).get().getUtilization());
    newShip.setUtilization(0L);
    spaceshipRepo.save(newShip);
    planetRepo.save(newPlanet);
    return "redirect:/";
  }

  @GetMapping(value = "/topship/{id}")
  public String addToShip(@PathVariable(name = "id") Long id){
    Planet newPlanet = planetRepo.findById(id).get();
    Spaceship newShip = spaceshipRepo.findById(1L).get();
    Long freeSpace = newShip.getMaxCapacity() - newShip.getUtilization();
    if(newPlanet.getPopulation() <= freeSpace){
      newShip.increaseUtil(newPlanet.getPopulation());
      newPlanet.setPopulation(0L);
    } else {
      newPlanet.decreasePop(freeSpace);
      newShip.increaseUtil(freeSpace);
    }
    spaceshipRepo.save(newShip);
    planetRepo.save(newPlanet);
    return "redirect:/";
  }
}
