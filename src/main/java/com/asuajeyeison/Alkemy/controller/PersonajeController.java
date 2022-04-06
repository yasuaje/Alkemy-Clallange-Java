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
@RequestMapping("/characters")
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

    @GetMapping(params = "name")
    public ResponseEntity<List<Personaje>> findCharacterByName(@RequestParam(value = "name", required = false) String nombre) {
        return new ResponseEntity<>(personajeServi.buscarPersonajePorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping(params = "age")
    public ResponseEntity<List<Personaje>> findCharacterByEdad(@RequestParam(value = "age", required = false) int edad) {
        return new ResponseEntity<>(personajeServi.buscarPersonajePorEdad(edad), HttpStatus.OK);
    }
    @GetMapping(params="movie")
    public ResponseEntity<List<Personaje>> findCharacterByMovieId(@RequestParam(value = "movie", required = false) Long id) {
        return new ResponseEntity<>(personajeServi.findByPeliculaId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> guardarPersonaje(@RequestBody Personaje personaje){
        return new ResponseEntity<>(personajeServi.save(personaje),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonaje(@PathVariable long id){
        personajeServi.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
