package com.asuajeyeison.Alkemy.service.implement;

import com.asuajeyeison.Alkemy.entity.Personaje;
import com.asuajeyeison.Alkemy.exception.ResourceNotFoundException;
import com.asuajeyeison.Alkemy.repository.PersonajeRepository;
import com.asuajeyeison.Alkemy.service.IPersonajeServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImple implements IPersonajeServi {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> findAll() {
        return  personajeRepository.findAll();
    }

    @Override
    public Personaje findPersonajeById(Long personajeId) {
        return personajeRepository.findById(personajeId).orElseThrow(() -> new ResourceNotFoundException("Personaje con id numero : " + personajeId + " no existe"));
    }

    @Override
    public List<Personaje> buscarPersonajePorNombre(String nombre) {
        return personajeRepository.findByNombre(nombre);
    }

    @Override
    public List<Personaje> buscarPersonajePorEdad(int edad) {
        return personajeRepository.findByEdad(edad);
    }
}

