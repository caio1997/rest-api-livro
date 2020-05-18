package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.livro.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
