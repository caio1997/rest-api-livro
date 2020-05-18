package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.livro.entities.Genero;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
