package com.api.cloud.jpa.controller;

import com.api.cloud.jpa.exception.ResourceNotFoundException;
import com.api.cloud.jpa.model.Persona;
import com.api.cloud.jpa.repository.AutoRepository;
import com.api.cloud.jpa.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by diego on 14/02/19.
 */
@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> getAllNotes() {
        return personaRepository.findAll();
    }

    @PostMapping("/personas")
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping("/personas/{id}")
    public Persona getPersonaById(@PathVariable(value = "id") Long PersonaId) {
        return personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
    }

    @PutMapping("/autos/{id}")
    public Auto updateAuto(@PathVariable(value = "id") Long autoId,
                                           @Valid @RequestBody Auto autoDetails) {

        Auto auto = autoRepository.findById(autoId)
                .orElseThrow(() -> new ResourceNotFoundException("Auto", "id", autoId));

        auto.setPlaca(autoDetails.getPlaca());
        auto.setModelo(autoDetails.getModelo());
        

        Auto updatedAuto = autoRepository.save(auto);
        return updatedAuto;
    }

    @DeleteMapping("/autos/{id}")
    public ResponseEntity<?> deleteAuto(@PathVariable(value = "id") Long autoId) {
        Auto auto = autoRepository.findById(autoId)
                .orElseThrow(() -> new ResourceNotFoundException("Auto", "id", autoId));

        autoRepository.delete(auto);

        return ResponseEntity.ok().build();
    }
}
