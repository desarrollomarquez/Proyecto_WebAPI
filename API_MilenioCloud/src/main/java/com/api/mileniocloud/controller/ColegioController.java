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

import com.api.mileniocloud.entity.Colegio;
import com.api.mileniocloud.service.IColegioService;


@Controller
@RequestMapping("user")
public class ColegioController {
	
	@Autowired
	private IColegioService colegioService;
	
	@GetMapping("colegio/{id}")
	public ResponseEntity<Colegio> getColegioById(@PathVariable("id") Integer id) {
		Colegio colegio = colegioService.getColegioById(id);
		return new ResponseEntity<Colegio>(colegio, HttpStatus.OK);				
	}
	
	@GetMapping("colegios")
	public ResponseEntity<List<Colegio>> getAllColegios() {
		List<Colegio> list = colegioService.getAllColegios();
		return new ResponseEntity<List<Colegio>>(list, HttpStatus.OK);
	}
	
	@PostMapping("colegio")
	public ResponseEntity<Void> addColegio(@RequestBody Colegio colegio, UriComponentsBuilder builder) {
        boolean flag = colegioService.addColegio(colegio);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/colegio/{id}").buildAndExpand(colegio.getCodigo_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("colegio")
	public ResponseEntity<Colegio> updateColegio(@RequestBody Colegio colegio) {
		colegioService.updateColegio(colegio);
		return new ResponseEntity<Colegio>(colegio, HttpStatus.OK);
	}
	
	@DeleteMapping("colegio/{id}")
	public ResponseEntity<Void> deleteColegio(@PathVariable("id") Integer id) {
		colegioService.deleteColegio(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 