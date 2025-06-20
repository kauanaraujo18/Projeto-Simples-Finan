package com.estudos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.demo.entity.Saldodiario;

@Repository
public interface SaldodiarioRepository extends JpaRepository<Saldodiario, Integer>{
    
}
