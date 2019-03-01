package com.api.cloud.jpa.controller;

import com.api.cloud.jpa.exception.ResourceNotFoundException;
import com.api.cloud.jpa.model.Auto;
import com.api.cloud.jpa.repository.AutoRepository;

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
    AutoRepository autoRepository;

    @GetMapping("/autos")
    public List<Auto> getAllNotes() {
        return autoRepository.findAll();
    }

    @PostMapping("/autos")
    public Auto createAuto(@Valid @RequestBody Auto auto) {
        return autoRepository.save(auto);
    }

    @GetMapping("/autos/{id}")
    public Auto getAutoById(@PathVariable(value = "id") Long autoId) {
        return autoRepository.findById(autoId)
                .orElseThrow(() -> new ResourceNotFoundException("Auto", "id", autoId));
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
