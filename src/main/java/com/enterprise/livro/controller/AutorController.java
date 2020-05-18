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

import com.enterprise.livro.entities.Autor;
import com.enterprise.livro.services.AutorService;

@Controller
@RequestMapping(value = "/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService; 

	@GetMapping
	public ResponseEntity<List<Autor>> findAll(){
		List<Autor> list = autorService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Autor> add(@RequestBody Autor autor){
		Autor aut = autorService.add(autor);
		return ResponseEntity.ok(aut);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Autor>> findById(@PathVariable Long id){
		Optional<Autor> aut = autorService.findById(id);
		return ResponseEntity.ok(aut);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		autorService.remove(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Autor> atualizar(@RequestBody Autor autor, @PathVariable Long id){
		Autor aut = autorService.atualizar(autor, id);
		return ResponseEntity.ok(aut);
	}
	
}
