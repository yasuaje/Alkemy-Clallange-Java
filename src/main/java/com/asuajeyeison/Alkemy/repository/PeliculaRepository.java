package com.asuajeyeison.Alkemy.repository;

import com.asuajeyeison.Alkemy.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

   // Optional<Pelicula> findByPeliculaId(Long id);

    // List<Pelicula> findByTitulo(String titulo);

    // List<Pelicula> findByGeneroId(Long id);

    // List<Pelicula> findAllByOrderByCreationDateAsc();

    // List<Pelicula> findAllByOrderByCreationDateDesc();
}