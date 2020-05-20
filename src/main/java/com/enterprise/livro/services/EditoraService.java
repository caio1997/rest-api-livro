package com.enterprise.livro.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enterprise.livro.entities.Editora;
import com.enterprise.livro.repository.EditoraRepository;
import com.enterprise.livro.services.exceptions.DeleteException;
import com.enterprise.livro.services.exceptions.ExceptionsGerais;

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
	
	public Optional<Editora> findById(Long id) {
		return editoraRepository.findById(id);
	}
	
	public void remove(Long id) {
		try {
			editoraRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionsGerais("Id não encontrado!");
		}catch(DataIntegrityViolationException e) {
			throw new DeleteException("Id vinculado a algum livro");
		}
	}
	
	public Editora atualizar(Editora editora, Long id) {
		try {	
			Editora edit = editoraRepository.getOne(id);
			edit.setNome(editora.getNome());
			return editoraRepository.save(edit);
		}catch(EntityNotFoundException e) {
			throw new ExceptionsGerais("Id não encontrado!"); 
		}
	}
}
