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

import com.estudos.demo.entity.Saldodiario;
import com.estudos.demo.service.SaldodiarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/saldodiario")
public class SaldodiarioController {
    @SuppressWarnings("unused")
    private final SaldodiarioService SaldodiarioService;
    @GetMapping
    public ResponseEntity<List<Saldodiario>> listarTodos() {
        List<Saldodiario> lista = SaldodiarioService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Saldodiario> incluir(@RequestBody Saldodiario Saldodiario) {
        Saldodiario novo = SaldodiarioService.incluir(Saldodiario);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<Saldodiario> editar(@PathVariable int id, 
    @RequestBody Saldodiario Saldodiario) {
        Saldodiario atualizado = SaldodiarioService.editar(id,Saldodiario);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        SaldodiarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


