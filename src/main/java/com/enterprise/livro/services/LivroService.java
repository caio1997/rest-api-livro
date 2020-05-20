package com.enterprise.livro.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enterprise.livro.entities.Livro;
import com.enterprise.livro.repository.LivroRepository;
import com.enterprise.livro.services.exceptions.ExceptionsGerais;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public List<Livro> findAll(){
		return livroRepository.findAll();
	}
	
	public Livro add(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Optional<Livro> findById(Long id) {
		//List<Genero> list = new ArrayList<>();
		//for(Genero generos : list) {
			//if(generos.getId().equals(generoRepository.findById(id))) {
					return livroRepository.findById(id);
			//}
		//}
		//throw new ExceptionIdIsNotFound("Id não encontrado");
	}
	
	public void remove(Long id) {
		try {
			livroRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionsGerais("Id não encontrado!");
		}
	}
	
	public Livro atualizar(Livro livro, Long id) {
		try {	
			Livro liv = livroRepository.getOne(id);
			liv.setTitulo(livro.getTitulo());
			liv.setAnoLancamento(livro.getAnoLancamento());
			liv.setEditora(livro.getEditora());
			liv.setGenero(livro.getGenero());
			liv.setAutor(livro.getAutor());
			return livroRepository.save(liv);
		}catch(EntityNotFoundException e) {
			throw new ExceptionsGerais("Id não encontrado!"); 
		}catch(DataIntegrityViolationException e) {
			throw new ExceptionsGerais("Id não encontrado!"); 

		}
	}
}
