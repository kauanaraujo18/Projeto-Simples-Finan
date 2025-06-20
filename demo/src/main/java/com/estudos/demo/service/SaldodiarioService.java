package com.estudos.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.demo.entity.Saldodiario;
import com.estudos.demo.repository.SaldodiarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class SaldodiarioService {

    @SuppressWarnings("unused")
    @Autowired
    private final SaldodiarioRepository SaldodiarioRepository;

    public Saldodiario incluir(Saldodiario Saldodiario) {
        return SaldodiarioRepository.save(Saldodiario);
    }

    // public Saldodiario editar(int id,Saldodiario Saldodiario) {
    //     return SaldodiarioRepository.save(Saldodiario);
    // }
    public Saldodiario editar(int id, Saldodiario Saldodiario) {
        // Verifique se a Saldodiario existe
        Optional<Saldodiario> SaldodiarioExistente = SaldodiarioRepository.findById(id);
        
        if (SaldodiarioExistente.isPresent()) {
            // Atualiza a Saldodiario
            Saldodiario SaldodiarioAtualizada = SaldodiarioExistente.get();
            SaldodiarioAtualizada.setData(Saldodiario.getData());
            SaldodiarioAtualizada.setValor(Saldodiario.getValor());  // Atualiza os campos necessários
            return SaldodiarioRepository.save(SaldodiarioAtualizada);  // Salva a Saldodiario atualizada
        } else {
            // Caso a Saldodiario não exista, retorna null
            return null;
        }
    }

    public List<Saldodiario> listarTodos() {
        return SaldodiarioRepository.findAll();
    }
    public void excluir(Integer id) {
        SaldodiarioRepository.deleteById(id);
    }

}