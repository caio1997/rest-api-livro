package com.enterprise.livro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.livro.entities.Editora;
import com.enterprise.livro.repository.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository editoraRepository;

	public List<Editora> findAll(){
		return editoraRepository.findAll();
	}
	
	public Editora add(Editora editora){
		return editoraRepository.save(editora);
	}
	
}
