package com.asuajeyeison.Alkemy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaje_id", nullable = false)
    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;

    @ManyToMany
    @JoinTable(name = "personajes_peliculas", joinColumns = @JoinColumn(name = "personaje_id", referencedColumnName = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"))

    @JsonManagedReference
    private Set<Pelicula> peliculas = new HashSet<>();
}