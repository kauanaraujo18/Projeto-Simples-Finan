package com.estudos.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.demo.entity.Usuario;
import com.estudos.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class UsuarioService {

    @SuppressWarnings("unused")
    @Autowired
    private final UsuarioRepository UsuarioRepository;

    public Usuario incluir(Usuario Usuario) {
        return UsuarioRepository.save(Usuario);
    }

    // public Usuario editar(int id,Usuario Usuario) {
    //     return UsuarioRepository.save(Usuario);
    // }
    public Usuario editar(int id, Usuario Usuario) {
        // Verifique se a Usuario existe
        Optional<Usuario> UsuarioExistente = UsuarioRepository.findById(id);
        
        if (UsuarioExistente.isPresent()) {
            // Atualiza a Usuario
            Usuario UsuarioAtualizada = UsuarioExistente.get();
            UsuarioAtualizada.setNome(Usuario.getNome());
            UsuarioAtualizada.setEmail(Usuario.getEmail());  // Atualiza os campos necessários
            UsuarioAtualizada.setSenha(Usuario.getSenha());
            return UsuarioRepository.save(UsuarioAtualizada);  // Salva a Usuario atualizada
        } else {
            // Caso a Usuario não exista, retorna null
            return null;
        }
    }

    public List<Usuario> listarTodos() {
        return UsuarioRepository.findAll();
    }
    public void excluir(Integer id) {
        UsuarioRepository.deleteById(id);
    }

}