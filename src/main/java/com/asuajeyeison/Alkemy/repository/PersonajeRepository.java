package com.asuajeyeison.Alkemy.repository;

import com.asuajeyeison.Alkemy.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    Optional<Personaje> findPersonajeById(Long id);

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(int edad);
}