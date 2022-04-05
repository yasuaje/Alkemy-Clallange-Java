package com.asuajeyeison.Alkemy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id", nullable = false)
    private Long id;
    private String nombre;
    private String image;

    @ManyToMany
    @JoinTable(name = "pelicula_genero",joinColumns = @JoinColumn(name = "genero_id",referencedColumnName = "genero_id"),inverseJoinColumns = @JoinColumn(name = "pelicula_id",referencedColumnName = "pelicula_id"))
    private Set<Pelicula> peliculas = new HashSet<>();

}