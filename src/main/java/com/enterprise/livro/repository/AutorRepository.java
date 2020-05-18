package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.livro.entities.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
