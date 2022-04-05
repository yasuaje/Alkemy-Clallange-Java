package com.asuajeyeison.Alkemy.service.implement;

import com.asuajeyeison.Alkemy.entity.Personaje;
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
}