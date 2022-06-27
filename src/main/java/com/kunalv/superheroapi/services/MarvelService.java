package com.kunalv.superheroapi.services;

import com.kunalv.superheroapi.model.Superhero;
import com.kunalv.superheroapi.repositories.MarvelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class MarvelService {

    @Autowired
    MarvelRepository marvelRepository;


    public List<Superhero> getAllHeroes(){
        List<Superhero> heroes = marvelRepository.getAllHeroes();
        if(heroes == null || heroes.isEmpty())
            return List.of();
        return heroes;
    }

    public List<Superhero> getAllVillains(){
        List<Superhero> villains = marvelRepository.getAllVillains();
        if(villains == null || villains.isEmpty())
            return List.of();
        return villains;
    }

    public List<Superhero> getAllCharacters(){
        List<Superhero> superheros = marvelRepository.getAllCharacters();
        if(superheros == null || superheros.isEmpty())
            return List.of();
        return superheros;
    }


    public Superhero getHeroById(Integer id){
        return marvelRepository.findHeroById(id);
    }

    public Superhero getVillainById(Integer id){
        return marvelRepository.findVillainById(id);
    }

    public List<Superhero> search(String query){
        Set<String> keywords = getKeywordsFromQuery(query);
        System.out.println("Keywords from query:"+keywords.toString());
        List<Superhero> superheros = marvelRepository.search(StringUtils.collectionToDelimitedString(keywords,"|"));
        if(superheros == null || superheros.isEmpty())
            return List.of();
        return superheros;
    }

    private Set<String> getKeywordsFromQuery(String query) {
        Set<String> keywords = new HashSet<>();
        Set<String> tokens = new LinkedHashSet<>(Arrays.asList(query.split(" "))) ;
        if(tokens.size()==1)
            return tokens;
        // Add - for spaces
        String keyword1 = String.join("-",tokens);
        keywords.add(keyword1);
        // Remove spaces
        String keyword2 = String.join("",tokens);
        keywords.add(keyword2);
        keywords.add(query);
        return keywords;
    }

//    public static void main(String[] args) {
//
//        MarvelService marvelService = new MarvelService();
//        String query = "spider man ii";
//        System.out.println(marvelService.getKeywordsFromQuery(query));
//    }
}
