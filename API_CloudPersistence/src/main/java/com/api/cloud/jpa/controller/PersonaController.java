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
        
    	if(persona.getId() == null || persona.getId().equals(""))
    	{
    		return personaRepository.save(persona);	
    	}
    	else {
    	    
    		Persona persona = personaRepository.findById(personaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));

            persona.setIdentificacion(personaDetails.getIdentificacion());          
            persona.setNombres(personaDetails.getNombres());
            persona.setApellidos(personaDetails.getApellidos());
            
               
            Persona updatedPersona = personaRepository.save(persona);
            return updatedPersona;
    		
    	}

    }

    @GetMapping("/personas/{id}")
    public Persona getPersonaById(@PathVariable(value = "id") Long personaId) {
        return personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
    }

    @PutMapping("/personas/{id}")
    public Persona updatePersona(@PathVariable(value = "id") Long personaId,
                                           @Valid @RequestBody Persona personaDetails) {

    
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable(value = "id") Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));

        personaRepository.delete(persona);

        return ResponseEntity.ok().build();
    }
}
