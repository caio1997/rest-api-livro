package com.enterprise.livro.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enterprise.livro.entities.Autor;
import com.enterprise.livro.repository.AutorRepository;
import com.enterprise.livro.services.exceptions.DeleteException;
import com.enterprise.livro.services.exceptions.ExceptionsGerais;
import com.enterprise.livro.services.exceptions.InsertIsNotFoundException;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> findAll(){
		return autorRepository.findAll();
	}
	
	public Autor add(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Optional<Autor> findById(Long id) {
		//List<Genero> list = new ArrayList<>();
		//for(Genero generos : list) {
			//if(generos.getId().equals(generoRepository.findById(id))) {
					return autorRepository.findById(id);
			//}
		//}
		//throw new ExceptionIdIsNotFound("Id não encontrado");
	}
	
	public void remove(Long id) {
		try {
			autorRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ExceptionsGerais("Id não encontrado!");
		}catch(DataIntegrityViolationException e) {
			throw new DeleteException("Id vinculado a algum livro");
		}
	}
	
	public Autor atualizar(Autor autor, Long id) {
		try {	
			Autor aut = autorRepository.getOne(id);
			aut.setNome(autor.getNome());
			aut.setDataNascimento(autor.getDataNascimento());
			aut.setNacionalidade(autor.getNacionalidade());
			aut.setSexo(autor.getSexo());
			return autorRepository.save(aut);
		}catch(EntityNotFoundException e) {
			throw new ExceptionsGerais("Id não encontrado!"); 
		}catch(DataIntegrityViolationException e) {
			throw new InsertIsNotFoundException("Inserção de item inexistente - Update incorreto"); 
		}
	}
}
