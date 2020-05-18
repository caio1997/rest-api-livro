package com.enterprise.livro.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enterprise.livro.entities.Genero;
import com.enterprise.livro.repository.GeneroRepository;
import com.enterprise.livro.services.exceptions.ExceptionsGerais;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;

	public List<Genero> findAll(){
		return generoRepository.findAll();
	}
	
	public Genero add(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Optional<Genero> findById(Long id) {
		return generoRepository.findById(id);
	}
	
	public void remove(Long id) {
		try {
			generoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionsGerais("Id não encontrado!");
		}
	}
	
	public Genero atualizar(Genero genero, Long id) {
		try {	
			Genero gen = generoRepository.getOne(id);
			gen.setGenero(genero.getGenero());
			return generoRepository.save(gen);
		}catch(EntityNotFoundException e) {
			throw new ExceptionsGerais("Id não encontrado!"); 
		}
	}
}
