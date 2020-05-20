package com.enterprise.livro.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enterprise.livro.entities.Genero;
import com.enterprise.livro.repository.GeneroRepository;
import com.enterprise.livro.services.exceptions.DeleteException;
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
		//List<Genero> list = new ArrayList<>();
		//for(Genero generos : list) {
			//if(generos.getId().equals(generoRepository.findById(id))) {
					return generoRepository.findById(id);
			//}
		//}
		//throw new ExceptionIdIsNotFound("Id não encontrado");
	}
	
	public void remove(Long id) {
		try {
			generoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionsGerais("Id não encontrado!");
		}catch(DataIntegrityViolationException e) {
			throw new DeleteException("Id vinculado a algum livro");
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
