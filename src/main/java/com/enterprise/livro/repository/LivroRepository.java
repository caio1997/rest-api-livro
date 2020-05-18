package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.livro.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
