package com.enterprise.livro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.livro.entities.Editora;
import com.enterprise.livro.services.EditoraService;

@Controller
@RequestMapping(value = "/editora")
public class EditoraController {
	
	@Autowired
	private EditoraService editoraService; 

	@GetMapping
	public ResponseEntity<List<Editora>> findAll(){
		List<Editora> list = editoraService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Editora> add(@RequestBody Editora editora){
		Editora edi = editoraService.add(editora);
		return ResponseEntity.ok(edi);
	}
	
}
