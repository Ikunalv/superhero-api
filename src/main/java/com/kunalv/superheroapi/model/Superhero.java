package com.kunalv.superheroapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "superhero")
public class Superhero {
    @Id
    @Basic
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Alignment")
    private String alignment;
    @Basic
    @Column(name = "Gender")
    private String gender;
    @Basic
    @Column(name = "EyeColor")
    private String eyeColor;
    @Basic
    @Column(name = "Race")
    private String race;
    @Basic
    @Column(name = "HairColor")
    private String hairColor;
    @Basic
    @Column(name = "Publisher")
    private String publisher;
    @Basic
    @Column(name = "SkinColor")
    private String skinColor;
    @Basic
    @Column(name = "Height")
    private Double height;
    @Basic
    @Column(name = "Weight")
    private Integer weight;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero that = (Superhero) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(alignment, that.alignment) && Objects.equals(gender, that.gender) && Objects.equals(eyeColor, that.eyeColor) && Objects.equals(race, that.race) && Objects.equals(hairColor, that.hairColor) && Objects.equals(publisher, that.publisher) && Objects.equals(skinColor, that.skinColor) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alignment, gender, eyeColor, race, hairColor, publisher, skinColor, height, weight);
    }
}
