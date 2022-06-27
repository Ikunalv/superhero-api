package com.kunalv.superheroapi.controllers;

import com.kunalv.superheroapi.model.Superhero;
import com.kunalv.superheroapi.services.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/marvel")
public class MarvelController {

    @Autowired
    MarvelService marvelService;

    @GetMapping
    public ResponseEntity<List<Superhero>> getAllCharacters(){
        List<Superhero> characters = marvelService.getAllCharacters();
        return new ResponseEntity<List<Superhero>>(characters, HttpStatus.OK);
    }

    @GetMapping("/hero")
    public ResponseEntity<List<Superhero>> getAllHeroes(){
        List<Superhero> heroes = marvelService.getAllHeroes();
        return new ResponseEntity<List<Superhero>>(heroes, HttpStatus.OK);
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<Superhero> getHeroById(@PathVariable Integer id){
        Superhero hero = marvelService.getHeroById(id);
        return new ResponseEntity<Superhero>(hero, HttpStatus.OK);
    }

    @GetMapping("/villain")
    public ResponseEntity<List<Superhero>> getAllVillains(){
        List<Superhero> villains = marvelService.getAllVillains();
        return new ResponseEntity<List<Superhero>>(villains, HttpStatus.OK);
    }

    @GetMapping("/villain/{id}")
    public ResponseEntity<Superhero> getVillainById(@PathVariable Integer id){
        Superhero villain = marvelService.getVillainById(id);
        return new ResponseEntity<Superhero>(villain, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Superhero>> search(@RequestParam("query") String query){
        List<Superhero> characters = marvelService.search(query);
        return new ResponseEntity<List<Superhero>>(characters, HttpStatus.OK);
    }
}
