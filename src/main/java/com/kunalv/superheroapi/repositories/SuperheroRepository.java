package com.kunalv.superheroapi.repositories;

import com.kunalv.superheroapi.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SuperheroRepository extends JpaRepository<Superhero,Integer> {

    Superhero getSuperheroById(Integer id);

    @Query(value = "SELECT * from Superhero",nativeQuery = true)
    List<Superhero> getSuperheros();


}

