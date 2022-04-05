package com.asuajeyeison.Alkemy.controller;

import com.asuajeyeison.Alkemy.entity.Personaje;
import com.asuajeyeison.Alkemy.service.implement.PersonajeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/character")
public class PersonajeController {

    @Autowired
    private PersonajeServiceImple personajeServi;

    @GetMapping("/all")
    public ResponseEntity<Collection<Personaje>> listarPersonas(){
        return new ResponseEntity<>(personajeServi.findAll(), HttpStatus.OK);
    }
}
