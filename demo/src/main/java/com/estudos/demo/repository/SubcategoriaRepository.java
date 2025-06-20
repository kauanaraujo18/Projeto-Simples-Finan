package com.estudos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.demo.entity.Subcategoria;
import java.util.List;


@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer>{
    List<Subcategoria> findByNome(String nome);
}