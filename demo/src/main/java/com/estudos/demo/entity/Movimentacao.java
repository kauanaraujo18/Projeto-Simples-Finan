package com.estudos.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter    

public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo", nullable = false, precision = 10, scale = 2, length = 1)
    private String tipo;
    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    @Column(name = "data", length = 50, nullable = false)
    private String data;
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    @Column(name = "categoria_id", nullable = false, precision = 10, scale = 2)
    private int categoria_id;
    @Column(name = "subcategoria_id", nullable = false, precision = 10, scale = 2)
    private int subcategoria_id;
}
