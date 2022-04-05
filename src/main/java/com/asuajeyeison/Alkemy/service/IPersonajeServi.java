package com.asuajeyeison.Alkemy.service;

import com.asuajeyeison.Alkemy.entity.Personaje;

import java.util.List;

public interface IPersonajeServi {

    List<Personaje> findAll();

    Personaje findPersonajeById(Long personajeId);

    List<Personaje> buscarPersonajePorNombre(String nombre);

    List<Personaje> buscarPersonajePorEdad(int edad);

}
