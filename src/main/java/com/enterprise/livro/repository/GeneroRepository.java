package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.livro.entities.Editora;

public interface GeneroRepository extends JpaRepository<Editora, Long>{

}
