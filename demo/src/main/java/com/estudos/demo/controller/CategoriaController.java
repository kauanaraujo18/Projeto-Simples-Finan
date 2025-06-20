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

import com.estudos.demo.entity.Categoria;
import com.estudos.demo.service.CategoriaService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @SuppressWarnings("unused")
    private final CategoriaService CategoriaService;
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos() {
        List<Categoria> lista = CategoriaService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/buscarpornome/{nome}")
    public ResponseEntity<List<Categoria>> buscarpornome(@PathVariable String nome) {
        List<Categoria> lista = CategoriaService.buscarPorNome(nome);
        return ResponseEntity.ok().body(lista);
    }
    

    @PostMapping
    public ResponseEntity<Categoria> incluir(@RequestBody Categoria Categoria) {
        Categoria novo = CategoriaService.incluir(Categoria);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable int id, 
    @RequestBody Categoria Categoria) {
        Categoria atualizado = CategoriaService.editar(id,Categoria);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        CategoriaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

