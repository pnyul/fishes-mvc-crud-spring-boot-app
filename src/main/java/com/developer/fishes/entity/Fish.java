package com.developer.fishes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fish")
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "species")
    private String species;

    @Column(name = "genus")
    private String genus;

    @Column(name = "family")
    private String family;

    @Column(name = "max_length")
    private Integer maxLength;

    public Fish(String species, String genus, String family, Integer maxLength) {
        this.species = species;
        this.genus = genus;
        this.family = family;
        this.maxLength = maxLength;
    }

}











