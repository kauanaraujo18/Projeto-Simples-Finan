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

import com.estudos.demo.entity.Subcategoria;
import com.estudos.demo.service.SubcategoriaService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/subcategorias")
public class SubcategoriaController {
    @SuppressWarnings("unused")
    private final SubcategoriaService SubcategoriaService;
    @GetMapping
    public ResponseEntity<List<Subcategoria>> listarTodos() {
        List<Subcategoria> lista = SubcategoriaService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/buscarpornome/{nome}")
    public ResponseEntity<List<Subcategoria>> buscarpornome(@PathVariable String nome) {
        List<Subcategoria> lista = SubcategoriaService.buscarPorNome(nome);
        return ResponseEntity.ok().body(lista);
    }
    

    @PostMapping
    public ResponseEntity<Subcategoria> incluir(@RequestBody Subcategoria Subcategoria) {
        Subcategoria novo = SubcategoriaService.incluir(Subcategoria);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<Subcategoria> editar(@PathVariable int id, 
    @RequestBody Subcategoria Subcategoria) {
        Subcategoria atualizado = SubcategoriaService.editar(id,Subcategoria);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        SubcategoriaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
