package com.api.mileniocloud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.mileniocloud.entity.Departamento;
import com.api.mileniocloud.service.DepartamentoService;
import com.api.mileniocloud.service.IDepartamentoService;


@Controller
@RequestMapping("user")
public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService departamentoService;
	
	@GetMapping("departamento/{id}")
	public ResponseEntity<Departamento> getDepartamentoById(@PathVariable("id") String id) {
		Departamento departamento = departamentoService.getDepartamentoById(id);
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);				
	}
	
	@GetMapping("departamentos")
	public ResponseEntity<List<Departamento>> getAllDepartamentos() {
		List<Departamento> list = departamentoService.getAllDepartamentos();
		return new ResponseEntity<List<Departamento>>(list, HttpStatus.OK);
	}
	
	@PostMapping("departamento")
	public ResponseEntity<Void> addDepartamento(@RequestBody Departamento departamento, UriComponentsBuilder builder) {
        boolean flag = departamentoService.addDepartamento(departamento);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/departamento/{id}").buildAndExpand(departamento.getCodigo_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("departamento")
	public ResponseEntity<Departamento> updateDepartamento(@RequestBody Departamento departamento) {
		departamentoService.updateDepartamento(departamento);
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
	@DeleteMapping("departamento/{id}")
	public ResponseEntity<Void> deleteColegio(@PathVariable("id") String id) {
		departamentoService.deleteDepartamento(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 