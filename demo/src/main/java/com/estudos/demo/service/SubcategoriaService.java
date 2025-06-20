package com.estudos.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.demo.entity.Subcategoria;
import com.estudos.demo.repository.SubcategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class SubcategoriaService {

    @SuppressWarnings("unused")
    @Autowired
    private final SubcategoriaRepository SubcategoriaRepository;

    public Subcategoria incluir(Subcategoria Subcategoria) {
        return SubcategoriaRepository.save(Subcategoria);
    }

    // public Subcategoria editar(int id,Subcategoria Subcategoria) {
    //     return SubcategoriaRepository.save(Subcategoria);
    // }
    public Subcategoria editar(int id, Subcategoria Subcategoria) {
        // Verifique se a Subcategoria existe
        Optional<Subcategoria> SubcategoriaExistente = SubcategoriaRepository.findById(id);
        
        if (SubcategoriaExistente.isPresent()) {
            // Atualiza a Subcategoria
            Subcategoria SubcategoriaAtualizada = SubcategoriaExistente.get();
            SubcategoriaAtualizada.setNome(Subcategoria.getNome());
            return SubcategoriaRepository.save(SubcategoriaAtualizada);  // Salva a Subcategoria atualizada
        } else {
            // Caso a Subcategoria não exista, retorna null
            return null;
        }
    }

    public List<Subcategoria> listarTodos() {
        return SubcategoriaRepository.findAll();
    }
    public List<Subcategoria> buscarPorNome(String nome){
        return SubcategoriaRepository.findByNome(nome);
    }
    public void excluir(Integer id) {
        SubcategoriaRepository.deleteById(id);
    }

}