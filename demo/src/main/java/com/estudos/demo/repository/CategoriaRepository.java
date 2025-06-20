package com.estudos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.demo.entity.Categoria;
import java.util.List;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    List<Categoria> findByNome(String nome);
}