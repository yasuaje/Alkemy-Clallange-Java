package com.asuajeyeison.Alkemy.controller;

import com.asuajeyeison.Alkemy.entity.Personaje;
import com.asuajeyeison.Alkemy.service.implement.PersonajeServiceImple;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/character")
public class PersonajeController {

    @Autowired
    private PersonajeServiceImple personajeServi;

    @GetMapping("/all")
    public ResponseEntity<Collection<Personaje>> listarPersonas() {
        return new ResponseEntity<>(personajeServi.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{personaje_id}")
    public ResponseEntity<Personaje> getPersonajeById(@PathVariable("personaje_id") Long id) {
        Personaje personaje = personajeServi.findPersonajeById(id);
        return new ResponseEntity<>(personaje, HttpStatus.OK);
    }

    @GetMapping(params = "nombre")
    public ResponseEntity<List<Personaje>> findCharacterByName(@RequestParam(value = "nombre", required = false) String nombre) {

        return new ResponseEntity<>(personajeServi.buscarPersonajePorNombre(nombre), HttpStatus.OK);

    }
}
