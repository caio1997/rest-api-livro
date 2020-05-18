package com.enterprise.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.livro.entities.Editora;
@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{

}
