package com.estudos.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.demo.entity.Movimentacao;
import com.estudos.demo.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class MovimentacaoService {

    @SuppressWarnings("unused")
    @Autowired
    private final MovimentacaoRepository movimentacaoRepository;

    public Movimentacao incluir(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    // public Movimentacao editar(int id,Movimentacao Movimentacao) {
    //     return movimentacaoRepository.save(Movimentacao);
    // }
    public Movimentacao editar(int id, Movimentacao Movimentacao) {
        // Verifique se a Movimentacao existe
        Optional<Movimentacao> MovimentacaoExistente = movimentacaoRepository.findById(id);
        
        if (MovimentacaoExistente.isPresent()) {
            // Atualiza a Movimentacao
            Movimentacao MovimentacaoAtualizada = MovimentacaoExistente.get();
            MovimentacaoAtualizada.setTipo(Movimentacao.getTipo());
            MovimentacaoAtualizada.setValor(Movimentacao.getValor());  // Atualiza os campos necessários
            MovimentacaoAtualizada.setData(Movimentacao.getData());
            MovimentacaoAtualizada.setDescricao(Movimentacao.getDescricao());
            MovimentacaoAtualizada.setCategoria_id(Movimentacao.getCategoria_id());
            MovimentacaoAtualizada.setSubcategoria_id(Movimentacao.getSubcategoria_id());
            return movimentacaoRepository.save(MovimentacaoAtualizada);  // Salva a Movimentacao atualizada
        } else {
            // Caso a Movimentacao não exista, retorna null
            return null;
        }
    }

    public List<Movimentacao> listarTodos() {
        return movimentacaoRepository.findAll();
    }
    public void excluir(Integer id) {
        movimentacaoRepository.deleteById(id);
    }

}