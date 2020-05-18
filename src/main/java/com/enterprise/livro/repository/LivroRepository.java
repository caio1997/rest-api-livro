package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.livro.entities.Livro;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
