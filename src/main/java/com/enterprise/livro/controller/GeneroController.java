package com.enterprise.livro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enterprise.livro.entities.Genero;
import com.enterprise.livro.services.GeneroService;

@Controller
@RequestMapping(value = "/genero")
public class GeneroController {
	
	@Autowired
	private GeneroService generoService; 

	@GetMapping
	public ResponseEntity<List<Genero>> findAll(){
		List<Genero> list = generoService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Genero> add(@RequestBody Genero genero){
		Genero gen = generoService.add(genero);
		return ResponseEntity.ok(gen);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Genero>> findById(@PathVariable Long id){
		Optional<Genero> gen = generoService.findById(id);
		return ResponseEntity.ok(gen);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		generoService.remove(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Genero> atualizar(@RequestBody Genero genero, @PathVariable Long id){
		Genero gen = generoService.atualizar(genero, id);
		return ResponseEntity.ok(gen);
	}
	
}
