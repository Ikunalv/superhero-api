package com.kunalv.superheroapi.services;

import com.kunalv.superheroapi.model.Superhero;
import com.kunalv.superheroapi.repositories.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {

    @Autowired
    SuperheroRepository superheroRepository;

    public List<Superhero> getAllSuperheros(){
        return superheroRepository.getSuperheros();
    }

    public Superhero getSuperheroById(Integer id){
        return superheroRepository.getSuperheroById(id);
    }
}
