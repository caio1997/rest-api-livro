package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.livro.entities.Genero;

public interface EditoraRepository extends JpaRepository<Genero, Long>{

}
