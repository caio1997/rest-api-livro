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

import com.enterprise.livro.entities.Livro;
import com.enterprise.livro.services.LivroService;

@Controller
@RequestMapping(value = "/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService; 

	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = livroService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Livro> add(@RequestBody Livro livro){
		Livro liv = livroService.add(livro);
		return ResponseEntity.ok(liv);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Livro>> findById(@PathVariable Long id){
		Optional<Livro> liv = livroService.findById(id);
		return ResponseEntity.ok(liv);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		livroService.remove(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@RequestBody Livro livro, @PathVariable Long id){
		Livro liv = livroService.atualizar(livro, id);
		return ResponseEntity.ok(liv);
	}
	
}
