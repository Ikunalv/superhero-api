package com.kunalv.superheroapi.controllers;

import com.kunalv.superheroapi.model.Superhero;

import com.kunalv.superheroapi.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/superheros")
public class SuperheroController {

    @Autowired
    SuperheroService superheroService;
    @GetMapping
    public ResponseEntity<List<Superhero>> getSuperheros(){
        List<Superhero> allSuperheros = superheroService.getAllSuperheros();
        return new ResponseEntity<List<Superhero>>(allSuperheros,  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable Integer id){
        Superhero allSuperheros = superheroService.getSuperheroById(id);
        return new ResponseEntity<Superhero>(allSuperheros,  HttpStatus.OK);
    }
}
