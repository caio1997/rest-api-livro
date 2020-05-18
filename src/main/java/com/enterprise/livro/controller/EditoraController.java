package com.enterprise.livro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.enterprise.livro.entities.Editora;
import com.enterprise.livro.services.EditoraService;

@Controller
public class EditoraController {
	
	@Autowired
	private EditoraService editoraService; 

	@GetMapping(value = "/editora")
	public ResponseEntity<List<Editora>> findAll(){
		List<Editora> list = editoraService.findAll();
		return ResponseEntity.ok(list);
	}
	
}
