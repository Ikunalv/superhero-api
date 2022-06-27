package com.kunalv.superheroapi.repositories;

import com.kunalv.superheroapi.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarvelRepository extends JpaRepository<Superhero, Integer> {

    @Query(value = "select * from superhero where Alignment='good' and Publisher = 'Marvel Comics' ORDER BY RAND() limit 20",nativeQuery = true)
    public List<Superhero> getAllHeroes();

    @Query(value = "select * from superhero where Alignment='bad' and Publisher = 'Marvel Comics' ORDER BY RAND() limit 20",nativeQuery = true)
    public List<Superhero> getAllVillains();

    @Query(value = "select * from superhero where Publisher = 'Marvel Comics' ORDER BY RAND() limit 20",nativeQuery = true)
    public List<Superhero> getAllCharacters ();

    @Query(value = "select * from superhero where Alignment='good' and Publisher = 'Marvel Comics' and ID = :id", nativeQuery = true)
    public Superhero findHeroById(@Param("id") Integer id);

    @Query(value = "select * from superhero where Alignment='bad' and Publisher = 'Marvel Comics' and ID = :id", nativeQuery = true)
    public Superhero findVillainById(@Param("id") Integer id);

    @Query(value = "select Distinct * from superhero where  Publisher = 'Marvel Comics' and Name REGEXP :keywords", nativeQuery = true)
    public List<Superhero> search(@Param("keywords") String keywords);
}
