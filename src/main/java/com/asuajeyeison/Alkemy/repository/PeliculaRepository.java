package com.asuajeyeison.Alkemy.repository;

import com.asuajeyeison.Alkemy.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}