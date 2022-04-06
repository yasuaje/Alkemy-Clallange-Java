package com.asuajeyeison.Alkemy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pelicula_id", nullable = false)
    private Long id;
    private String imagen;
    private String titulo;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date fechaCreacion;
    private Integer clasificacion;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "personajes_peliculas", joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "personaje_id", referencedColumnName = "personaje_id"))
    private Set<Personaje> personajes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "peliculas_generos", joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "genero_id", referencedColumnName = "genero_id"))
    private Set<Genero> generos = new HashSet<>();
}

