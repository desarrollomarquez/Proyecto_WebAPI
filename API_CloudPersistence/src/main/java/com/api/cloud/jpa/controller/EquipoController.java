package com.api.cloud.jpa.controller;

import com.api.cloud.jpa.exception.ResourceNotFoundException;
import com.api.cloud.jpa.model.Equipo;
import com.api.cloud.jpa.repository.AutoRepository;
import com.api.cloud.jpa.repository.EquipoRepository;

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
public class EquipoController {

    @Autowired
    EquipoRepository equipoRepository;

    @GetMapping("/equipos")
    public List<Equipo> getAllNotes() {
        return equipoRepository.findAll();
    }

    @PostMapping("/equipos")
    public Equipo createEquipo(@Valid @RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @GetMapping("/equipos/{id}")
    public Equipo getEquipoById(@PathVariable(value = "id") Long equipoId) {
        return equipoRepository.findById(equipoId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo", "id", equipoId));
    }

    @PutMapping("/equipos/{id}")
    public Equipo updateEquipo(@PathVariable(value = "id") Long equipoId,
                                           @Valid @RequestBody Equipo equipoDetails) {

        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo", "id", equipoId));

        equipo.setId(equipoDetails.getId());
        equipo.setSerial(equipoDetails.getSerial());
        equipo.setMarca(equipoDetails.getMarca());
        
        Equipo updatedEquipo = equipoRepository.save(equipo);
        return updatedEquipo;
    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<?> deleteEquipo(@PathVariable(value = "id") Long equipoId) {
        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo", "id", equipoId));

        equipoRepository.delete(equipo);

        return ResponseEntity.ok().build();
    }
}
