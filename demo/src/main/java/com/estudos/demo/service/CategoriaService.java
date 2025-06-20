package com.estudos.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.demo.entity.Categoria;
import com.estudos.demo.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class CategoriaService {

    @SuppressWarnings("unused")
    @Autowired
    private final CategoriaRepository CategoriaRepository;

    public Categoria incluir(Categoria Categoria) {
        return CategoriaRepository.save(Categoria);
    }

    // public Categoria editar(int id,Categoria Categoria) {
    //     return CategoriaRepository.save(Categoria);
    // }
    public Categoria editar(int id, Categoria Categoria) {
        // Verifique se a Categoria existe
        Optional<Categoria> CategoriaExistente = CategoriaRepository.findById(id);
        
        if (CategoriaExistente.isPresent()) {
            // Atualiza a Categoria
            Categoria CategoriaAtualizada = CategoriaExistente.get();
            CategoriaAtualizada.setNome(Categoria.getNome());
            return CategoriaRepository.save(CategoriaAtualizada);  // Salva a Categoria atualizada
        } else {
            // Caso a Categoria não exista, retorna null
            return null;
        }
    }

    public List<Categoria> listarTodos() {
        return CategoriaRepository.findAll();
    }
    public List<Categoria> buscarPorNome(String nome){
        return CategoriaRepository.findByNome(nome);
    }
    public void excluir(Integer id) {
        CategoriaRepository.deleteById(id);
    }

}