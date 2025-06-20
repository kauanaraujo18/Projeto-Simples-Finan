package com.estudos.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.demo.entity.Movimentacao;
import com.estudos.demo.service.MovimentacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoController {
    @SuppressWarnings("unused")
    private final MovimentacaoService movimentacaoService;
    @GetMapping
    public ResponseEntity<List<Movimentacao>> listarTodos() {
        List<Movimentacao> lista = movimentacaoService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Movimentacao> incluir(@RequestBody Movimentacao movimentacao) {
        Movimentacao novo = movimentacaoService.incluir(movimentacao);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> editar(@PathVariable int id, 
    @RequestBody Movimentacao movimentacao) {
        Movimentacao atualizado = movimentacaoService.editar(id,movimentacao);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        movimentacaoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

